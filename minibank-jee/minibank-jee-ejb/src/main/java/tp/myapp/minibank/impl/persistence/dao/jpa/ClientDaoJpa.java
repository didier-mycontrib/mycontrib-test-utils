package tp.myapp.minibank.impl.persistence.dao.jpa;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.mycontrib.generic.persistence.common.jpa.GenericDaoJpaImpl;

import tp.myapp.minibank.impl.persistence.dao.ClientDao;
import tp.myapp.minibank.impl.persistence.entity._Client;
import tp.myapp.minibank.impl.persistence.entity._Compte;

//@Named
@Stateless
@Local
public class ClientDaoJpa  extends GenericDaoJpaImpl<_Client,Long> implements ClientDao {

	public List<_Compte> findComptesByNumCli(long numCli) {		
		_Client c = this.getEntityById(numCli);
		return c.getComptes();
	}
	
}
