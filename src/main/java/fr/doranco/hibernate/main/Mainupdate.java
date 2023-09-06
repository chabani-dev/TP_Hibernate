package fr.doranco.hibernate.main;

import fr.doranco.hibernate.entity.Adresse;
import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.model.dao.interfaces.IUserDao;
import fr.doranco.hibernate.model.dao.interfaces.UserDao;
import fr.doranco.hibernate.utils.Dates;

public class Mainupdate {

	public static void main(String[] args) {
		
		try {
			IUserDao userDao = new UserDao();
			userDao.getUser(1);
			user.setNom("zarga");
            user.getAdresse().setVille("créteil");
            userDao.updateUser(user); 
            System.out.println(user);
            
            

	}catch (Exception e) {

		e.printStackTrace();

	}

	System.exit(0);

}

}
