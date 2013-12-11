package org.mycontrib.test.generic.web.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.mycontrib.generic.web.annotation.DynAction;
import org.mycontrib.generic.web.annotation.DynInput;
import org.mycontrib.generic.web.annotation.DynOutput;
import org.mycontrib.generic.web.annotation.DynView;
import org.mycontrib.generic.web.jsf.AbstractDynamicFormBean;
import org.mycontrib.test.generic.web.data.Adresse;

@ManagedBean // default name= inscriptionMBean
@SessionScoped
@DynView
public class InscriptionMBean extends AbstractDynamicFormBean {
	
	@DynInput
	private String nom;
	
	@DynInput
	private String prenom;
	
	@DynInput
	private Adresse adresse=new Adresse();
	
	@DynOutput
	private String message;
	
	@DynAction
	public String inscription(){
		message="inscription nom="+nom+",prenom="+prenom+",adresse="+adresse;
		System.out.println(message);
		return null;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
