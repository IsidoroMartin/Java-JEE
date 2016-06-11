package model.servicios;

import model.persistencia.dao.GenericDAO;
import model.persistencia.dao.hibernate.SessionManager;
import model.persistencia.dao.hibernate.beans.DetalleInmueble;
import model.persistencia.dao.hibernate.beans.Estado;
import model.persistencia.dao.hibernate.beans.FotosDetalleInmueble;
import model.persistencia.dao.hibernate.beans.FotosInmueble;
import model.persistencia.dao.hibernate.beans.GenericBean;
import model.persistencia.dao.hibernate.beans.Inmueble;
import model.persistencia.dao.hibernate.beans.TipoUsuario;

public class GenericService {
	protected GenericDAO dao = null;

	public boolean create(GenericBean elemento) {
		boolean insertado = false;
		SessionManager sm = SessionManager.getInstance();
		sm.factoryStart();
		dao.setSession(sm.getNewSession());
		insertado = dao.create(elemento);
		try {
			sm.sessionClose(dao.getSession());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return insertado;
	}

	public Object read(GenericBean bean) {
		SessionManager sm = SessionManager.getInstance();
		sm.factoryStart();
		Object elemento = null;
		dao.setSession(sm.getNewSession());
		elemento =(GenericBean) dao.read(bean);
		try {
			sm.sessionClose(dao.getSession());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return elemento;
	}

	public boolean update(GenericBean elemento) {
		boolean actualizado = false;
		SessionManager sm = SessionManager.getInstance();
		sm.factoryStart();
		dao.setSession(sm.getNewSession());
		try {
			actualizado = dao.update(elemento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actualizado;
	}

	public boolean delete(GenericBean o) {
		boolean borrado = false;
		SessionManager sm = SessionManager.getInstance();
		sm.factoryStart();
		dao.setSession(sm.getNewSession());
		try {
			borrado = dao.delete(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return borrado;
	}

}
