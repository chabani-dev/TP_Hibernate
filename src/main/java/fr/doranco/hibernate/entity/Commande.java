package fr.doranco.hibernate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commande")
public class Commande implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "numero", length = 4, nullable = false)
	private String numero;
	
	@Column(name= "date_Commande" , nullable = false)
	@Temporal(TemporalType.DATE)
	private  Date dateCommande;
	
	
	@Column(name= "date_livraison" , nullable = false)
	@Temporal(TemporalType.DATE)
	private String dateLivraison;
	
	
	public Commande() {
		
	}

	public Commande(int id, String numero, Date dateCommande, String dateLivraison) {
	
		this.id = id;
		this.numero = numero;
		this.dateCommande = dateCommande;
		this.dateLivraison = dateLivraison;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Date getDateCommande() {
		return dateCommande;
	}


	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}


	public String getDateLivraison() {
		return dateLivraison;
	}


	public void setDateLivraison(String dateLivraison) {
		this.dateLivraison = dateLivraison;
	}


	@Override
	public String toString() {
		return "Commande [id=" + id + ", numero=" + numero + ", dateCommande=" + dateCommande + ", dateLivraison="
				+ dateLivraison + "]";
	}
	
	
	
	

}
