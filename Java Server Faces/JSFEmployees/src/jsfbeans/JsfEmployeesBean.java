package jsfbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import model.beans.Employee;
import model.service.EmployeeService;

@ManagedBean
public class JsfEmployeesBean {
	private int empleado_id;
	private Employee empleado = null;
	
	public JsfEmployeesBean() {
	
	}

	
	public String cargarEmpleado() {
		EmployeeService empService = new EmployeeService();
		empleado = (Employee) empService.obtenerEmpleado(empleado_id);
		
		return "mostrarEmployee";
	}

	public Employee getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Employee empleado) {
		this.empleado = empleado;
	}

	public int getEmpleado_id() {
		return empleado_id;
	}

	public void setEmpleado_id(int empleado_id) {
		this.empleado_id = empleado_id;
	}
	
}
