package model.persistencia.dao;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import model.dto.Countries;
import model.dto.Regions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class RegionsDAO {
	static Configuration configuration = new Configuration().configure();
	static StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
			.applySettings(configuration.getProperties());
	static SessionFactory factory = null;
	static Session session = null;
	static Connection conn = null;

	/**
	 * Método que recupera todos los empleados pertenecientes al departamento de
	 * ventas
	 * 
	 * @return ArrayList<Employees>
	 */
	public static void getCountries() {
		if (factory == null) {
			factory = configuration.buildSessionFactory(builder.build());
		}

		Transaction transaction = null;
		try {
			if (conn != null) {
				session.reconnect(conn);
			} else {
				session = factory.openSession();
			}
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Regions> list = session
					.createSQLQuery("SELECT * FROM REGIONS")
					.addEntity(Regions.class).list();
			Iterator<Regions> it = list.iterator();
			Regions reg;
			while (it.hasNext()) {
				reg = it.next();
				System.out.println(reg);
				Iterator<Countries> itRegs = reg.getCountrieses().iterator();
				while (itRegs.hasNext()) {
					System.out.println(" -"+itRegs.next());
				}
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();// si algo ha ido mal, deshago la transacción
		} finally {
			session.close();
			factory.close();
		}

	}

}
