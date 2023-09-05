package fr.doranco.hibernate.model.dao.interfaces;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.model.connector.HeberniteDataSource;

public class UserDao implements IUserDao {

	private Serializable userId;

	public UserDao() {

	}

	public void addUser(User user) throws Exception {

		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			session.save(user.getAdresse());
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	
	public User getUser(int userId) throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		try {
			User user = session.find(User.class, userId);
			return user;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void updateUser(User updatedUser) throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			User user = session.find(User.class, userId);
			if (user != null) {
				session.remove(user);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void removeUser(Integer id) throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			User user = session.find(User.class, userId);
			if (user != null) {
						session.remove(user);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

}
