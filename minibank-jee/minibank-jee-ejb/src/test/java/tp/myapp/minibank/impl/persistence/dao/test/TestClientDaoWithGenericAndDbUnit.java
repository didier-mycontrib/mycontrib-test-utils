package tp.myapp.minibank.impl.persistence.dao.test;

import org.mycontrib.generic.test.ejb.GenericDaoTestWithDbUnitEjb;

import tp.myapp.minibank.impl.persistence.dao.ClientDao;
import tp.myapp.minibank.impl.persistence.entity._Client;


public class TestClientDaoWithGenericAndDbUnit extends GenericDaoTestWithDbUnitEjb<_Client,Long>{
	
	private ClientDao dao ;
	
	@Override
    public void initDao(){
		dao = initEjbServiceIfNull( dao, "ClientDaoJpa" + "Local");
		this.setGenericDao(dao);		
     }
    
    /*
    public TestClientDaoWithGenericAndDbUnit(){
    	super(); //appel indispensable au constructeur de la super classe pour declencher initialisations   	
    }
    */
	
	
	@Override
	public Long getPkOfEntity(_Client cli){
		return cli.getNumero();
	}
			
	
}
