package model.interfaces;

import model.persistencia.dao.hibernate.beans.GenericBean;

public interface CRUD {
	boolean create(GenericBean element);

	Object read(GenericBean bean);

	boolean update(GenericBean elemento);

	boolean delete(GenericBean o);
}
