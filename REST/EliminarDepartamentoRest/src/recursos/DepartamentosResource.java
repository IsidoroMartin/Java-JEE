package recursos;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import model.service.DepartamentosService;

@Path("departamentosResource")
public class DepartamentosResource {
	private DepartamentosService dep = null;

	public DepartamentosResource() {
		dep = new DepartamentosService();
	}

	@GET
	@Path("getDepartments")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDepartments() {
		Gson gson = new Gson();
		String str = gson.toJson(dep.getDepartments());
		return str;
	}

	@DELETE
	@Path("removeDepartment")///{department_id}
	@Produces(MediaType.TEXT_PLAIN)
	public String eliminarDepartamento(/*@PathParam("department_id")*/ String id) {
		String eliminado = "false";
		if (!dep.deleteDepartment(Integer.parseInt(id))) {
			eliminado = "true";
		}
		return eliminado;
	}
}
