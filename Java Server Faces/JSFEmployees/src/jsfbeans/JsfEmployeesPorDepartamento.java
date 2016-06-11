package jsfbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import model.beans.Employee;
import model.service.EmployeeService;

@ManagedBean
public class JsfEmployeesPorDepartamento {
	private String departamento;
	private List<Employee> empleados = null;
	public String cargarEmpleados() {
		System.out.println(departamento);
		EmployeeService empService = new EmployeeService();
		empleados = empService.getEmployeesByDepartment(Integer.parseInt(departamento));
		return "mostrarEmpleadosPorDepartamento";
	}

	public JsfEmployeesPorDepartamento() {
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public List<Employee> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Employee> empleados) {
		this.empleados = empleados;
	}

}
