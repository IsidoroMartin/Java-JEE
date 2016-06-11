package model.persistencia.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.dtos.Employees;
import model.persistencia.interfaces.Recuperable;

public class EmpHiberDAO implements Recuperable {
	Session session = null;

	public EmpHiberDAO() {

	}
	@Override
	public Employees obtenerEmpleado(int empId) {
		SessionManager sm = SessionManager.getInstance();
		Employees emp= null;
		Transaction tr = null;
		try {
			session = sm.getNewSession();
			tr = session.beginTransaction();
			emp = (Employees) session.get(Employees.class, empId);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}finally{
			try {
				sm.sessionClose(session);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

}
