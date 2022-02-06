package usermanager.dto;

import java.io.Serializable;
import javax.persistence.*;


public class UDatosContactoPKDTO implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	
	private String dcId;


	private byte dcIdTipoIdentificacion;

	
	private String dcNumeroIdentificacion;

	public UDatosContactoPKDTO() {
	}
	public String getDcId() {
		return this.dcId;
	}
	public void setDcId(String dcId) {
		this.dcId = dcId;
	}
	public byte getDcIdTipoIdentificacion() {
		return this.dcIdTipoIdentificacion;
	}
	public void setDcIdTipoIdentificacion(byte dcIdTipoIdentificacion) {
		this.dcIdTipoIdentificacion = dcIdTipoIdentificacion;
	}
	public String getDcNumeroIdentificacion() {
		return this.dcNumeroIdentificacion;
	}
	public void setDcNumeroIdentificacion(String dcNumeroIdentificacion) {
		this.dcNumeroIdentificacion = dcNumeroIdentificacion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UDatosContactoPKDTO)) {
			return false;
		}
		UDatosContactoPKDTO castOther = (UDatosContactoPKDTO)other;
		return 
			this.dcId.equals(castOther.dcId)
			&& (this.dcIdTipoIdentificacion == castOther.dcIdTipoIdentificacion)
			&& this.dcNumeroIdentificacion.equals(castOther.dcNumeroIdentificacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.dcId.hashCode();
		hash = hash * prime + ((int) this.dcIdTipoIdentificacion);
		hash = hash * prime + this.dcNumeroIdentificacion.hashCode();
		
		return hash;
	}
}