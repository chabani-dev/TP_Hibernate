package fr.doranco.hibernate.main;

import fr.doranco.hibernate.entity.Adresse;
import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.model.dao.interfaces.IUserDao;
import fr.doranco.hibernate.model.dao.interfaces.UserDao;
import fr.doranco.hibernate.utils.Dates;

public class MainUser {

	public static void main(String[] args) {

		try {

			User user = new User();
			user.setNom("CAMUS");
			user.setPrenom("Albert");
			user.setEmail("camus@gmail.com");
			user.setPassword("camuccamus");
			user.setDateNaissance(Dates.convertStringToDate("24/01/2000"));
			user.setActive(true);

			Adresse adresse = new Adresse("18", "Rue Lafayette", "Paris", "75000");
			user.setAdresse(adresse);
			
			IUserDao userDao = new UserDao();
			userDao.addUser(user);
			
			
			 User user1  = new User (); 
			  int userId = 1; 
			    User user1 =  userDao.getUser(userId);
			   
						    
			    // Affichez les détails de l'utilisateur s'il a été trouvé
			    if (user1 != null) {
			        System.out.println("Utilisateur trouvé :");
			        System.out.println("ID : " + user1.getId());
			        System.out.println("Nom : " + user1.getNom()); 
			        System.out.println("Email : " + user1.getEmail()); 
			       System.out.println("Data_naissance : " + user1.getDateNaissance());
			    } else {
			        System.out.println("Utilisateur non trouvé pour l'ID : " + userId);
			    }
			
			System.out.println(user);
			System.out.println(user.getAdresse());
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}

		System.exit(0);

	}

	
	

}
