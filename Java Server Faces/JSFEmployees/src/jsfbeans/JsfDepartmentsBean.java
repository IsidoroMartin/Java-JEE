package jsfbeans;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.beans.Department;
import model.service.DepartamentosService;

@ManagedBean
public class JsfDepartmentsBean {
	@ManagedProperty(value = "#{departamentos}")
	private ArrayList<Department> departamentos = null;

	public JsfDepartmentsBean() {
	}

	public JsfDepartmentsBean(ArrayList<Department> departamentos) {
		this.departamentos = departamentos;
	}

	@PostConstruct
	public void cargarDepartamentos() {
		DepartamentosService dept = new DepartamentosService();
		departamentos = (ArrayList<Department>) dept.getDepartments();
	}

	public ArrayList<Department> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(ArrayList<Department> departamentos) {
		this.departamentos = departamentos;
	}

}
