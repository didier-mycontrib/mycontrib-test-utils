package tp.myapp.web.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import tp.myapp.minibank.itf.domain.dto.Compte;
import tp.myapp.minibank.itf.domain.service.GestionComptes;

//@ManagedBean
@Named
@RequestScoped //CDI(javax.enterprise.context)
public class Virement {
	
	private Long numCptDeb;
	private Long numCptCred;
	private Double montant;
	
	//@EJB
	@Inject
	private GestionComptes serviceGestionComptes;
	
	public List<SelectItem> getComptesPossibles(){
		 List<SelectItem> comptesPossibles = new ArrayList<SelectItem>();
		 for(Compte cpt : clientComptes.getListeComptes()){
			 comptesPossibles.add(new SelectItem(cpt.getNumero(),cpt.toString())); 
		 }
		 return comptesPossibles;
	}
	
	public String effectuerVirement(){
		String suite=null;
		try {
			//effectuer le virement
			serviceGestionComptes.transferer(montant, numCptDeb, numCptCred);
		    //reactualiser les soldes:
			clientComptes.actualiserListeComptes();
			//message:
			clientComptes.setMessage("virement bien effectué : " +montant +" du compte " + numCptDeb +  " vers le compte " + numCptCred);
			suite="listeComptes"; //.jsp		
		} catch (Exception e) {
			clientComptes.setMessage("echec identification - " + e.getMessage());
		}
		return suite;
	}
	
	
	
	//@ManagedProperty(value="#{clientComptes}")
	@Inject
	private ClientComptes clientComptes;

	public ClientComptes getClientComptes() {
		return clientComptes;
	}

	public void setClientComptes(ClientComptes clientComptes) {
		this.clientComptes = clientComptes;
	}

	public Long getNumCptDeb() {
		return numCptDeb;
	}

	public void setNumCptDeb(Long numCptDeb) {
		this.numCptDeb = numCptDeb;
	}

	public Long getNumCptCred() {
		return numCptCred;
	}

	public void setNumCptCred(Long numCptCred) {
		this.numCptCred = numCptCred;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
	

}
