package model.persistencia.dao;

import java.sql.Connection;
import model.dto.Employees;
import model.dto.GenericDTO;
import model.persistencia.interfaces.CRUD;

import org.hibernate.Session;

public class GenericDAO implements CRUD {
	protected Session session = null;
	protected Connection conn = null;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean create(GenericDTO o) {
		boolean insertado = false;
		session.save(o);
		insertado = true;
		return insertado;
	}

	@Override
	public boolean update(GenericDTO o) {
		boolean existe = false;
		session.merge(o);
		existe = true;
		return existe;
	}

	@Override
	public boolean delete(GenericDTO o) {
		boolean borrado = false;
		session.delete(o);
		borrado = true;
		return borrado;
	}

	@Override
	public GenericDTO read(GenericDTO pk) {
		GenericDTO object = null;
		if(pk instanceof Employees){
			object = (Employees) session.get(pk.getClass(), ((Employees)pk).getEmployeeId());
		}
		return object;

	}

}
