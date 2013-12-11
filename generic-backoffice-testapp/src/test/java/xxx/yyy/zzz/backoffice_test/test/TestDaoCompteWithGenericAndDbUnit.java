package xxx.yyy.zzz.backoffice_test.test;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.mycontrib.generic.test.spring.GenericDaoTestWithDbUnitSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import xxx.yyy.zzz.backoffice_test.dao.DaoCompte;
import xxx.yyy.zzz.backoffice_test.entity._Compte;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/serviceSpringConf.xml","/dataSourceForTestSpringConf.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback=false)
public class TestDaoCompteWithGenericAndDbUnit extends GenericDaoTestWithDbUnitSpring<_Compte,Long>{
	
	private DaoCompte dao ;

	public DaoCompte getDao() {
		return dao;
	}
	
	@Autowired 
	 public void setDataSource(DataSource dataSource){
		 super.setDataSource(dataSource);
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
			
	/*
	@Override
	public void assertValuesOfNewEntity(_Compte e) {
		Assert.assertTrue(e.getNumCpt() == (Long)this.getGenericPk());
		Assert.assertTrue(e.getLabel().equals("compte pel"));
		Assert.assertEquals(e.getSolde(),75.0,0.01);
		
	}
	

	@Override
	public void assertChangedValuesOfNewEntity(_Compte entity) {
		Assert.assertEquals(entity.getSolde(),76.0,0.01);
		Assert.assertTrue(entity.getLabel().equals("compte pel updated"));
		
	}
	*/

}
