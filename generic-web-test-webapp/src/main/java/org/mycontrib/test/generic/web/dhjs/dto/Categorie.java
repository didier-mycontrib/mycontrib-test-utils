package org.mycontrib.test.generic.web.dhjs.dto;

public class Categorie {
	private long idCat;
	private String label;
	

	public Categorie() {
		super();
	}
	
	
	public Categorie(long idCat, String label) {
		super();
		this.idCat = idCat;
		this.label = label;
	}
	
	public String toString(){
		return "["+idCat+"]"+label;
	}
	
	public String getFullString(){
		return toString();
	}


	public long getIdCat() {
		return idCat;
	}


	public void setIdCat(long idCat) {
		this.idCat = idCat;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
	
	

}
