package fr.doranco.hibernate.model.dao.interfaces;



import java.util.List;
import java.util.Map;

import fr.doranco.hibernate.entity.User;

public interface IUserDao {

	public void addUser(User user) throws Exception;

	public User getUser(int userId) throws Exception;

	public void updateUser(User user) throws Exception;

	public void removeUser(Integer id) throws Exception;
	
	public List<User> getUsers() throws Exception;
	
	public User getUserByEmail(String email) throws Exception;
	
	public List<User> getUsersOfVille(String ville)throws Exception;
	
	public Map<String, List<User>> getUsersByVille(String ville)throws Exception;
	
	 
	 
	 
	
	
	

}
