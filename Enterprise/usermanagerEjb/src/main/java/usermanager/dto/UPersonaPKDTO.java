package usermanager.dto;

import java.io.Serializable;
import javax.persistence.*;



public class UPersonaPKDTO implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;


	private byte pIdTipoIdentificacion;


	private String pNumeroIdentificacion;

	public UPersonaPKDTO() {
	}
	public byte getPIdTipoIdentificacion() {
		return this.pIdTipoIdentificacion;
	}
	public void setPIdTipoIdentificacion(byte pIdTipoIdentificacion) {
		this.pIdTipoIdentificacion = pIdTipoIdentificacion;
	}
	public String getPNumeroIdentificacion() {
		return this.pNumeroIdentificacion;
	}
	public void setPNumeroIdentificacion(String pNumeroIdentificacion) {
		this.pNumeroIdentificacion = pNumeroIdentificacion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UPersonaPKDTO)) {
			return false;
		}
		UPersonaPKDTO castOther = (UPersonaPKDTO)other;
		return 
			(this.pIdTipoIdentificacion == castOther.pIdTipoIdentificacion)
			&& this.pNumeroIdentificacion.equals(castOther.pNumeroIdentificacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.pIdTipoIdentificacion);
		hash = hash * prime + this.pNumeroIdentificacion.hashCode();
		
		return hash;
	}
}