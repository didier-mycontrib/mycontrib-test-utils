package tp.myapp.minibank.itf.domain;

import org.mycontrib.generic.exception.GenericException;

import tp.myapp.minibank.itf.domain.service.GestionClients;
import tp.myapp.minibank.itf.domain.service.GestionComptes;

public interface FacadeMiniBank {
    public GestionComptes getServiceGestionComptes() throws GenericException;
    public GestionClients getServiceGestionClients() throws GenericException;
}
