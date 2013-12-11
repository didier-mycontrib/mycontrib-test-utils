
package xxx.yyy.zzz.backoffice_test.dao;

import java.util.Collection;

import javax.inject.Named;
import javax.persistence.Query;

import org.mycontrib.generic.persistence.spring.GenericDaoJpaSpring;

import xxx.yyy.zzz.backoffice_test.entity._Compte;


@Named
//@Transactional inherited
public class DaoCompteImpl extends GenericDaoJpaSpring<_Compte,Long> implements DaoCompte {		
	
		
	public DaoCompteImpl() {
		super();		
	}

	@Override
	public Collection<_Compte> findComptesByNumCli(long numCli) {
		Query q= this.getEntityManager().createQuery("select c from _Compte c where c.proprietaire.numClient= :numCli");
		q.setParameter("numCli", numCli);
		return q.getResultList();
	}
	
	
}
