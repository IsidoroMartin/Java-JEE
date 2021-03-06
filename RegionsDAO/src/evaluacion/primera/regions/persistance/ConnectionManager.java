package evaluacion.primera.regions.persistance;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

//Importo todas las rutas de los ficheros de configuraci�n
import static evaluacion.primera.regions.config.ConfigFiles.*;

/**
 * Entidad encargada de realizar todas las operaciones relacionadas con la
 * conexi�n de la base de datos. La clase utiliza el patr�n Singleton
 * 
 * @author Whiteclown
 */
public class ConnectionManager {
	public static Logger log = Logger.getLogger("mylog");

	private Connection conn = null;

	private static ConnectionManager cm = new ConnectionManager();

	private String driver, host, user, pass;

	/**
	 * M�todo que devuelve una �nica instancia de la clase
	 * 
	 * @return ConnectionManager
	 */
	public static ConnectionManager getInstance() {
		return cm;
	}

	/**
	 * M�todo constructor privado
	 */
	private ConnectionManager() {
		loadDBProperties();
	}

	/**
	 * Carga los par�metros de la cadena de conexi�n desde un fichero properties
	 */
	public void loadDBProperties() {
		Properties dbProperties = new Properties();
		try {
			// Cargo el fichero de Properties
			dbProperties.load(new FileInputStream(DBPROPERTIESFILE));
			// Cargo los par�metros de la cadena de conexi�n y el driver
			driver = dbProperties.getProperty("DRIVER");
			host = dbProperties.getProperty("HOST");
			user = dbProperties.getProperty("USER");
			pass = dbProperties.getProperty("PASSWORD");

		} catch (IOException e) {
			log.error("No ha podido cargarse el fichero properties. Error: "
					+ e.getMessage());
		}
	}

	/**
	 * Guarda el estado actual de la BBDD
	 */
	public void commit() {
		try {
			// Desactivo el auto-commit para asegurar que la transacci�n se
			// realiza correctamente
			conn.setAutoCommit(false);
			// Guardo el estado de la BBDD
			conn.commit();
		} catch (SQLException e) {
			log.error("Ha habido un error al realizar el commit. Error: "
					+ e.getMessage());
		}
	}

	/**
	 * Revierte el estado de la m�quina al �ltimo punto de guardado
	 */
	public void rollback() {
		try {
			conn.rollback();
		} catch (SQLException e) {
			log.error("Ha habido un error al revertir los cambios. Error: "
					+ e.getMessage());
		}
	}

	/**
	 * M�todo que establece una conexi�n con la BBDD
	 */
	public void establecerConn() {
		try {
			// Cargo el Driver
			Class.forName(driver);
			// Inicializo la conexi�n de la clase
			conn = DriverManager.getConnection(host, user, pass);
		} catch (ClassNotFoundException e) {
			log.error("No ha podido encontrarse la clase del driver. Error: "
					+ e.getMessage());
		} catch (SQLException e) {
			log.error("Ha habido un error al establecer la conexion. Error: "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * M�todo que cierra la conexi�n Uso este m�todo para cerrar las conexiones
	 * que no requieren de un ResultSet
	 * 
	 * @param st
	 *            Statement
	 */
	public void closeConn(Statement st) {
		try {
			conn.commit();
		} catch (SQLException e) {
			log.error("Ha habido un error al finalizar la transaccion. Error: "
					+ e.getMessage());
			e.printStackTrace();
		}
		if (this.conn != null) {
			try {
				this.conn.close();

			} catch (SQLException e) {
				log.error("Ha habido un error al cerrar la conexion. Error: "
						+ e.getMessage());
				e.printStackTrace();
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					log.error("Ha habido un error al cerrar la sentencia. Error: "
							+ e.getMessage());
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * M�todo que cierra la conexi�n Uso este m�todo para cerrar las conexiones
	 * que requieren de un ResultSet
	 * 
	 * @param st Statement
	 */
	public void closeConn(Statement st, ResultSet rs) {
		closeConn(st);
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				log.error("Ha habido un error al cerrar el ResultSet. Error: "
						+ e.getMessage());
				e.printStackTrace();
			}
		}
	}

	/**
	 * Recogo la Sentencia correspondiente a la conexi�n activa
	 * 
	 * @return Statement
	 * @throws SQLException
	 */
	public Statement getConnStatement() throws SQLException {
		return conn.createStatement();
	}
}
