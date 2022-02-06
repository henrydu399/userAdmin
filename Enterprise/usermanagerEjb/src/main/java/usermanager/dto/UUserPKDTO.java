package usermanager.dto;

import java.io.Serializable;
import javax.persistence.*;


public class UUserPKDTO implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	
	private int uId;


	private byte uIdTipoIdentificacion;

	
	private String uNumeroIdentificacion;

	public UUserPKDTO() {
	}
	public int getUId() {
		return this.uId;
	}
	public void setUId(int uId) {
		this.uId = uId;
	}
	public byte getUIdTipoIdentificacion() {
		return this.uIdTipoIdentificacion;
	}
	public void setUIdTipoIdentificacion(byte uIdTipoIdentificacion) {
		this.uIdTipoIdentificacion = uIdTipoIdentificacion;
	}
	public String getUNumeroIdentificacion() {
		return this.uNumeroIdentificacion;
	}
	public void setUNumeroIdentificacion(String uNumeroIdentificacion) {
		this.uNumeroIdentificacion = uNumeroIdentificacion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UUserPKDTO)) {
			return false;
		}
		UUserPKDTO castOther = (UUserPKDTO)other;
		return 
			(this.uId == castOther.uId)
			&& (this.uIdTipoIdentificacion == castOther.uIdTipoIdentificacion)
			&& this.uNumeroIdentificacion.equals(castOther.uNumeroIdentificacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.uId;
		hash = hash * prime + ((int) this.uIdTipoIdentificacion);
		hash = hash * prime + this.uNumeroIdentificacion.hashCode();
		
		return hash;
	}
}