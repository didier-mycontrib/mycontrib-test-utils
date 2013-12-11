
package xxx.yyy.zzz.backoffice_test.entity;
//Start of user code java_imports
	import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//End of user code
 @Entity
 @Table(name="Client")
public  class _Client  {

	private String nom;
	private Date dateNaissance;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)	private Long numClient;
	private String prenom;
    @OneToOne
    @JoinColumn(name="ref_adressePrincipale")
    	private _Adresse adressePrincipale;
    @OneToOne
    @JoinColumn(name="ref_infosAuth")
    	private _InfosAuth infosAuth;

	public _Client(){
		super(); 
	}      
	public String toString(){
		return "Client("+ "nom=" + nom+","+ "dateNaissance=" + dateNaissance+","+ "numClient=" + numClient+","+ "prenom=" + prenom + ")";
	}
 
	public java.io.Serializable getPk(){
	    //Start of user code pk
 		return numClient;
 		//End of user code
 	}
	public String getNom() {
 				return this.nom;
 			}
	public void setNom(String nom){
 				this.nom=nom;
 			}
	public Date getDateNaissance() {
 				return this.dateNaissance;
 			}
	public void setDateNaissance(Date dateNaissance){
 				this.dateNaissance=dateNaissance;
 			}
	public Long getNumClient() {
 				return this.numClient;
 			}
	public void setNumClient(Long numClient){
 				this.numClient=numClient;
 			}
	public String getPrenom() {
 				return this.prenom;
 			}
	public void setPrenom(String prenom){
 				this.prenom=prenom;
 			}
	public _Adresse getAdressePrincipale() {
 				return this.adressePrincipale;
 			}
 			public void setAdressePrincipale(_Adresse adressePrincipale){
 				this.adressePrincipale=adressePrincipale;
 			}
 			public _InfosAuth getInfosAuth() {
 				return this.infosAuth;
 			}
 			public void setInfosAuth(_InfosAuth infosAuth){
 				this.infosAuth=infosAuth;
 			}
 			
					
        
} 
