package org.mycontrib.test.generic.web.dhjs.dto;

public class Produit {
	private long idProd;
	private String label;
	private String caracteristiques;
	private double prix;
	

	public Produit() {
		super();
	}
	
	
	public Produit(long idProd, String label, String caracteristiques, double prix) {
		super();
		this.idProd = idProd;
		this.label = label;
		this.caracteristiques=caracteristiques;
		this.prix=prix;
	}
	
	public String toString(){
		return "["+idProd+"]"+label+"("+prix+" euros)";
	}
	
	public String getFullString(){
		return toString();
	}



	public long getIdProd() {
		return idProd;
	}


	public void setIdProd(long idProd) {
		this.idProd = idProd;
	}


	public String getCaracteristiques() {
		return caracteristiques;
	}


	public void setCaracteristiques(String caracteristiques) {
		this.caracteristiques = caracteristiques;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
	
	

}
