package usermanager.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



public class UEstadoCivileDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private byte ecId;


	private String ecBombre;

	
	private List<UPersonaDTO> UPersonas;

	public UEstadoCivileDTO() {
	}

	public byte getEcId() {
		return this.ecId;
	}

	public void setEcId(byte ecId) {
		this.ecId = ecId;
	}

	public String getEcBombre() {
		return this.ecBombre;
	}

	public void setEcBombre(String ecBombre) {
		this.ecBombre = ecBombre;
	}

	public List<UPersonaDTO> getUPersonas() {
		return this.UPersonas;
	}

	public void setUPersonas(List<UPersonaDTO> UPersonas) {
		this.UPersonas = UPersonas;
	}

	public UPersonaDTO addUPersona(UPersonaDTO UPersona) {
		getUPersonas().add(UPersona);
		UPersona.setUEstadoCivile(this);

		return UPersona;
	}

	public UPersonaDTO removeUPersona(UPersonaDTO UPersona) {
		getUPersonas().remove(UPersona);
		UPersona.setUEstadoCivile(null);

		return UPersona;
	}

}