
package xxx.yyy.zzz.backoffice_test.test;
//Start of user code java_imports
	import java.util.Collection;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import xxx.yyy.zzz.backoffice_test.dao.DaoCompte;
import xxx.yyy.zzz.backoffice_test.entity._Compte;

	
//End of user code
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/serviceSpringConf.xml","/dataSourceForTestSpringConf.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback=false)
public class TestDaoCompte { 

	private DaoCompte dao = null; // dao a tester
	//Start of user code pk
	private Long pk; // clef primaire pour test CRUD (ajuster le type si nacessaire)
	//End of user code

	@Inject
	public void setDao(DaoCompte dao) {
		this.dao = dao;
	}       

	//Start of user code test_DaoCompte_specific_methods
	@Test
    public void test_DaoCompte_specific_methods() {
 
     try{
        System.out.println("test_DaoCompte_specific_methods");
        Collection<_Compte> comptes = dao.findComptesByNumCli(1L);
        System.out.println("comptes du client 1 :");
        for(_Compte cpt : comptes){
        	System.out.println("\t"+cpt);
        }
        }catch(RuntimeException ex){
      	    System.err.println(ex.getMessage());
      	    Assert.fail(ex.getMessage());
      	}
    }
    //End of user code
    
    @Test
	public void testDaoCompte_CRUD() {
		//************* version sans grande transaction globale (plein de petites transactions)
    	//              persistant, detache , persistant, detachea , ....
    	//              pas d'affichage sophistique (probleme sur lazy=true)
    	//******************************************************************
		System.out.println("****** test CRUD sur Compte avec plusieurs petites transactions (via DAO DaoCompte) *****");
		// sequence habituelle : new & save , get(All) , maj , update , get , delete , ...
		boolean withDeep=false;
		sequence_crud_Compte(withDeep);
		System.out.println("****** end of CRUD test avec plusieurs petites transactions *****\n");
	}
    
    @Test
	@Transactional
	public void testDaoCompte_CRUD_InOneTx() {
		//************* version avec grande transaction globale (de bout en bout a l'etat persistant)
    	//              affichages sophistiques possibles (pas de probleme avec lazy=true)
    	//******************************************************************
		System.out.println("****** test CRUD sur Compte en une seule transaction (via DAO DaoCompte) *****");
		// sequence habituelle : new & save , get(All) , maj , update , get , delete , ...
		boolean withDeep=true;
		sequence_crud_Compte(withDeep);
		System.out.println("****** end of CRUD test en une seule transaction *****\n");
	}
              
    private void sequence_crud_Compte(boolean withDeep){
		createCompte(withDeep); verifNewCompte(withDeep);
		updateCompte(withDeep); verifUpdateCompte(withDeep); 
		deleteCompte(withDeep); verifDeleteCompte(withDeep);
	}
	private void createCompte(boolean withDeep) {
		//Start of user code testCreateCompte
		try {
		    _Compte newEntity = new _Compte();
	        newEntity.setLabel("compte abc");
	        newEntity.setSolde(300.0);
	        if(withDeep){
	        // eventuelles liaisions avec d'autres entites
	        }
			dao.persistNewEntity(newEntity); // appel d'une methode transactionnelle
			this.pk = (Long)newEntity.getPk();
			if(withDeep)
			     System.out.println("\t id(pk) du nouveau Compte cree: " + pk);
			} catch(RuntimeException ex){
      	    	System.err.println(ex.getMessage());
      	    	Assert.fail(ex.getMessage());
      			}
		//End of user code
		}
		
		private void verifNewCompte(boolean withDeep) {
		//Start of user code verifNewCompte
		_Compte e=null;
			try {
			e = dao.getEntityById(this.pk);
			Assert.assertTrue(e.getNumCpt() == (Long)this.pk);
			Assert.assertTrue(e.getLabel().equals("compte abc"));
			Assert.assertEquals(e.getSolde(),300.0,0.01);
			  if(withDeep){
			    System.out.println("\t valeurs initiales de l'entite (creee): " + e.toString());
			    // eventuel test ou affichage d'un element (ou collection) lie(e) - lazy=true ? 
			  }
			} catch(RuntimeException  ex){
      	    	System.err.println(ex.getMessage());
      	    	Assert.fail(ex.getMessage());
      		}
		//End of user code
		}
					
		private void updateCompte(boolean withDeep) {
		//Start of user code testUpdateCompte
		_Compte e=null;
		try {
			e = dao.getEntityById(this.pk);
			e.setSolde(500.8);
			if(withDeep){
			    // eventuelle modification d'une liaison avec une autre entite
			  }
		    dao.updateEntity(e);  // appel d'une methode transactionnelle
		    } catch(Exception /*ServiceException*/ ex){
      	    	System.err.println(ex.getMessage());
      	    	Assert.fail(ex.getMessage());
      		}
        	//End of user code	
		}
		
		
		private void verifUpdateCompte(boolean withDeep) {
		//Start of user code verifUpdateCompte
		_Compte e=null;
			try {
			e = dao.getEntityById(this.pk);
			Assert.assertEquals(e.getSolde(),500.8,0.01);
			if(withDeep){
				System.out.println("\t nouvelle valeur de l'entite (modifiee): " + e.toString());
			    // + eventuel test ou affichage d'un element (ou collection) lie(e) - lazy=true ? 
			  }
			} catch(RuntimeException  ex){
      	    	System.err.println(ex.getMessage());
      	    	Assert.fail(ex.getMessage());
      		}
		//End of user code
		}
		    	    
		private void deleteCompte(boolean withDeep) {
		//Start of user code testDeleteCompte
		try {
			dao.deleteEntity(this.pk);
			} catch(RuntimeException  ex){
      	    	System.err.println(ex.getMessage());
      	    	Assert.fail(ex.getMessage());
      		}
        //End of user code			
		}   
		
	
		private void verifDeleteCompte(boolean withDeep) {
		//Start of user code verifDeleteCompte
		try {
			_Compte e = dao.getEntityById(this.pk);
			if(e==null && withDeep)
			     System.out.println("\t entite bien supprimee");
			Assert.assertTrue(e == null);
		} catch(RuntimeException ex){
      	    	System.err.println(ex.getMessage());
      	    	Assert.fail(ex.getMessage());
      		}
        //End of user code
	   }
    
}
