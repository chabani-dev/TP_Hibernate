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

			System.out.println(user);

		} catch (Exception e) {

			e.printStackTrace();

		}

		System.exit(0);

	}

}
