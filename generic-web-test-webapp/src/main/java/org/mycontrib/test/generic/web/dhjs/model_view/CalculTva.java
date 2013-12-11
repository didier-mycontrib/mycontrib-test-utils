package org.mycontrib.test.generic.web.dhjs.model_view;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.mycontrib.generic.web.annotation.DynAction;
import org.mycontrib.generic.web.annotation.DynInput;
import org.mycontrib.generic.web.annotation.DynOutput;
import org.mycontrib.generic.web.annotation.DynView;
import org.mycontrib.generic.web.annotation.DynView.ViewType;
import org.mycontrib.generic.web.annotation.SelectItemFrom;

@DynView(name="calculTvaBean",viewType=ViewType.IN_OUT)
public class CalculTva {
	

@DynInput
@NotNull
@Size(min=1 , message="required")
private String commentaire;	

@DynInput()
@SelectItemFrom(collection="listeDepartements",itemKey="numDep",itemLabel="fullString")
private String numDepartement;

@DynInput
@Min(0)
private double ht;

@DynInput 
@Min(0)
@Max(50)
private double taux_tva;

@DynOutput
private double tva;

@DynOutput
private double ttc;

@DynAction
public String calculerTva()
{
	String statut="ok";
	tva=ht*taux_tva/100;
	ttc=ht+tva;
	//System.out.println("tva="+tva + " , ttc=" + ttc);
	return statut;
}



@Override
public String toString() {
	return "ht="+ht+",taux_tva="+taux_tva+",tva="+tva+",ttc="+ttc+",commentaire="+commentaire+",numDep="+numDepartement;
}




public String getNumDepartement() {
	return numDepartement;
}



public void setNumDepartement(String numDepartement) {
	this.numDepartement = numDepartement;
}

public Collection<org.mycontrib.test.generic.web.dhjs.dto.Departement> getListeDepartements() {
	Collection<org.mycontrib.test.generic.web.dhjs.dto.Departement> listeDepartements;
		listeDepartements=new ArrayList<org.mycontrib.test.generic.web.dhjs.dto.Departement>();
		listeDepartements.add(new org.mycontrib.test.generic.web.dhjs.dto.Departement("75","Paris"));
		listeDepartements.add(new org.mycontrib.test.generic.web.dhjs.dto.Departement("76","Seine Maritime"));
		listeDepartements.add(new org.mycontrib.test.generic.web.dhjs.dto.Departement("60","Oise"));
		listeDepartements.add(new org.mycontrib.test.generic.web.dhjs.dto.Departement("27","Eure"));
		listeDepartements.add(new org.mycontrib.test.generic.web.dhjs.dto.Departement("80","Somme"));
	return listeDepartements;
}


public double getHt() {
	return ht;
}
public void setHt(double ht) {
	this.ht = ht;
}
public double getTaux_tva() {
	return taux_tva;
}
public void setTaux_tva(double taux_tva) {
	this.taux_tva = taux_tva;
}
public double getTva() {
	return tva;
}
public void setTva(double tva) {
	this.tva = tva;
}
public double getTtc() {
	return ttc;
}
public void setTtc(double ttc) {
	this.ttc = ttc;
}



public String getCommentaire() {
	return commentaire;
}



public void setCommentaire(String commentaire) {
	this.commentaire = commentaire;
}



}
