package evaluacion.primera.regions.persistance;

// Importo todos los metodos y atributos de la clase querys para poder acceder a ellos directamente
import static evaluacion.primera.regions.config.Querys.*;
// Importo los posibles errores de excepciones
import static evaluacion.primera.regions.config.CodigosExceptionSQL.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import evaluacion.primera.regions.model.RegionDTO;

/**
 * Entidad encargada de realizar operaciones con la BBDD relacionadas con
 * RegionDTO
 * 
 * @author Whiteclown
 */
public class RegionDAO {
	public static Logger log = Logger.getLogger("mylog");
	private ConnectionManager conn = ConnectionManager.getInstance();

	/**
	 * Método que inserta una Region recibida por parámetro
	 * 
	 * @param r RegionDTO
	 */
	public boolean insertRegion(RegionDTO r) {// TODO
		boolean insertado= false;
		String sentencia = construirInsertRegion(r);
		Statement st = null;
		// Establezco la conexion con la bbdd
		conn.establecerConn();
		// Desactivo el auto-commit y y guardo el estado de la bbdd
		conn.commit();
		try {
			st = conn.getConnStatement();
			st.executeQuery(sentencia);
			insertado = true;
		} catch (SQLException e) {
			// En caso de que el sea una clave duplicada controlo el error
			if (e.getErrorCode() == CLAVEPRIMARIAREPETIDA) {
				log.error("La clave primaria esta duplicada. Error: "
						+ e.getMessage());
			} else {
				// En cualquier otro caso muestro el mensaje de el error y
				// realizo un rollback para devolver la bbdd al inicial
				log.error("Ha ocurrido un error al ejecutar la sentencia SQL. Error: "
						+ e.getMessage());
				conn.rollback();
			}
		} finally {
			// Ejecuto un commit para hacer los cambios efectivos y cierro la
			// conexión
			if (conn != null)
				conn.closeConn(st);
		}
		return insertado;
	}

	/**
	 * Método que ejecuta una sentecia select de todas las regiones y lo
	 * devuelve por medio de un ArrayList
	 * 
	 * @return ArrayList<RegionDTO>
	 */
	public ArrayList<RegionDTO> getRegions() {
		// Me creo un ArrayList en el que almacenar las Regiones
		ArrayList<RegionDTO> regiones = new ArrayList<RegionDTO>();
		RegionDTO regAux = null;
		Statement st = null;
		ResultSet rs = null;
		// Establezco la conexión
		conn.establecerConn();
		try {
			// Creo la sentencia
			st = conn.getConnStatement();
			// Ejecuto la sentencia
			rs = st.executeQuery(GETALLREGIONS);
			while (rs.next()) {
				// Construyo el Objeto RegionDTO
				regAux = construirRegion(rs);
				// Lo añado al ArrayList a devolver
				regiones.add(regAux);
			}
		} catch (SQLException e) {
			// En caso de que la consulta no devuelva filas controlo el error
			if (e.getErrorCode() == CONSULTASINFILASCODE) {
				log.error("La consulta no devuelve ninguna fila. Error: "
						+ e.getMessage());
			} else
				log.error("Ha ocurrido un error al ejecutar la sentencia SQL. Error: "
						+ e.getMessage());
		} finally {
			if (conn != null)
				conn.closeConn(st, rs);
		}
		return regiones;
	}

	/**
	 * Método que realiza una consulta select de la region que tiene el id
	 * pasado por parámetro.
	 * 
	 * @param id int
	 * @return RegionDTO
	 */
	public RegionDTO getRegion(int id) {
		// Me creo un ArrayList en el que almacenar las Regiones
		RegionDTO reg = null;
		Statement st = null;
		ResultSet rs = null;
		// Establezco la conexion
		conn.establecerConn();
		try {
			// Creo la sentencia
			st = conn.getConnStatement();
			// Ejecuto la sentencia
			rs = st.executeQuery(GETREGION + id);
			// Avanzo el ResultSet para poder recoger el resultado de la
			// sentencia
			rs.next();
			// Construyo el objeto RegionDTO
			reg = construirRegion(rs);

		} catch (SQLException e) {
			// En caso de que la consulta no devuelva filas controlo el error
			if (e.getErrorCode() == CONSULTASINFILASCODE) {
				log.error("La consulta no devuelve ninguna fila. Error: "
						+ e.getMessage());
			} else
				log.error("Ha ocurrido un error al ejecutar la sentencia SQL. Error: "
						+ e.getMessage());
		} finally {
			// Cierro la conexión
			if (conn != null)
				conn.closeConn(st, rs);
		}
		return reg;

	}

	/**
	 * Método que a través del ResultSet recibido por parámetro lo devuelve en
	 * forma de Objeto RegionDTO
	 * 
	 * @param rs ResultSet
	 * @return RegionDTO
	 * @throws SQLException
	 */
	private RegionDTO construirRegion(ResultSet rs) throws SQLException {
		RegionDTO reg = null;
		// Extraigo los atributos de la region del ResultSet y los almaceno en
		// variables
		int id = rs.getInt("REGION_ID");
		String nombre = rs.getString("REGION_NAME");
		// Creo un objeto de tipo RegionDTO
		reg = new RegionDTO(id, nombre);
		return reg;

	}
}
