package fr.doranco.hibernate.model.dao.interfaces;

import java.util.List;

import fr.doranco.hibernate.entity.Commande;



public interface ICommandeDao {
	
	public Commande  getCommande(Integer id) throws Exception;
	
	
	public void addCommande(Commande  commande) throws Exception;

	public void updateCommande (Commande commande) throws Exception;

	public void removeCommande(Integer id) throws Exception;
	
	public List<Commande> getCommandes1(int id) throws Exception;
	
	public List<Commande> getCommandes2() throws Exception;
	
	public List<Commande> getCommandes3() throws Exception;
	

}
