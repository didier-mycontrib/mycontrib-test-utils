
package xxx.yyy.zzz.backoffice_test.entity;
//Start of user code java_imports
	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//End of user code
 @Entity
 @Table(name="InfosAuth")
public  class _InfosAuth  {

	private String password;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)	private Long idAuth;

	public _InfosAuth(){
		super(); 
	}      
	public String toString(){
		return "InfosAuth("+ "password=" + password+","+ "idAuth=" + idAuth + ")";
	}
 
	public java.io.Serializable getPk(){
	    //Start of user code pk
 		return idAuth;
 		//End of user code
 	}
	public String getPassword() {
 				return this.password;
 			}
	public void setPassword(String password){
 				this.password=password;
 			}
	public Long getIdAuth() {
 				return this.idAuth;
 			}
	public void setIdAuth(Long idAuth){
 				this.idAuth=idAuth;
 			}

        
} 
