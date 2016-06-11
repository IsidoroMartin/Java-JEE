package model.persistencia.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.dto.Employees;
import model.dto.GenericDTO;
import model.persistencia.SessionManager;
import model.persistencia.dao.EmpleadosDAO;

import org.apache.log4j.Logger;
import org.hibernate.Transaction;

public class EmpleadoService{
	private static Logger log = Logger.getLogger("mylog");
	private EmpleadosDAO empDAO = null;

	public EmpleadoService ()  {
		this.empDAO = new EmpleadosDAO();
	}
	public boolean almacenarEmpleado(Employees object) throws Throwable {
		boolean almacenado = false;
		SessionManager sm = SessionManager.getInstance();
		Transaction transaction = null;
		try {
			empDAO.setSession(sm.getNewSession());
			transaction = empDAO.getSession().beginTransaction();
			almacenado = empDAO.create(object);
			transaction.commit();
		} catch (Exception e) {
			log.error("No se ha podido almacenar el empleado");
			log.error("Ha ocurrido un error durante la transacción Error: "+e.getMessage());
			transaction.rollback();
		} finally {
			sm.sessionClose(empDAO.getSession());
		}
		return almacenado;
	}

	public Employees obtenerEmpleado(Employees o) throws Throwable {
		Employees empleado = null;
		SessionManager sm = SessionManager.getInstance();
		Transaction transaction = null;
		try {
			empDAO.setSession(sm.getNewSession());
			transaction = empDAO.getSession().beginTransaction();
			empleado = (Employees) empDAO.read(o);
			transaction.commit();
		} catch (Exception e) {
			log.error("No se ha podido obtener el empleado");
			log.error("Ha ocurrido un error durante la transacción Error: "+e.getMessage());
			transaction.rollback();
		} finally {
			sm.sessionClose(empDAO.getSession());
		}
		return empleado;
	}

	public boolean actualizarEmpleado(Employees object) throws Throwable {
		boolean actualizado = false;
		SessionManager sm = SessionManager.getInstance();
		Transaction transaction = null;
		try {
			empDAO.setSession(sm.getNewSession());
			transaction = empDAO.getSession().beginTransaction();
			actualizado = empDAO.update(object);
			transaction.commit();
		} catch (Exception e) {
			log.error("No se ha podido actualizar el empleado");
			log.error("Ha ocurrido un error durante la transacción Error: "+e.getMessage());
			transaction.rollback();
		} finally {
			sm.sessionClose(empDAO.getSession());
		}
		return actualizado;
	}

