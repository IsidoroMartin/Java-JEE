package model.service;

import java.util.List;

import model.beans.Employee;
import model.persistance.dao.jdbc.EmployeeDAO;

public class EmployeeService {
	EmployeeDAO dao = null;
	public EmployeeService() {
		dao = new EmployeeDAO();
	}
	
	public Employee obtenerEmpleado(int empId){		
		return dao.obtenerEmpleado(empId);
	}
	public List<Employee> getEmployeesByDepartmentName(String name) {
		return dao.obtenerEmpleadosByDepartment(name);
	}
	public List<Employee> getEmployeesByDepartmentName(int id) {
		return dao.obtenerEmpleadosByDepartment(id);
	}
}
