package model.servicios;

import java.util.List;

import model.persistencia.dao.EstadosDAO;
import model.persistencia.dao.hibernate.SessionManager;
import model.persistencia.dao.hibernate.beans.Estado;

public class EstadosService extends GenericService {
	
	public EstadosService() {
		dao = new EstadosDAO();
	}
	
	public List<Estado> obtenerEstados(){
		SessionManager sm = SessionManager.getInstance();
		sm.factoryStart();
		dao.setSession(sm.getNewSession());
		List<Estado> estados = dao.getAllElements(new Estado()); 
		try {
			sm.sessionClose(dao.getSession());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return estados;
	}
}
