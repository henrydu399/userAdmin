package usermanager.entity;

import java.io.Serializable;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UDatosContactoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="dc_id")
	private String dcId;

	@Column(name="dc_id_tipo_identificacion", insertable=false, updatable=false)
	private byte dcIdTipoIdentificacion;

	@Column(name="dc_numero_identificacion", insertable=false, updatable=false)
	private String dcNumeroIdentificacion;

	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UDatosContactoPK)) {
			return false;
		}
		UDatosContactoPK castOther = (UDatosContactoPK)other;
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