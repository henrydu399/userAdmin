package clientAdministradorUsers.models;

import java.io.Serializable;



public class PersonaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;


	private String numeroIdentificacion;


	private int idTipoIdentificacion;

	public PersonaPK() {
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