package model.persistencia.interfaces;

import model.dtos.Employee;

public interface Recuperable {
	public Object obtenerEmpleado(int empId);
}
