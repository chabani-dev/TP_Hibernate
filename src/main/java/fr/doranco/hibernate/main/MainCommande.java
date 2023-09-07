package fr.doranco.hibernate.main;

import fr.doranco.hibernate.entity.Commande;
import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.model.dao.interfaces.CommandeDao;
import fr.doranco.hibernate.model.dao.interfaces.UserDao;

public class MainCommande {

	public static void main(String[] args) {
		
		 try {
	            UserDao UserDao = new UserDao();
	            CommandeDao commandeDao = new CommandeDao();

	            /*
	             * User user = new User("Camus", "Albert", "albert@gmail.com", "albert",
	             * Dates.convertstringToDate("07/11/1913"));
	             * 
	             * 
	             */
	            User user = UserDao.getUser(1);
	            Commande commande1 = new Commande(3);
	            Commande commande2 = new Commande(5);

	            /*
	             * user.getCommande().add(commande2); user.getCommande().add(commande1);
	             */
	            commande1.setUser(user);
	            commande2.setUser(user);
	            
	            commandeDao.addCommande(commande1);
	            commandeDao.addCommande(commande2);

	            /*
	             * UserDao.addUser(user);
	             */
	            System.out.println(commande1);
	            System.out.println(commande2);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        System.exit(0);
	    }

}
