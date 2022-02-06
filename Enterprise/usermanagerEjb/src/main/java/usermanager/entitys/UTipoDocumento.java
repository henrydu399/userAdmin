package usermanager.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the u_tipo_documentos database table.
 * 
 */
@Entity
@Table(name="u_tipo_documentos")
@NamedQuery(name="UTipoDocumento.findAll", query="SELECT u FROM UTipoDocumento u")
public class UTipoDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="td_id")
	private byte tdId;

	@Column(name="td_prefijo")
	private String tdPrefijo;

	@Column(name="td_tipo")
	private String tdTipo;

	//bi-directional many-to-one association to UPersona
	@OneToMany(mappedBy="UTipoDocumento")
	private List<UPersona> UPersonas;

	public UTipoDocumento() {
	}

	public byte getTdId() {
		return this.tdId;
	}

	public void setTdId(byte tdId) {
		this.tdId = tdId;
	}

	public String getTdPrefijo() {
		return this.tdPrefijo;
	}

	public void setTdPrefijo(String tdPrefijo) {
		this.tdPrefijo = tdPrefijo;
	}

	public String getTdTipo() {
		return this.tdTipo;
	}

	public void setTdTipo(String tdTipo) {
		this.tdTipo = tdTipo;
	}

	public List<UPersona> getUPersonas() {
		return this.UPersonas;
	}

	public void setUPersonas(List<UPersona> UPersonas) {
		this.UPersonas = UPersonas;
	}

	public UPersona addUPersona(UPersona UPersona) {
		getUPersonas().add(UPersona);
		UPersona.setUTipoDocumento(this);

		return UPersona;
	}

	public UPersona removeUPersona(UPersona UPersona) {
		getUPersonas().remove(UPersona);
		UPersona.setUTipoDocumento(null);

		return UPersona;
	}

}