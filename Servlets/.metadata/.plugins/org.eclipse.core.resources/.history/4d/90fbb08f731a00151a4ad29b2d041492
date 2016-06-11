package model.persistencia.dao.jdbc;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.dtos.Employee;
import model.persistencia.interfaces.Recuperable;
import static model.persistencia.querys.QuerysEmpleado.*;

public class EmpJDBCDAO implements Recuperable {
	private GestorBBDD gbbdd = null;

	public EmpJDBCDAO() {
		gbbdd = new GestorBBDD();
	}

	@Override
	public Employee obtenerEmpleado(int empId) {
		gbbdd.establecerConn();
		Employee e=null;
		Statement st = null;
		ResultSet rs = null;
		try {
			st = gbbdd.getConn().createStatement();
			rs = st.executeQuery(GETEMPLEADO+empId);
			if(rs.next()){
				e = new Employee(
						rs.getLong("EMPLOYEE_ID"),
						rs.getBigDecimal("DEPARTMENT_ID"),
						rs.getString("EMAIL"),rs.getString("FIRST_NAME"),
						rs.getString("LAST_NAME"),
						rs.getBigDecimal("SALARY")
						);
				
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}finally{
			gbbdd.closeConn(st, rs);
		}
		return e;
	}
}
