package view;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import model.persistencia.dao.hibernate.SessionManager;
import model.persistencia.dao.hibernate.beans.Estado;
import model.persistencia.dao.hibernate.beans.Inmueble;
import model.persistencia.dao.hibernate.beans.Usuarios;
import model.servicios.EstadosService;
import model.servicios.InmuebleService;

public class Main {
	public static void main(String[] args) {
		EstadosService er = new EstadosService();
		List<Estado> estados = er.obtenerEstados();
		Iterator<Estado> it = estados.iterator();
		while (it.hasNext()) {
			Estado e = it.next();
			System.out.println(e.getIdEstado());
			System.out.println(e.getDescripcion());
		}
		InmuebleService is = new InmuebleService();
		// List<Inmueble> inmuebles = is.obtenerInmuebles();
		// Iterator<Inmueble> it2 = inmuebles.iterator();
		// while(it2.hasNext()){
		// Inmueble i = it2.next();
		// Set detalles = i.getDetalleInmuebles();
		// System.out.println(i.getIdInmueble()+" "+i.getDireccion()
		// +" "+i.getCodPostal());
		// System.out.println(detalles.size());
		// }
		System.out.println(new Inmueble().getClass().getSimpleName());
		System.out.println(((Inmueble)is.read(new Inmueble(1))).toString());

		try {
			SessionManager.factoryClose();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
