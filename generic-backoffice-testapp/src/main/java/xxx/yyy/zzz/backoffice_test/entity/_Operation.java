
package xxx.yyy.zzz.backoffice_test.entity;
//Start of user code java_imports
	import java.util.Collection;
	import java.util.List;
	import java.util.Date;
	import javax.persistence.*;
//End of user code
 @Entity
 @Table(name="Operation")
public  class _Operation  {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)	private Long numOp;
	private Date dateOp;
	private String label;
	private Double montant;
    @ManyToOne
    @JoinColumn(name="ref_compte")
    	private _Compte compte;

	public _Operation(){
		super(); 
	}      
	public String toString(){
		return "Operation("+ "numOp=" + numOp+","+ "dateOp=" + dateOp+","+ "label=" + label+","+ "montant=" + montant + ")";
	}
 
	public java.io.Serializable getPk(){
	    //Start of user code pk
 		return numOp;
 		//End of user code
 	}
	public Long getNumOp() {
		return this.numOp;
	}
	public void setNumOp(Long numOp){
		this.numOp=numOp;
	}
	public Date getDateOp() {
		return this.dateOp;
	}
	public void setDateOp(Date dateOp){
		this.dateOp=dateOp;
	}
	public String getLabel() {
		return this.label;
	}
	public void setLabel(String label){
		this.label=label;
	}
	public Double getMontant() {
		return this.montant;
	}
	public void setMontant(Double montant){
		this.montant=montant;
	}
	public _Compte getCompte() {
		return this.compte;
	}
	public void setCompte(_Compte compte){
		this.compte=compte;
	}

        
} 
