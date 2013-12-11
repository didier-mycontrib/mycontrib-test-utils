package tp.myapp.minibank.impl.persistence.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import tp.myapp.minibank.itf.domain.dto.Adresse;
import tp.myapp.minibank.itf.domain.dto.Client;

@Entity
@Table(name="Client")
public class _Client extends Client{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="numClient")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getNumero() {
		return super.getNumero();
	}	
	@Column(name="nom")
	public String getNom() { return super.getNom();
	}
	@Column(name="prenom")
	public String getPrenom() {	return super.getPrenom();
	}
	@Column(name="telephone")
	public String getTelephone() {	return super.getTelephone();
	}	
	@Column(name="email")
	public String getEmail() {	return super.getEmail();
	}
	
	@OneToOne
	@JoinColumn(name="ref_adressePrincipale")
	public _Adresse getAdressePrincipale() {
		return adressePrincipale;
	}
	private _Adresse adressePrincipale;
	
	@Column(name="dateNaissance")
	public Date getDateNaissance() { return dateNaissance;
	}
	private Date dateNaissance;
	
	@Column(name="password")
	public String getPassword() { return password;
	}
	private String password;
	
	@ManyToMany(mappedBy="proprietaires")
	public List<_Compte> getComptes() {
		return comptes;
	}
	private List<_Compte> comptes;
	
	@Override
	@Transient //important pour que "adresse" ne soit pas pris en charge par JPA
	           //seul "adressePrincipale" doit ête gere par Jpa
	public Adresse getAdresse() {
		//super.adresse not used (ignore)
		return this.getAdressePrincipale(); 
	}
	
	@Override
	public void setAdresse(Adresse adresse) {
		//super.adresse not used (ignore)
		adressePrincipale=new _Adresse(adresse.getIdAdr(),adresse.getRue(),adresse.getCodePostal(),adresse.getVille());
		/*
		if(adressePrincipale==null)
			adressePrincipale = new _Adresse();
		this.adressePrincipale.setIdAdr(adresse.getIdAdr());
		this.adressePrincipale.setRue(adresse.getRue());
		this.adressePrincipale.setCodePostal(adresse.getCodePostal());
		this.adressePrincipale.setVille(adresse.getVille());*/
	}

	
	/*@Override
	public String toString() {
		return super.toString();
		//return "_Client [numero=" + getNumero() + ", nom=" + getNom() + ", prenom="
			//	+ getPrenom() + ", dateNaissance=" + dateNaissance + ", telephone="
			//	+ getTelephone() + ", email=" + getEmail() + ", password=" + password
			//	+ "]";
	}*/
	
	
	
	public void setAdressePrincipale(_Adresse adressePrincipale) {
		this.adressePrincipale = adressePrincipale;
	}
	
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
		
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public void setComptes(List<_Compte> comptes) {
		this.comptes = comptes;
	}
	
	

}
