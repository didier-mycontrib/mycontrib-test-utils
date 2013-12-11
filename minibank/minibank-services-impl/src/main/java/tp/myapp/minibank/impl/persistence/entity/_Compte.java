package tp.myapp.minibank.impl.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import tp.myapp.minibank.itf.domain.dto.Compte;

@Entity
@Table(name="Compte")
public class _Compte extends Compte{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="numCpt")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getNumero() { return super.getNumero();
	}
	@Column(name="label")
	public String getLabel() { return super.getLabel();
	}
	@Column(name="solde")
	public Double getSolde() { return super.getSolde();
	}
	
	@ManyToMany
	@JoinTable(name="ClientCompte",joinColumns={@JoinColumn(name="numCpt")},
	inverseJoinColumns={@JoinColumn(name="numCli")})
	public List<_Client> getProprietaires() {
		return proprietaires;
	}
	private List<_Client> proprietaires;
	
	@OneToMany(mappedBy="compte",cascade={CascadeType.ALL})
	public List<_Operation> getOperations() {
		return operations;
	}
	private List<_Operation> operations;
	
		
	public void addOperation(_Operation op){
		if(operations==null)
			operations=new ArrayList<_Operation>();
		op.setCompte(this);
		operations.add(op);
	}
	
	public _Compte() {
		super();
	}
		
	public _Compte(Long numero, String label, Double solde) {
		super(numero,label,solde);
	}

	/*@Override
	public String toString() {
		return super.toString();
		//return "_Compte [numero=" + getNumero() + ", label=" + getLabel() + ", solde="
		//		+ getSolde() + "]";
	}*/
	
	public void setOperations(List<_Operation> operations) {
		this.operations = operations;
	}

	public void setProprietaires(List<_Client> proprietaires) {
		this.proprietaires = proprietaires;
	}
}
