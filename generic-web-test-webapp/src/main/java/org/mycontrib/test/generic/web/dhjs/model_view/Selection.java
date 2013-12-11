package org.mycontrib.test.generic.web.dhjs.model_view;

import java.util.ArrayList;
import java.util.Collection;

import org.mycontrib.generic.web.annotation.AjaxOnChange;
import org.mycontrib.generic.web.annotation.DynAction;
import org.mycontrib.generic.web.annotation.DynInput;
import org.mycontrib.generic.web.annotation.DynOutput;
import org.mycontrib.generic.web.annotation.DynView;
import org.mycontrib.generic.web.annotation.DynView.ViewType;
import org.mycontrib.generic.web.annotation.SelectItemFrom;

@DynView(name="selectionBean",viewType=ViewType.IN_OUT)
public class Selection {

	@DynInput
	@SelectItemFrom(collection="listeCategories",itemKey="idCat",itemLabel="fullString")
	@AjaxOnChange(refresh="productId")
	@DynOutput
	private long categorieId; // categorie a choisir
	 
	@DynInput
	@SelectItemFrom(collection="listeProduits",itemKey="idProd",itemLabel="fullString")
	@DynOutput
	private long productId; // produit a choisir

	@DynAction
	public String doSelection()
	{
		String statut="ok";
		System.out.println("categorie choisie: " + this.categorieId);
		System.out.println("produit choisi: " + this.productId);
		return statut;
	}
	
	
	public Collection<org.mycontrib.test.generic.web.dhjs.dto.Produit> getListeProduits() {
		Collection<org.mycontrib.test.generic.web.dhjs.dto.Produit> listeProduits;
		listeProduits=new ArrayList<org.mycontrib.test.generic.web.dhjs.dto.Produit>();
		  switch((int)this.categorieId) {
		  case 0: break;
		  case 1: 
			  listeProduits.add(new org.mycontrib.test.generic.web.dhjs.dto.Produit(11,"CD1", "...." , 15.5));
			  listeProduits.add(new org.mycontrib.test.generic.web.dhjs.dto.Produit(12,"CD2", "...." , 18.5));
			  listeProduits.add(new org.mycontrib.test.generic.web.dhjs.dto.Produit(13,"CD3", "...." , 9.5));
			  break;
		  case 2: 
			  listeProduits.add(new org.mycontrib.test.generic.web.dhjs.dto.Produit(21,"DVD1", "...." , 25.5));
			  listeProduits.add(new org.mycontrib.test.generic.web.dhjs.dto.Produit(22,"DVD2", "...." , 17.5));
			  listeProduits.add(new org.mycontrib.test.generic.web.dhjs.dto.Produit(23,"DVD3", "...." , 9.5));
			  break;
		  case 3: 
			  listeProduits.add(new org.mycontrib.test.generic.web.dhjs.dto.Produit(31,"Livre1", "...." , 10.5));
			  listeProduits.add(new org.mycontrib.test.generic.web.dhjs.dto.Produit(32,"Livre2", "...." , 18.5));
			  listeProduits.add(new org.mycontrib.test.generic.web.dhjs.dto.Produit(33,"Livre3", "...." , 39.5));
			  break;
		  case 4: 
			  listeProduits.add(new org.mycontrib.test.generic.web.dhjs.dto.Produit(41,"Stylo1", "...." , 3.5));
			  listeProduits.add(new org.mycontrib.test.generic.web.dhjs.dto.Produit(42,"Stylo2", "...." , 8.5));
			  listeProduits.add(new org.mycontrib.test.generic.web.dhjs.dto.Produit(43,"Stylo3", "...." , 4.5));
			  break;
		  }
		 
		return listeProduits;
	}
	
	public Collection<org.mycontrib.test.generic.web.dhjs.dto.Categorie> getListeCategories() {
		Collection<org.mycontrib.test.generic.web.dhjs.dto.Categorie> listeCategories;
		listeCategories=new ArrayList<org.mycontrib.test.generic.web.dhjs.dto.Categorie>();
		  listeCategories.add(new org.mycontrib.test.generic.web.dhjs.dto.Categorie(1,"CD"));
		  listeCategories.add(new org.mycontrib.test.generic.web.dhjs.dto.Categorie(2,"DVD"));
		  listeCategories.add(new org.mycontrib.test.generic.web.dhjs.dto.Categorie(3,"Livre"));
		  listeCategories.add(new org.mycontrib.test.generic.web.dhjs.dto.Categorie(4,"Divers"));
		return listeCategories;
	}

	public long getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(long categorieId) {
		this.categorieId = categorieId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}



}
