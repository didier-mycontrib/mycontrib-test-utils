package tp.myapp.minibank.itf.domain.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.mycontrib.generic.exception.GenericException;

import tp.myapp.minibank.itf.domain.dto.Client;

@WebService(targetNamespace="http://tp.myapp.minibank/")
public interface GestionClients {
	
	public Client getClientByNum(@WebParam(name="numCli")long numCli)
			throws GenericException;
	
	public boolean isGoodPasswordOfClient(@WebParam(name="numClient")long numClient,
										@WebParam(name="password")String password)
												throws GenericException;
	
	public void changePasswordOfClient(@WebParam(name="numClient")long numClient,
									@WebParam(name="password")String password)
											throws GenericException;

}
