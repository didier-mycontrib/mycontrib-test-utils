package tp.myapp.minibank.impl.persistence.dao.test;

import org.mycontrib.generic.test.ejb.GenericDaoTestWithDbUnitEjb;

import tp.myapp.minibank.impl.persistence.dao.CompteDao;
import tp.myapp.minibank.impl.persistence.entity._Compte;

public class TestCompteDaoWithGenericAndDbUnit extends GenericDaoTestWithDbUnitEjb<_Compte,Long>{
	
	private CompteDao dao ;

	
	@Override
    public void initDao(){
		dao = initEjbServiceIfNull( dao, "CompteDaoJpa" + "Local");
		this.setGenericDao(dao);		
     }
	
	@Override
	public Long getPkOfEntity(_Compte cpt){
		return cpt.getNumero();
	}
			
	
}
