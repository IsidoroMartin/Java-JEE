package model.servicios;

import java.util.List;

import model.persistencia.dao.InmueblesDAO;
import model.persistencia.dao.hibernate.SessionManager;
import model.persistencia.dao.hibernate.beans.Inmueble;

public class InmuebleService  extends GenericService {

	public InmuebleService() {
		dao = new InmueblesDAO();
	}
	public List obtenerInmuebles(){
		SessionManager sm = SessionManager.getInstance();
		sm.factoryStart();
		dao.setSession(sm.getNewSession());
		List<Inmueble> inmuebles = dao.getAllElements(new Inmueble()); 
		try {
			sm.sessionClose(dao.getSession());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inmuebles;
	}
}
