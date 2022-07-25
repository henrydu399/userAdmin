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
public class UPersonaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="p_id_tipo_identificacion", insertable=false, updatable=false)
	private byte pIdTipoIdentificacion;

	@Column(name="p_numero_identificacion")
	private String pNumeroIdentificacion;

	
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