package tp.myapp.minibank.impl.domain;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import tp.myapp.minibank.itf.domain.FacadeMiniBank;
import tp.myapp.minibank.itf.domain.service.GestionClients;
import tp.myapp.minibank.itf.domain.service.GestionComptes;

/*
 * NB: cette implementation "EJB" de la façade (à utiliser coté client web) doit
 * être extérieurement agnostique (sans spécificité EJB)
 * et sera instancié via un simple new ou bien newInstance() d'une fabrique
 * ---> pas de @EJB non interprété mais lookup
 */
public class FacadeMiniBankImpl implements FacadeMiniBank {
	

	private GestionComptes serviceGestionComptes;	
	
	
	private GestionClients serviceGestionClients;	
	
	private void initServicesViaJeeLookup(){
		try {
			InitialContext ic  = new InitialContext();
			String sGComptesJndiName="java:app/minibank-jee-ejb/GestionComptesImpl!tp.myapp.minibank.itf.domain.service.GestionComptes";
		    System.out.println("lookup() with " + sGComptesJndiName);
			serviceGestionComptes = (GestionComptes) ic.lookup(sGComptesJndiName);
			String sGClientsJndiName="java:app/minibank-jee-ejb/GestionClientsImpl!tp.myapp.minibank.itf.domain.service.GestionClients";
			System.out.println("lookup() with " + sGClientsJndiName);
			serviceGestionClients= (GestionClients) ic.lookup(sGClientsJndiName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public FacadeMiniBankImpl(){
		initServicesViaJeeLookup();
	}
	
	
	
	@Override
	public GestionComptes getServiceGestionComptes() {
		return serviceGestionComptes;
	}

	@Override
	public GestionClients getServiceGestionClients() {
		return serviceGestionClients;
	}
	
	

}
