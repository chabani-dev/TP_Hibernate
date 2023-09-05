package fr.doranco.hibernate.main;



import org.hibernate.Session;

import fr.doranco.hibernate.model.connector.HeberniteDataSource;

public class Main {

	public static void main(String[] args) {
		
		try {
			
		Session session = HeberniteDataSource.getInstance().getSession();
	
	System.out.println("Session Hibernate ouverte avec  succès : " + session);
			
		}catch (Exception e ) {
			
			e.printStackTrace();
		}
	

	}

}
