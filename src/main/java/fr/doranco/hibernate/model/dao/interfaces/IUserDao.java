package fr.doranco.hibernate.model.dao.interfaces;


import fr.doranco.hibernate.entity.User;

public interface IUserDao {

	public void addUser(User user) throws Exception;

	public User getUser(int userId) throws Exception;

	public void updateUser(User user) throws Exception;

	public void removeUser(Integer id) throws Exception;
	
	
	

}
