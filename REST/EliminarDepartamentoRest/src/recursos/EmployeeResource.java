package recursos;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import model.beans.Employee;
import model.persistance.dao.jdbc.EmployeeDAO;
@Path("employeeResource")
public class EmployeeResource {
	EmployeeDAO dao = null;
	public EmployeeResource() {
		dao = new EmployeeDAO();
	}
	@GET
	@Path("/obtenerEmployee/{employee_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String obtenerEmpleado(@PathParam("employee_id") int empId){
		Gson gson = new Gson();
		String str = gson.toJson(dao.obtenerEmpleado(empId));
		return str;
	}
//	public List<Employee> getEmployeesByDepartment(String name) {
//		return dao.obtenerEmpleadosByDepartment(name);
//	}
//	public List<Employee> getEmployeesByDepartment(int id) {
//		return dao.obtenerEmpleadosByDepartment(id);
//	}
}
