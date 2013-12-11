package xxx.yyy.zzz.backoffice_test.service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.mycontrib.generic.converter.GenericBeanConverter;
import org.mycontrib.generic.service.internal.GenericInternalService;
import org.mycontrib.generic.service.internal.common.GenericInternalServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import xxx.yyy.zzz.backoffice_test.dao.DaoCompte;
import xxx.yyy.zzz.backoffice_test.dto.Compte;
import xxx.yyy.zzz.backoffice_test.entity._Compte;

@Named
@Transactional
public class GestionComptesImpl implements GestionComptes {
	
	private GenericInternalService<Compte,Long> genericInternalService =null;
	
	@PostConstruct  //@Post initialization(s) after injection
	protected void initGenericInternalService(){
		genericInternalService = new GenericInternalServiceImpl<Compte,_Compte,Long>(cptDao,beanConverter){};
		// new instance of anonymous inner class witch inherit of GenericSuperClass
	}
	   
	@Inject
	private GenericBeanConverter beanConverter;
	
	@Inject
	private DaoCompte cptDao; //inherit of GenericDao<_Compte,Long>
	
	@Override
	public Compte rechercherCompteParNumero(long num) {
		return genericInternalService.getDtoById(num);
	}

	@Override
	public void majCompte(Compte cpt) {
		genericInternalService.updateEntityFromDto(cpt);
	}

	@Override
	public Long creerNouveauCompte(Compte cpt) {
		return genericInternalService.persistIdNewEntityFromDto(cpt);
	}

	@Override
	public void supprimerCompte(long numero) {
		cptDao.deleteEntity(numero);
	}

}
