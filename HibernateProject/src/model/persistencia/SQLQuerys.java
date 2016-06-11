package model.persistencia;

public class SQLQuerys {
	public static final String SELECTALLEMPLEADOS="SELECT * FROM EMPLOYEES";
	public static final String SELECTEMPLEADOSCONMAYORSALARIO="SELECT * FROM EMPLOYEES WHERE (DEPARTMENT_ID,SALARY) in (select distinct(DEPARTMENT_ID),max(salary) from employees group by DEPARTMENT_ID)";
	public static String selectPorDepartamento(String departamento) {
		return "SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID=(SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE UPPER(DEPARTMENT_NAME)='"
				+ departamento.toUpperCase() + "')";
	}
	public static String selectPorDepartamento(int department_id) {
		return "select * from employees where department_id="+department_id;
	}
}
