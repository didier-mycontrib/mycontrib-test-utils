package tp.myapp.minibank.itf.domain.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.mycontrib.generic.exception.GenericException;

import tp.myapp.minibank.itf.domain.dto.Compte;
import tp.myapp.minibank.itf.domain.dto.Operation;

@WebService(targetNamespace="http://tp.myapp.minibank/")
public interface GestionComptes {
	
	public Compte getCompteByNum(@WebParam(name="numCpt")long numCpt) throws GenericException;
	
	//NB: le type de retour List<? extends Compte> pose des problemes au niveau de JAX-WS 
	// et complexifie inutilement de code --> le eventuel heritage Entity/DTO ne doit etre que interne
	public List<Compte> getComptesOfClient(@WebParam(name="numClient")long numClient) 
			                    throws GenericException;
	
	public List<Operation> getOperationsOfCompte(@WebParam(name="numCpt")long numCpt) 
			throws GenericException;
	
	public void transferer(@WebParam(name="montant")double montant,
			@WebParam(name="numCptDeb")long numCptDeb,@WebParam(name="numCptCred")long numCptCred) 
			throws GenericException;

}
