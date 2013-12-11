package tp.myapp.minibank.impl.domain.service;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import org.mycontrib.generic.converter.GenericBeanConverter;
import org.mycontrib.generic.exception.GenericException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.myapp.minibank.impl.persistence.dao.ClientDao;
import tp.myapp.minibank.impl.persistence.entity._Client;
import tp.myapp.minibank.itf.domain.dto.Client;
import tp.myapp.minibank.itf.domain.service.GestionClients;

//@Named
@Stateless
@Local
@WebService(targetNamespace="http://tp.myapp.minibank/",
            endpointInterface="tp.myapp.minibank.itf.domain.service.GestionClients")
public class GestionClientsImpl implements GestionClients {
	
	
private static Logger logger = LoggerFactory.getLogger(GestionClientsImpl.class);
	
    //@Inject (de JEE6, Spring3) ou bien @Autowired (de Spring 2.5)
    // injecte le seul composant Spring existant compatible
    // avec l'interface

	@Inject
	private ClientDao clientDao;
	
	@Inject
	private GenericBeanConverter beanConverter;

	public Client getClientByNum(long numCli) throws GenericException {
		Client cli=null;
		try {
			cli= beanConverter.convert(clientDao.getEntityById(numCli),Client.class);
			} catch (Exception e) {
			//e.printStackTrace();
			logger.error("echec GestionClientsImpl.getClientByNum",e);
			throw new GenericException("echec GestionClientsImpl.getClientByNum",e);
		}
		return cli;
	}

	@Override
	public boolean isGoodPasswordOfClient(long numClient, String password)
			throws GenericException {
		boolean res=false;
		try {
			_Client cli= clientDao.getEntityById(numClient);
			if(cli.getPassword()!=null && cli.getPassword().equals(password))
				res=true;
		} catch (Exception e) {
			logger.error("echec GestionClientsImpl.isGoodPasswordOfClient",e);
			throw new GenericException("echec GestionClientsImpl.isGoodPasswordOfClient",e);
		}
		return res;
	}

	@Override
	public void changePasswordOfClient(long numClient, String password)
			throws GenericException {
		try {
			_Client cli= clientDao.getEntityById(numClient);
			cli.setPassword(password);
			//clientDao.updateEntity(cli); pas utile car cli persistant du fait du mode Transactionnel
		} catch (Exception e) {		
			logger.error("echec GestionClientsImpl.changePasswordOfClient",e);
			throw new GenericException("echec GestionClientsImpl.changePasswordOfClient",e);
		}
	}

}
