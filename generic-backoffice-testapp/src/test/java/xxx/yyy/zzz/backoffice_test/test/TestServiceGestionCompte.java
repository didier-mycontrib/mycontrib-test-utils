
package xxx.yyy.zzz.backoffice_test.test;
//Start of user code java_imports
	import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xxx.yyy.zzz.backoffice_test.dto.Compte;
import xxx.yyy.zzz.backoffice_test.service.GestionComptes;

	
//End of user code
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/serviceSpringConf.xml","/dataSourceForTestSpringConf.xml"})
public class TestServiceGestionCompte { 

	@Inject
	private GestionComptes serviceGC = null; // service a tester
	
	@Test
	public void testGetCompteByNum(){
		Compte c = serviceGC.rechercherCompteParNumero(1L);
		Assert.assertTrue(c.getNumCpt()==1L);
		System.out.println("testGetCompteByNum: c.numCpt = " + c.getNumCpt());
	}
	
	//@Test
	public void  testIdOfNewCompte(){
		Compte cpt = new Compte();
		//cpt.setNumCpt(null); //null par defaut
		cpt.setLabel("nouveau compte");
		cpt.setSolde(234.56);
		Long numCpt = serviceGC.creerNouveauCompte(cpt);
		Assert.assertTrue(numCpt != null && numCpt > 0);
		System.out.println("numero nouveau compte:" + numCpt);
	}
	
	@Test
	public void testCrudCompte(){
		Compte newCpt = new Compte();//cpt.setNumCpt(null); //null par defaut
		newCpt.setLabel("nouveau compte xxx");
		newCpt.setSolde(100.0);
		Long numCpt = serviceGC.creerNouveauCompte(newCpt);
		Assert.assertTrue(numCpt != null && numCpt > 0);		
		
		Compte c = serviceGC.rechercherCompteParNumero(numCpt);
		System.out.println("nouveau compte : " + c.toString());
		Assert.assertTrue(c.getLabel().equals("nouveau compte xxx"));
		c.setLabel(c.getLabel() + " yyy");
		c.setSolde(200.0);
		serviceGC.majCompte(c);
		
		Compte cc = serviceGC.rechercherCompteParNumero(numCpt);
		Assert.assertTrue(cc.getSolde()<200.01 && cc.getSolde() > 199.99);
		System.out.println("compte mis a jour : " + cc.toString());
		
		serviceGC.supprimerCompte(numCpt);
		Compte ccc = serviceGC.rechercherCompteParNumero(numCpt);
		Assert.assertTrue(ccc==null);
		if(ccc==null) System.out.println("compte bien supprime");
		
		
		
		
	}
}
