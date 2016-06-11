package model.persistencia.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import static model.persistencia.SQLQuerys.*;
import model.dto.Employees;
import model.persistencia.interfaces.CRUDEmpleados;

public class EmpleadosDAO extends GenericDAO implements CRUDEmpleados {
	/**
	 * Método que recupera todos los empleados pertenecientes al departamento de
	 * ventas
	 * 
	 * @return ArrayList<Employees>
	 */
	public EmpleadosDAO() {

	}

	@SuppressWarnings("unchecked")
	public List<Employees> selectEmpleadosPorDepartamento(String departamento) {
		ArrayList<Employees> emples = new ArrayList<Employees>();
		List<Employees> list = session
				.createSQLQuery(selectPorDepartamento(departamento))
				.addEntity(Employees.class).list();
		Iterator<Employees> it = list.iterator();
		Employees emp;
		while (it.hasNext()) {
			emp = it.next();
			emples.add(emp);
		}
		return emples;
	}
	@SuppressWarnings("unchecked")
	public List<Employees> selectEmpleadosPorDepartamento(int departamento) {
		ArrayList<Employees> emples = new ArrayList<Employees>();
		List<Employees> list = session
				.createSQLQuery(selectPorDepartamento(departamento))
				.addEntity(Employees.class).list();
		Iterator<Employees> it = list.iterator();
		Employees emp;
		while (it.hasNext()) {
			emp = it.next();
			emples.add(emp);
		}
		return emples;
	}

	@Override
	public List<Employees> selectAllEmpleados() {
		ArrayList<Employees> emples = new ArrayList<Employees>();
		@SuppressWarnings("unchecked")
		List<Employees> list = session.createSQLQuery(SELECTALLEMPLEADOS)
				.addEntity(Employees.class).list();
		Iterator<Employees> it = list.iterator();
		Employees emp;
		while (it.hasNext()) {
			emp = it.next();
			emples.add(emp);
		}
		return emples;
	}
	
	public List<Employees> selectEmpleadosMayorSalario() {
		ArrayList<Employees> emples = new ArrayList<Employees>();
		@SuppressWarnings("unchecked")
		List<Employees> list = session.createSQLQuery(SELECTEMPLEADOSCONMAYORSALARIO)
		.addEntity(Employees.class).list();
		Iterator<Employees> it = list.iterator();
		Employees emp;
		while (it.hasNext()) {
			emp = it.next();
			emples.add(emp);
		}
		return emples;
	}
}
