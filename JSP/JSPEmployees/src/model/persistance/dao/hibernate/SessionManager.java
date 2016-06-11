package model.persistance.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionManager {
	private static SessionManager sm = new SessionManager();
	private static SessionFactory factory = null;
	
	static{
		factoryStart();
	}
	public static void factoryStart() {
		 Configuration configuration = new Configuration().configure();
		 StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		if (factory == null) {
			factory = configuration.buildSessionFactory(builder.build());
		}
	}

	private SessionManager() {
	}

	public static SessionManager getInstance() {
		return sm;
	}
	public boolean comprobarEstadoFactory() {
		return (factory!=null);
	}

	public Session getNewSession() {
		return factory.openSession();
	}
	public void sessionClose(Session session) throws Throwable {
		session.close();
	}
	public static void factoryClose() throws Throwable {
		factory.close();
	}
}