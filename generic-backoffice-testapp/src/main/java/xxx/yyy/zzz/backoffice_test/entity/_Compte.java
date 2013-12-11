
package xxx.yyy.zzz.backoffice_test.entity;
//Start of user code java_imports
	import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//End of user code
 @Entity
 @Table(name="Compte")
public  class _Compte {

	private String label;
	private Double solde;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)	private Long numCpt;
    @OneToMany(mappedBy="compte")
    	private Collection<_Operation> operations;
    @ManyToOne
    @JoinColumn(name="ref_proprietaire")
    	private _Client proprietaire;

	public _Compte(){
		super(); 
	}      
	public String toString(){
		return "Compte("+ "label=" + label+","+ "solde=" + solde+","+ "numCpt=" + numCpt + ")";
	}
 
	public java.io.Serializable getPk(){
	    //Start of user code pk
 		return numCpt;
 		//End of user code
 	}
	public String getLabel() {
		return this.label;
	}
	public void setLabel(String label){
		this.label=label;
	}
	public Double getSolde() {
		return this.solde;
	}
	public void setSolde(Double solde){
		this.solde=solde;
	}
	public Long getNumCpt() {
		return this.numCpt;
	}
	public void setNumCpt(Long numCpt){
		this.numCpt=numCpt;
	}
	public Collection<_Operation> getOperations() {
		return this.operations;
	}
	public void setOperations(Collection<_Operation> operations){
		this.operations=operations;
	}
	public _Client getProprietaire() {
		return this.proprietaire;
	}
	public void setProprietaire(_Client proprietaire){
		this.proprietaire=proprietaire;
	}
	

        
} 
