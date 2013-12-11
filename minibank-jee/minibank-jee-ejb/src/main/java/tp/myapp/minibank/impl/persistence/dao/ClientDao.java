package tp.myapp.minibank.impl.persistence.dao;

import java.util.List;

import org.mycontrib.generic.persistence.GenericDao;

import tp.myapp.minibank.impl.persistence.entity._Client;
import tp.myapp.minibank.impl.persistence.entity._Compte;

public interface ClientDao extends GenericDao<_Client,Long> {
	public List<_Compte> findComptesByNumCli(long numCli);

}
