package xxx.yyy.zzz.backoffice_test.test;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mycontrib.generic.test.spring.GenericDaoSimpleTestSpring;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import xxx.yyy.zzz.backoffice_test.dao.DaoCompte;
import xxx.yyy.zzz.backoffice_test.entity._Compte;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/serviceSpringConf.xml","/dataSourceForTestSpringConf.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback=false)
public class TestDaoCompteWithGeneric extends GenericDaoSimpleTestSpring<_Compte,Long>{
	
	private DaoCompte dao ;

	public DaoCompte getDao() {
		return dao;
	}

	@Inject
	public void setDao(DaoCompte dao) {
		this.dao = dao;
		this.setGenericDao(dao);
	}
	
	@Override
	public Long getPkOfEntity(_Compte cpt){
		return cpt.getNumCpt();
	}
	
	@Override
	public _Compte newEntity(){
		_Compte cpt = new _Compte();
		cpt.setLabel("compte abc");
        cpt.setSolde(300.0);
        return cpt;
	}
	
	
	@Override
	public void assertValuesOfNewEntity(_Compte e) {
		Assert.assertTrue(e.getNumCpt() == (Long)this.getGenericPk());
		Assert.assertTrue(e.getLabel().equals("compte abc"));
		Assert.assertEquals(e.getSolde(),300.0,0.01);
		
	}
	

	@Override
	public void changeValuesOfEntity(_Compte entity) {
		entity.setSolde(500.8);
		
	}

	@Override
	public void assertChangedValuesOfNewEntity(_Compte entity) {
		Assert.assertEquals(entity.getSolde(),500.8,0.01);
		
	}
	
	@Test
	public void testGetById(){
	     _Compte cpt = dao.getEntityById(1L);
	     Assert.assertTrue(cpt.getNumCpt()==1L);
	}
	

}
