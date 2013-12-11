package tp.myapp.minibank.impl.domain.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mycontrib.generic.test.ejb.AbstractOpenEjbTest;
import org.mycontrib.generic.test.ejb.OpenEjbTestUtil;

import tp.myapp.minibank.itf.domain.dto.Client;
import tp.myapp.minibank.itf.domain.service.GestionClients;
	

public class TestGestionClients extends AbstractOpenEjbTest{
	
	private GestionClients serviceGestionClients;
	
	
	@Before
    public void initService(){
		serviceGestionClients = initEjbServiceIfNull( serviceGestionClients, "GestionClientsImpl" + "Local");
     }
	
	@Test
	public void testGetClientByNum(){
		try {
			Client cli = serviceGestionClients.getClientByNum(1L);
			System.out.println("client 1 = " + cli.toString());
			Assert.assertTrue(cli.getNumero()==1L);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testPasswordOfClient(){
		try {
		
			System.out.println("affectation  et verification du mot de passe new-pwd1 au client 1  :");
			serviceGestionClients.changePasswordOfClient(1L, "new-pwd1");
			Assert.assertTrue(serviceGestionClients.isGoodPasswordOfClient(1L, "new-pwd1"));
			System.out.println("affectation et verification du mot de passe pwd1 au client 1  :");
			serviceGestionClients.changePasswordOfClient(1L, "pwd1");
			Assert.assertTrue(serviceGestionClients.isGoodPasswordOfClient(1L, "pwd1"));			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	
	
	
	
}
