package model.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.beans.Employee;
import model.persistance.dao.jdbc.EmployeeDAO;
@Path("employeeService")
public class EmployeeService {
	EmployeeDAO dao = null;
	public EmployeeService() {
		dao = new EmployeeDAO();
	}
	@GET
	@Path("/obtenerEmployee/{employee_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee obtenerEmpleado(@PathParam("employee_id")String empId){		
		return dao.obtenerEmpleado(Integer.parseInt(empId));
	}
	public List<Employee> getEmployeesByDepartment(String name) {
		return dao.obtenerEmpleadosByDepartment(name);
	}
	public List<Employee> getEmployeesByDepartment(int id) {
		return dao.obtenerEmpleadosByDepartment(id);
	}
}
