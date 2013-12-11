package org.mycontrib.test.generic.web.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.mycontrib.generic.web.annotation.DynAction;
import org.mycontrib.generic.web.annotation.DynInput;
import org.mycontrib.generic.web.annotation.DynOutput;
import org.mycontrib.generic.web.annotation.DynView;
import org.mycontrib.generic.web.jsf.AbstractDynamicFormBean;

@ManagedBean // default name= tvaMBean
@SessionScoped
@DynView
public class TvaMBean extends AbstractDynamicFormBean{
		
	
	@DynInput
	private Double ht; 
	
	@DynInput
	private Double tauxTvaPct;
	
	@DynOutput
	private double tva;
	
	@DynOutput
	private double ttc;
	
	@DynAction
	public String calculer(){
		
		tva=ht*tauxTvaPct/100;
		ttc=ht+tva;
		System.out.println("ttc="+ttc);
		return null;
	}

	/**
	 * @return the ht
	 */
	public Double getHt() {
		return ht;
	}

	/**
	 * @param ht the ht to set
	 */
	public void setHt(Double ht) {
		this.ht = ht;
	}

	/**
	 * @return the tauxTvaPct
	 */
	public Double getTauxTvaPct() {
		return tauxTvaPct;
	}

	/**
	 * @param tauxTvaPct the tauxTvaPct to set
	 */
	public void setTauxTvaPct(Double tauxTvaPct) {
		this.tauxTvaPct = tauxTvaPct;
	}

	/**
	 * @return the tva
	 */
	public double getTva() {
		return tva;
	}

	/**
	 * @return the ttc
	 */
	public double getTtc() {
		return ttc;
	}

	
	

}