	public boolean borrarEmpleado(Employees object) throws Throwable {
		boolean borrado = false;
		SessionManager sm = SessionManager.getInstance();
		Transaction transaction = null;
		try {
			empDAO.setSession(sm.getNewSession());
			transaction = empDAO.getSession().beginTransaction();
			borrado = empDAO.delete(object);
			transaction.commit();
		} catch (Exception e) {
			log.error("No se ha podido borrar el empleado");
			log.error("Ha ocurrido un error durante la transacción Error: "+e.getMessage());
			transaction.rollback();
		} finally {
			sm.sessionClose(empDAO.getSession());
		}
		return borrado;
	}
	@SuppressWarnings("static-access")
	public List<Employees> obtenerEmpleados() throws Throwable {
		SessionManager sm = SessionManager.getInstance();
		ArrayList<Employees> emples = null;
		Transaction transaction = null;
		try {
			empDAO.setSession(sm.getNewSession());
			transaction = empDAO.getSession().beginTransaction();
			emples = (ArrayList<Employees>) empDAO.selectAllEmpleados();
			transaction.commit();
		} catch (Exception e) {
			log.error("No se ha podido obtener los empleados");
			log.error("Ha ocurrido un error durante la transacción Error: "+e.getMessage());
			transaction.rollback();// si algo ha ido mal, deshago la transacción
		} finally {
			sm.sessionClose(empDAO.getSession());
		}
		return emples;
	}
	@SuppressWarnings("static-access")
	public void obtenerEmpleadosMayorSalarioPorDepartmento() throws Throwable {
		SessionManager sm = SessionManager.getInstance();
		ArrayList<Employees> emples = null;
		Transaction transaction = null;
		try {
			empDAO.setSession(sm.getNewSession());
			transaction = empDAO.getSession().beginTransaction();
			emples = (ArrayList<Employees>) empDAO.selectEmpleadosMayorSalario();
			transaction.commit();
			for (Employees employee : emples) {
				System.out.println(employee);
			}
		} catch (Exception e) {
			log.error("No se ha podido obtener los empleados");
			log.error("Ha ocurrido un error durante la transacción Error: "+e.getMessage());
			transaction.rollback();// si algo ha ido mal, deshago la transacción
		} finally {
			sm.sessionClose(empDAO.getSession());
			
		}
	}
	@SuppressWarnings("static-access")
	public List<Employees> obtenerEmpleadosPorDepartmento(String departamento) throws Throwable {
		SessionManager sm = SessionManager.getInstance();
		ArrayList<Employees> emples = null;
		Transaction transaction = null;
		try {
			empDAO.setSession(sm.getNewSession());
			transaction = empDAO.getSession().beginTransaction();
			emples = (ArrayList<Employees>) empDAO.selectEmpleadosPorDepartamento(departamento);
			transaction.commit();
		} catch (Exception e) {
			log.error("No se ha podido obtener los empleados");
			log.error("Ha ocurrido un error durante la transacción Error: "+e.getMessage());
			transaction.rollback();// si algo ha ido mal, deshago la transacción
		} finally {
			sm.sessionClose(empDAO.getSession());
		}
		return emples;
	}
	@SuppressWarnings("static-access")
	public List<Employees> obtenerEmpleadosPorDepartmento(int departamento) throws Throwable {
		SessionManager sm = SessionManager.getInstance();
		ArrayList<Employees> emples = null;
		Transaction transaction = null;
		try {
			empDAO.setSession(sm.getNewSession());
			transaction = empDAO.getSession().beginTransaction();
			emples = (ArrayList<Employees>) empDAO.selectEmpleadosPorDepartamento(departamento);
			transaction.commit();
		} catch (Exception e) {
			log.error("No se ha podido obtener los empleados");
			log.error("Ha ocurrido un error durante la transacción Error: "+e.getMessage());
			transaction.rollback();// si algo ha ido mal, deshago la transacción
		} finally {
			sm.sessionClose(empDAO.getSession());
		}
		return emples;
	}

	/**
	 * Método que modifica el salario de todos los empleados del departamento de
	 * ventas y devuelve un boolean indicando si la modificación se ha realizado
	 * con éxito
	 * 
	 * @param porcentaje BigDecimal
	 * @return boolean
	 * @throws Throwable Exception
	 */
	@SuppressWarnings("static-access")
	public boolean modificarSalariosVentas(BigDecimal porcentaje,
			String departamento) throws Throwable {
		boolean incrementado = false;
		SessionManager sm = SessionManager.getInstance();
		Transaction transaction = null;
		try {
			empDAO.setSession(sm.getNewSession());
			System.out.println(empDAO.getSession());
			transaction = empDAO.getSession().beginTransaction();
			List<Employees> empleados = empDAO
					.selectEmpleadosPorDepartamento(departamento);
			setSalarios(porcentaje, departamento, empleados);
			incrementado = true;
			transaction.commit();
		} catch (Exception e) {
			log.error("No se ha podido modificar los salarios");
			log.error("Ha ocurrido un error durante la transacción Error: "+e.getMessage());
			transaction.rollback();
		} finally {
			sm.sessionClose(empDAO.getSession());
		}
		return incrementado;
	}

	@SuppressWarnings("static-access")
	private void setSalarios(BigDecimal porcentaje, String departamento,
			List<Employees> empleados) throws Throwable {
		Employees empleado = null;
		BigDecimal salario = null;
		Iterator<Employees> it = empleados.iterator();
		while (it.hasNext()) {
			empleado = it.next();
			if (empleado.getDepartments().getDepartmentName().toUpperCase()
					.equals(departamento.toUpperCase())) {
				salario = empleado.getSalary();
				empleado.setSalary(salario.multiply(porcentaje));
				// session.merge(empleado);
				System.out.println("Old: " + salario + " ----- Incrementado: "
						+ empleado.getSalary());
				System.out.println(empleado + "---");
			}
		}
	}
}
