package model.persistencia.interfaces;

import java.util.List;

import model.dto.Employees;

public interface CRUDEmpleados extends CRUD {
	public List selectEmpleadosPorDepartamento(String departamento);

	public List selectAllEmpleados();

}
