package usermanager.entitys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the u_personas database table.
 * 
 */
@Embeddable
public class UPersonaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="p_id_tipo_identificacion", insertable=false, updatable=false)
	private byte pIdTipoIdentificacion;

	@Column(name="p_numero_identificacion")
	private String pNumeroIdentificacion;

	public UPersonaPK() {
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
		if (!(other instanceof UPersonaPK)) {
			return false;
		}
		UPersonaPK castOther = (UPersonaPK)other;
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