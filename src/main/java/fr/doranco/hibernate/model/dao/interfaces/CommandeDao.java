package fr.doranco.hibernate.model.dao.interfaces;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import fr.doranco.hibernate.entity.Commande;
import fr.doranco.hibernate.model.connector.HeberniteDataSource;

public class CommandeDao implements ICommandeDao {

	@Override
	public Commande getCommande(Integer id) throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Commande commande = null;

		try {
			commande = session.find(Commande.class, id);
			return commande;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void addCommande(Commande commande) throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			session.save(commande);
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

//	@Override
//	public void updateCommande(Commande commande) throws Exception {
//		Session session = HeberniteDataSource.getInstance().getSession();
//		Transaction tx = null;
//
//		try {
//
//			tx = session.beginTransaction();
//			session.update(commande);
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//		} finally {
//			if (session != null && session.isOpen()) {
//				session.close();
//			}
//		}
//	
//	}

	@Override
	public void removeCommande(Commande commande) throws Exception {

		if (commande == null) {
			throw new NullPointerException("La commande à supprimer ne doit pas être NULL !");
		}

		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Commande c = session.find(Commande.class, commande.getId());
			if (c == null) {
				throw new NullPointerException("La commande à supprimer n'existe pas !");
			}
			session.remove(commande);
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

	// version 1 // avec requete JPQL
	public List<Commande> getCommandes1() throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;
		List<Commande> commandes;

		try {
			tx = session.beginTransaction();
			String jpql = "SELECT c FROM Commande c JOIN FETCH c.ligneCommande lc WHERE lc.id = :id";
			Query<Commande> query = session.createQuery(jpql, Commande.class);
			//query.setParameter("id", id);
			commandes = query.getResultList();
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

		return commandes;
	}

	@Override

	// version 2 // avec requête prédéfinie

	public List<Commande> getCommandes2() throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;
		List<Commande> commandes;
		try {
			tx = session.beginTransaction();

			// Utiliser une requête prédéfinie
			Query<Commande> query = session.createNamedQuery("Commande.findAll", Commande.class);

			commandes = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		return commandes;
	}

	@Override
	// version 3 // avec requête SQL

	public List<Commande> getCommandes3() throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;
		List<Commande> commandes;

		try {
			tx = session.beginTransaction();
			String sqlQuery = "SELECT * FROM Commande";
			NativeQuery<Commande> query = session.createNativeQuery(sqlQuery, Commande.class);
			commandes = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}

		return commandes;
	}

}
