package org.mycontrib.test.generic.web.dhjs.dto;

public class Departement {
	private String numDep;
	private String nomDep;
	//private String prefecture;
	
	
	
	public String getNumDep() {
		return numDep;
	}
	

	public Departement() {
		super();
	}
	
	
	public Departement(String numDep, String nomDep) {
		super();
		this.nomDep = nomDep;
		this.numDep = numDep;
	}
	public void setNumDep(String numDep) {
		this.numDep = numDep;
	}
	public String getNomDep() {
		return nomDep;
	}
	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}
	
	public String toString(){
		return "["+numDep+"]"+nomDep;
	}
	
	public String getFullString(){
		return toString();
	}
	
	
	
	

}
