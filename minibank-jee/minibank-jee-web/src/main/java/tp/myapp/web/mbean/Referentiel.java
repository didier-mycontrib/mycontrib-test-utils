package tp.myapp.web.mbean;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import tp.myapp.minibank.itf.domain.FacadeMiniBank;
import tp.myapp.minibank.itf.domain.FacadeMiniBankFactory;
import tp.myapp.minibank.itf.domain.service.GestionClients;
import tp.myapp.minibank.itf.domain.service.GestionComptes;
import tp.myapp.web.cdi.qualifier.ViaFacade;


/*
 * référentiel des services métiers
 * pour éventuel usage sans injection :
 *    referentiel.getServiceGestionClients().getClientByNum();
 *    ...
 */

//@ManagedBean
@Named
@ApplicationScoped //CDI(javax.enterprise.context)
public class Referentiel {
	
	private FacadeMiniBank facadeMiniBank;
	
	public Referentiel(){
		facadeMiniBank = FacadeMiniBankFactory.getInstance();
	}

	public FacadeMiniBank getFacadeMiniBank() {
		return facadeMiniBank;
	}
	
	@Produces //CDI
	@ViaFacade //CDI Qualifier not @Default
	/* NB: access indirect au service(EJB) via Referentiel et facade 
	   inutile si aucune valeur ajoutée comme ici mais potentiellement utile
	   si intermédiaire avec qualifier de type @Cache */
	public GestionClients getServiceGestionClients(){
		System.out.println("ServiceGestionClients via referentiel");
		return facadeMiniBank.getServiceGestionClients();
	}
	
	@Produces //CDI
	@ViaFacade //CDI Qualifier not @Default
	/* NB: access indirect au service(EJB) via Referentiel et facade 
	   inutile si aucune valeur ajoutée comme ici mais potentiellement utile
	   si intermédiaire avec qualifier de type @Cache */
	public GestionComptes getServiceGestionComptes(){
		System.out.println("ServiceGestionComptes via referentiel");
		return facadeMiniBank.getServiceGestionComptes();
	}
	
	

}
