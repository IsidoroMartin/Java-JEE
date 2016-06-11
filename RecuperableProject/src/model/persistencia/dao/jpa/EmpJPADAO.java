package model.persistencia.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.dtos.Employee;
import model.persistencia.interfaces.Recuperable;

public class EmpJPADAO implements Recuperable {

	@Override
	public Object obtenerEmpleado(int empId) {

		Employee emp = null;
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Empleados");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			emp = em.find(Employee.class, (long)empId);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return emp;
	}

}
