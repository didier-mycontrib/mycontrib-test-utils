
package xxx.yyy.zzz.backoffice_test.dto;

public  class Compte {

	private String label;
	private Double solde;
    private Long numCpt;
    
    public Compte(){
		super(); 
	}      
	public String toString(){
		return "Compte("+ "label=" + label+","+ "solde=" + solde+","+ "numCpt=" + numCpt + ")";
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

        
} 
