package tp.myapp.minibank.impl.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import tp.myapp.minibank.itf.domain.dto.Operation;

@Entity
@Table(name="Operation")
public class _Operation extends Operation{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="numOp")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getNumero() { return super.getNumero();
	}
	@Column(name="label")
	public String getLabel() { return super.getLabel();
	}
	@Column(name="montant")
	public Double getMontant() { return super.getMontant();
	}
	@Column(name="dateOp")
	public Date getDateOp() { return super.getDateOp();
	}
	
	@ManyToOne
	@JoinColumn(name="ref_compte")
	public _Compte getCompte() {
		return compte;
	}
	private _Compte compte;
	
	
		
	/*@Override
	public String toString() {
		return super.toString(); 
		//return "_Operation [numero=" + getNumero() + ", label=" + getLabel()
			//	+ ", montant=" + getMontant() + ", dateOp=" + getDateOp() + "]";
	}*/

	public _Operation() {
		super();
	}
	
	
	public _Operation(String label, Double montant) {
		super(label,montant);
		this.setDateOp(new Date());
	}

	public void setCompte(_Compte compte) {
		this.compte = compte;
	}

}
