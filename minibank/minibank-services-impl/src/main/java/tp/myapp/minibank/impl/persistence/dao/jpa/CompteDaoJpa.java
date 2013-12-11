package tp.myapp.minibank.impl.persistence.dao.jpa;

import java.util.List;

import javax.inject.Named;
import javax.persistence.Query;

import org.mycontrib.generic.persistence.spring.GenericDaoJpaSpring;
import org.springframework.transaction.annotation.Transactional;

import tp.myapp.minibank.impl.persistence.dao.CompteDao;
import tp.myapp.minibank.impl.persistence.entity._Compte;

@Named
@Transactional
public class CompteDaoJpa extends GenericDaoJpaSpring<_Compte,Long> implements CompteDao {

	
	@Override
	public List<_Compte> findComptesByNumCli(long numCli) {		
		//query for 1-n :  "select c from _Compte c where c.proprietaire.numClient= :numCli"
	    Query q= this.getEntityManager().createQuery("select c.comptes from _Client c where c.numero= :numCli");
		q.setParameter("numCli", numCli);
		return q.getResultList();
	}

}
