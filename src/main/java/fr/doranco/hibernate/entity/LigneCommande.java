package fr.doranco.hibernate.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "ligneCommande")
public class LigneCommande implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id ;
	
	@Column(name = "titreArticle" , length = 25, nullable= false)
	private String titreArticle ;
	
	
	@Column(name = "prixArticle" , length = 25, nullable = false)
	private Float prixArticle;
	
	
	@Column(name= "quantite" , nullable = false)
	private int quantite;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
	private List<LigneCommande> listesligneCommandes;
		
	public LigneCommande() {
		
	}

	public LigneCommande(int id, String titreArticle, Float prixArticle, int quantite,
			List<LigneCommande> listesligneCommandes) {

		this.id = id;
		this.titreArticle = titreArticle;
		this.prixArticle = prixArticle;
		this.quantite = quantite;
		this.listesligneCommandes = listesligneCommandes;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitreArticle() {
		return titreArticle;
	}


	public void setTitreArticle(String titreArticle) {
		this.titreArticle = titreArticle;
	}


	public Float getPrixArticle() {
		return prixArticle;
	}


	public void setPrixArticle(Float prixArticle) {
		this.prixArticle = prixArticle;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public List<LigneCommande> getListesligneCommandes() {
		return listesligneCommandes;
	}


	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", titreArticle=" + titreArticle + ", prixArticle=" + prixArticle
				+ ", quantite=" + quantite + ", listesligneCommandes=" + listesligneCommandes + "]";
	}


	
	
	
	

}
