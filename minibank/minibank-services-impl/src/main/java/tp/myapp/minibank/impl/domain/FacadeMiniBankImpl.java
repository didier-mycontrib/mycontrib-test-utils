package tp.myapp.minibank.impl.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tp.myapp.minibank.itf.domain.FacadeMiniBank;
import tp.myapp.minibank.itf.domain.service.GestionClients;
import tp.myapp.minibank.itf.domain.service.GestionComptes;

public class FacadeMiniBankImpl implements FacadeMiniBank {
	
	private GestionComptes serviceGestionComptes;	
	private GestionClients serviceGestionClients;	
	
	private ApplicationContext ctx;
	
	private void initServiceFromApplicationContext(){
		serviceGestionComptes=(GestionComptes)ctx.getBean(GestionComptes.class);
		serviceGestionClients= (GestionClients)ctx.getBean(GestionClients.class);
	}
	
	public FacadeMiniBankImpl(){
		ctx = new ClassPathXmlApplicationContext("springContextOfModule.xml");
		initServiceFromApplicationContext();
	}
	
	public FacadeMiniBankImpl(ApplicationContext ctx){	
		//System.out.println("FacadeMiniBankImpl with ctx:" + ctx);
		this.ctx=ctx;
		initServiceFromApplicationContext();
		}
	
	
	
	@Override
	public GestionComptes getServiceGestionComptes() {
		return serviceGestionComptes;
	}

	@Override
	public GestionClients getServiceGestionClients() {
		return serviceGestionClients;
	}
	
	

}
