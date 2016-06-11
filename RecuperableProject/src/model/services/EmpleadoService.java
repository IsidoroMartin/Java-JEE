package model.services;

import model.dtos.Employee;
import model.persistencia.interfaces.Recuperable;

public class EmpleadoService {
	Recuperable dao = null;
	public EmpleadoService(Recuperable dao) {
		this.dao= dao;
	}
	public void setDao(Recuperable dao) {
		this.dao = dao;
	}
	public Object getEmployee(int empId){		
		return dao.obtenerEmpleado(empId);
	}
	
	
	
}
