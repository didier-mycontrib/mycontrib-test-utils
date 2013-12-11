package xxx.yyy.zzz.backoffice_test.service;

import xxx.yyy.zzz.backoffice_test.dto.Compte;

public interface GestionComptes {
	
	public Compte rechercherCompteParNumero(long num);
	public void majCompte(Compte cpt);
	public Long creerNouveauCompte(Compte cpt);
	public void supprimerCompte(long numero);

}
