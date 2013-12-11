
package xxx.yyy.zzz.backoffice_test.entity;
//Start of user code java_imports
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//End of user code
 @Entity
 @Table(name="Adresse")
public  class _Adresse  {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)	private Long idAdr;
	private String codePostal;
	private String rue;
	private String ville;

	public _Adresse(){
		super(); 
	}      
	public String toString(){
		return "Adresse("+ "idAdr=" + idAdr+","+ "codePostal=" + codePostal+","+ "rue=" + rue+","+ "ville=" + ville + ")";
	}
 
	public java.io.Serializable getPk(){
	    //Start of user code pk
 		return idAdr;
 		//End of user code
 	}
	public Long getIdAdr() {
 				return this.idAdr;
 			}
	public void setIdAdr(Long idAdr){
 				this.idAdr=idAdr;
 			}
	public String getCodePostal() {
 				return this.codePostal;
 			}
	public void setCodePostal(String codePostal){
 				this.codePostal=codePostal;
 			}
	public String getRue() {
 				return this.rue;
 			}
	public void setRue(String rue){
 				this.rue=rue;
 			}
	public String getVille() {
 				return this.ville;
 			}
	public void setVille(String ville){
 				this.ville=ville;
 			}

        
} 
