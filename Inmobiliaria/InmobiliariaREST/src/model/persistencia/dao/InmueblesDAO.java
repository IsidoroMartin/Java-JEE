package model.persistencia.dao;

import model.persistencia.dao.hibernate.beans.GenericBean;
import model.persistencia.dao.hibernate.beans.Inmueble;

public class InmueblesDAO extends GenericDAO {
	@Override
	public Object read(GenericBean bean) {
		Inmueble inmueble = (Inmueble) super.read(bean);
		inmueble.setEstado(inmueble.getEstado());
		return inmueble;
	}
}
