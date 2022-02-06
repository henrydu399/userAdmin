package usermanager.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



public class UTipoDocumentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private byte tdId;

	
	private String tdPrefijo;

	
	private String tdTipo;

	
	private List<UPersonaDTO> UPersonas;

	public UTipoDocumentoDTO() {
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

	public List<UPersonaDTO> getUPersonas() {
		return this.UPersonas;
	}

	public void setUPersonas(List<UPersonaDTO> UPersonas) {
		this.UPersonas = UPersonas;
	}

	public UPersonaDTO addUPersona(UPersonaDTO UPersona) {
		getUPersonas().add(UPersona);
		UPersona.setUTipoDocumento(this);

		return UPersona;
	}

	public UPersonaDTO removeUPersona(UPersonaDTO UPersona) {
		getUPersonas().remove(UPersona);
		UPersona.setUTipoDocumento(null);

		return UPersona;
	}

}