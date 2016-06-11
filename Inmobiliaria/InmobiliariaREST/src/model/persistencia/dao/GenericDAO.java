package model.persistencia.dao;

import java.util.List;

import model.interfaces.CRUD;
import model.persistencia.dao.hibernate.beans.DetalleInmueble;
import model.persistencia.dao.hibernate.beans.Estado;
import model.persistencia.dao.hibernate.beans.FotosDetalleInmueble;
import model.persistencia.dao.hibernate.beans.FotosInmueble;
import model.persistencia.dao.hibernate.beans.GenericBean;
import model.persistencia.dao.hibernate.beans.Inmueble;
import model.persistencia.dao.hibernate.beans.TipoUsuario;
import model.persistencia.dao.hibernate.beans.Usuarios;
import model.persistencia.dao.hibernate.querys.GenericQuerys;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericDAO implements CRUD {
	protected Session session = null;

	public GenericDAO() {

	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public boolean create(GenericBean elemento) {
		boolean insertado = false;
		Transaction transaccion = null;
		try {
			transaccion = session.beginTransaction();
			session.save(elemento);
			transaccion.commit();
			insertado = true;
		} catch (Exception e) {
			transaccion.rollback();
			e.printStackTrace();
		}
		return insertado;
	}

	public Object read(GenericBean bean) {
		Object elemento = null;
		int id = obtenerClassId(bean);
		try {
			elemento = (GenericBean) session.get(bean.getClass(), id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elemento;
	}

	public boolean update(GenericBean bean) {
		boolean actualizado = false;
		Transaction transaccion = null;
		try {
			transaccion = session.beginTransaction();
			if (read(bean) != null) {
				session.merge(bean); // || update
				transaccion.commit();
				actualizado = true;
			}

		} catch (Exception e) {
			transaccion.rollback();
			e.printStackTrace();
		}
		return actualizado;
	}

	public boolean delete(GenericBean bean) {
		boolean borrado = false;
		Transaction transaccion = null;
		try {
			transaccion = session.beginTransaction();
			if (read(bean) != null) {
				session.delete(bean);
				transaccion.commit();
				borrado = true;
			}
		} catch (Exception e) {
			transaccion.rollback();
			e.printStackTrace();
		}
		return borrado;
	}

	/**
	 * TODO Am i crazy? preguntar a val
	 * 
	 * @param o
	 * @return
	 */
	public List getAllElements(GenericBean o) {
		return session
				.createSQLQuery(
						GenericQuerys.GETALLELEMENTS
								+ o.getClass().getSimpleName())
				.addEntity(o.getClass()).list();
	}

	private int obtenerClassId(GenericBean bean) {
		int id = -1;
		Object instancia = null;
		switch (bean.getClass().getSimpleName()) {
		case "DetalleInmueble":
			id = ((DetalleInmueble) bean).getIdDetalleInmueble();
			break;
		case "Estado":
			id = ((Estado) bean).getIdEstado();
			break;
		case "FotosDetalleInmueble":
			id = ((FotosDetalleInmueble) bean).getIdFotosDetalleInmueble();
			break;
		case "FotosInmueble":
			id = ((FotosInmueble) bean).getIdFotosInmueble();
			break;
		case "Inmueble":
			id = ((Inmueble) bean).getIdInmueble();
			break;
		case "TipoUsuario":
			id = ((TipoUsuario) bean).getIdTipoUsuario();
			break;
		case "Usuarios":
			id = ((Usuarios) bean).getIdUsuario();
			break;
		}
		return id;
	}

}
