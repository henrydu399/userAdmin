package administradorUsers.entitys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the persona database table.
 * 
 */
@Embeddable
public class PersonaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NUMERO_IDENTIFICACION")
	private String numeroIdentificacion;

	@Column(name="ID_TIPO_IDENTIFICACION", insertable=false, updatable=false)
	private int idTipoIdentificacion;

	public PersonaPK() {
	}
	
	
	
	
	public PersonaPK(String numeroIdentificacion, int idTipoIdentificacion) {
		super();
		this.numeroIdentificacion = numeroIdentificacion;
		this.idTipoIdentificacion = idTipoIdentificacion;
	}




	public String getNumeroIdentificacion() {
		return this.numeroIdentificacion;
	}
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public int getIdTipoIdentificacion() {
		return this.idTipoIdentificacion;
	}
	public void setIdTipoIdentificacion(int idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonaPK)) {
			return false;
		}
		PersonaPK castOther = (PersonaPK)other;
		return 
			this.numeroIdentificacion.equals(castOther.numeroIdentificacion)
			&& (this.idTipoIdentificacion == castOther.idTipoIdentificacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numeroIdentificacion.hashCode();
		hash = hash * prime + this.idTipoIdentificacion;
		
		return hash;
	}
}