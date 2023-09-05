package fr.doranco.hibernate.model.connector;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HeberniteDataSource {
	
	
	private SessionFactory  sessionFactory ;
	private Session session;
	private static HeberniteDataSource instance;
	
	private HeberniteDataSource() {
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
	
		
	}
	
	
	public static HeberniteDataSource getInstance() {
		if (instance == null) {
			instance = new HeberniteDataSource();
		}
		return instance;
	}

	

	public Session getSession() {
		session = sessionFactory.openSession();
		
		return session;
		
	}

}
