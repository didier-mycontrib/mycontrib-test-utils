package org.mycontrib.test.generic.web.data;

public class Adresse {
	
	private String rue;
	private String codePostal;
	private String ville;
	
	
	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", codePostal=" + codePostal
				+ ", ville=" + ville + "]";
	}
	
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	

}
