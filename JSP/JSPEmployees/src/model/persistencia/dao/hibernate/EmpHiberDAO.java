package model.persistencia.dao.hibernate;

import model.beans.Employees;
import model.persistance.interfaces.Recuperable;

import org.hibernate.Session;
import org.hibernate.Transaction;



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
