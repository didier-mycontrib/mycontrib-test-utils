package tp.myapp.web.mbean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import tp.myapp.minibank.itf.domain.dto.Operation;
import tp.myapp.minibank.itf.domain.service.GestionComptes;

//@ManagedBean
@Named
@RequestScoped //CDI(javax.enterprise.context)
public class Operations {
	
	
	private Long numCpt;
	private List<Operation> listeOperations;
	
	//@EJB
	@Inject
	private GestionComptes serviceGestionComptes;
	
	
	/*version mode GET (JSF2 , facelet) */
	public void initOperations(){
		try {
			System.out.println("initOperations (mode GET / JSF2 / facelet) , numCpt="+numCpt);
			//numCpt initialized by <f:viewParam name="numCptSel" value="#{operations.numCpt}"/>
			listeOperations=serviceGestionComptes.getOperationsOfCompte(numCpt);
		} catch (Exception e) {
			e.printStackTrace();		
		}		
	}
	
	
	
	public Long getNumCpt() {
		return numCpt;
	}

	public void setNumCpt(Long numCpt) {
		this.numCpt = numCpt;
	}

	public List<Operation> getListeOperations() {
		return listeOperations;
	}

	public void setListeOperations(List<Operation> listeOperations) {
		this.listeOperations = listeOperations;
	}

	
	
	
	

}
