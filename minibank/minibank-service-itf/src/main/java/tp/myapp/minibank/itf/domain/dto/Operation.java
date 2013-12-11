package tp.myapp.minibank.itf.domain.dto;

import java.io.Serializable;
import java.util.Date;

public class Operation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long numero;
	private String label;
	private Double montant; //positif ou negatif
	private Date dateOp;
	
		
	@Override
	public String toString() {
		return "Operation [numero=" + numero + ", label=" + label
				+ ", montant=" + montant + ", dateOp=" + dateOp + "]";
	}

	public Operation() {
		super();
	}
	
	
	public Operation(String label, Double montant) {
		super();
		this.label = label;
		this.montant = montant;
	}

	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Date getDateOp() {
		return dateOp;
	}
	public void setDateOp(Date dateOp) {
		this.dateOp = dateOp;
	}
	
	
	
}
