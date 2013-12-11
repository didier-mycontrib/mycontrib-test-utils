package tp.myapp.minibank.impl.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import tp.myapp.minibank.itf.domain.dto.Adresse;

@Entity
@Table(name="Adresse")
public class _Adresse extends Adresse{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idAdr")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdAdr() { return super.getIdAdr();
	}
	
	@Column(name="rue")
	public String getRue() { return super.getRue();
	}
	@Column(name="codePostal")
	public String getCodePostal() {	return super.getCodePostal();
	}
	@Column(name="ville")
	public String getVille() {	return super.getVille();
	}	
	
	public _Adresse() {
		super();
	}
	
	public _Adresse(Long idAdr, String rue, String codePostal, String ville) {
		super(idAdr,rue,codePostal,ville);
	}

	/*@Override
	public String toString() {
		return super.toString();
		//return "_Adresse [idAdr=" + getIdAdr() + ", rue=" + getRue() + ", codePostal="
			//	+ getCodePostal() + ", ville=" + getVille() + "]";
	}*/
	
}
