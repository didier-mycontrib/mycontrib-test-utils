
package xxx.yyy.zzz.backoffice_test.dao;

import java.util.Collection;

import org.mycontrib.generic.persistence.GenericDao;

import xxx.yyy.zzz.backoffice_test.entity._Compte;


public interface DaoCompte extends GenericDao<_Compte,Long> {
	public Collection<_Compte> findComptesByNumCli(long numCli);
	
}
