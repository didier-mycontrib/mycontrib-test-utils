package tp.myapp.minibank.impl.domain.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import org.mycontrib.generic.converter.GenericBeanConverter;
import org.mycontrib.generic.exception.GenericException;
import org.mycontrib.generic.service.internal.GenericInternalService;
import org.mycontrib.generic.service.internal.common.GenericInternalServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.myapp.minibank.impl.persistence.dao.ClientDao;
import tp.myapp.minibank.impl.persistence.dao.CompteDao;
import tp.myapp.minibank.impl.persistence.entity._Compte;
import tp.myapp.minibank.impl.persistence.entity._Operation;
import tp.myapp.minibank.itf.domain.dto.Compte;
import tp.myapp.minibank.itf.domain.dto.Operation;
import tp.myapp.minibank.itf.domain.service.GestionComptes;

//@Named
@Stateless
@Local
@WebService(targetNamespace="http://tp.myapp.minibank/",
endpointInterface="tp.myapp.minibank.itf.domain.service.GestionComptes")
public class GestionComptesImpl implements GestionComptes {
	
	private static Logger logger = LoggerFactory.getLogger(GestionComptesImpl.class);
	
	private GenericInternalService<Compte,Long> genericInternalService =null;
	
	@PostConstruct  //@Post initialization(s) after injection
	protected void initGenericInternalService(){
		genericInternalService = new GenericInternalServiceImpl<Compte,_Compte,Long>(compteDao,beanConverter,logger){};
		// new instance of anonymous inner class witch inherit of GenericSuperClass
	}
	
	@Inject
	private CompteDao compteDao;
	
	@Inject
	private ClientDao clientDao;
	
	@Inject
	private GenericBeanConverter beanConverter;
	

	public Compte getCompteByNum(long numCpt) throws GenericException {
		Compte c=null;
		try {
			c= genericInternalService.getDtoById(numCpt);
		} catch (Exception e) {
			//e.printStackTrace();
			throw new GenericException("echec getCompteByNum",e);
		}
		return c;
	}

	@Override
	public List<Compte> getComptesOfClient(long numClient)
			throws GenericException {		
		List<Compte> listeCpt = null;
		try {
			listeCpt = beanConverter.convertList(
					/*compteDao.findComptesByNumCli(numClient)*/ clientDao.findComptesByNumCli(numClient), Compte.class);
		} catch (Exception e) {
			logger.error("echec GestionComptesImpl.getComptesOfClient",e);
			throw new GenericException("echec GestionComptesImpl.getComptesOfClient",e);
		}
		return listeCpt;
	}
	
	

	@Override
	public void transferer(double montant, long numCptDeb, long numCptCred)
			throws GenericException {
		try {
			_Compte cptDeb = compteDao.getEntityById(numCptDeb);
			cptDeb.setSolde(cptDeb.getSolde() - montant);
			cptDeb.addOperation(new _Operation("debit virement",-montant));
			//compteDao.updateEntity(cptDeb);//inutile si cptDeb est persistant (du fait de @Transactional)
			_Compte cptCred = compteDao.getEntityById(numCptCred);
			cptCred.setSolde(cptCred.getSolde() + montant);
			cptCred.addOperation(new _Operation("credit virement",+montant));
			//compteDao.updateEntity(cptCred);//inutile si cptCred est persistant (du fait de @Transactional)
		} catch (Exception e) {
			logger.error("echec GestionComptesImpl.transferer",e);
			throw new GenericException("echec GestionComptesImpl.transferer",e);
		}

	}

	
	public List<Operation> getOperationsOfCompte(long numCpt)
			throws GenericException {
		List<Operation> listeOp = null;
		try {
			_Compte cpt= compteDao.getEntityById(numCpt);
			listeOp = beanConverter.convertList(cpt.getOperations(), Operation.class);
		} catch (Exception e) {
			logger.error("echec GestionComptesImpl.getOperationsOfCompte",e);
			throw new GenericException("echec GestionComptesImpl.getgetOperationsOfCompte",e);
		}
		return listeOp;
	}

}
