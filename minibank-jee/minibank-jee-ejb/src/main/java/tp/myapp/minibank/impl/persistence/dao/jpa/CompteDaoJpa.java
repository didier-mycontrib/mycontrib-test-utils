package tp.myapp.minibank.impl.persistence.dao.jpa;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import org.mycontrib.generic.persistence.common.jpa.GenericDaoJpaImpl;

import tp.myapp.minibank.impl.persistence.dao.CompteDao;
import tp.myapp.minibank.impl.persistence.entity._Compte;

//@Named
@Local
@Stateless
public class CompteDaoJpa extends GenericDaoJpaImpl<_Compte,Long> implements CompteDao {

	
	@Override
	public List<_Compte> findComptesByNumCli(long numCli) {		
		//query for 1-n :  "select c from _Compte c where c.proprietaire.numClient= :numCli"
	    Query q= this.getEntityManager().createQuery("select c.comptes from _Client c where c.numero= :numCli");
	    // requete ok avec hibernate , pose problème à OpenJpa
		q.setParameter("numCli", numCli);
		return q.getResultList();
		
		
	}

}
