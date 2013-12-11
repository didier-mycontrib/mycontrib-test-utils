package xxx.yyy.zzz.backoffice_test.test;

import javax.sql.DataSource;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mycontrib.generic.test.dbunit.util.DBUnitHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import xxx.yyy.zzz.backoffice_test.dao.DaoCompte;
import xxx.yyy.zzz.backoffice_test.entity._Compte;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/serviceSpringConf.xml","/dataSourceForTestSpringConf.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback=false)
public class TestDaoCompteDbUnit {
	
	 private DBUnitHelper dbUnitHelper = new DBUnitHelper();	
	 //private BasicDBUnitHelper dbUnitHelper = new BasicDBUnitHelper();	
	 @Autowired
	 public void setDataSource(DataSource dataSource){
		 dbUnitHelper.setDataSource(dataSource);
	 }
	 
	 @Autowired
	 private DaoCompte dao;
	 
	    
        @Before
	     public void setUp()
	    {
	        try {
				dbUnitHelper.reInitDataBaseFromInitialDataSet();
			} catch (Exception e) {
				e.printStackTrace();
				TestCase.fail(e.getMessage());
				
			}
	    }
        
        @Test
        public void testXY(){
        	_Compte cpt = new _Compte();
        	//cpt.setNumCpt(null); // comparaison en base avec additionalDataSet sans numCpt
        	cpt.setLabel("compte pel");
        	cpt.setSolde(75.0);
        	cpt.setProprietaire(null);
        	dao.persistNewEntity(cpt);
        	//dbUnitHelper.assertExpectedTable("Compte","expectedDataSet.xml");
        	dbUnitHelper.assertExpectedTableFromAdditionDataSet("Compte", "newCompte.xml");
        }

        


}
