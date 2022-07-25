package clientAdministradorUsers.models;

import java.io.Serializable;



public class UsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long id;


	private int idTipoIdentificacion;


	private String numeroIdentificacion;

	public UsuarioPK() {
	}
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getIdTipoIdentificacion() {
		return this.idTipoIdentificacion;
	}
	public void setIdTipoIdentificacion(int idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}
	public String getNumeroIdentificacion() {
		return this.numeroIdentificacion;
	}
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuarioPK)) {
			return false;
		}
		UsuarioPK castOther = (UsuarioPK)other;
		return 
			(this.id == castOther.id)
			&& (this.idTipoIdentificacion == castOther.idTipoIdentificacion)
			&& this.numeroIdentificacion.equals(castOther.numeroIdentificacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.id ^ (this.id >>> 32)));
		hash = hash * prime + this.idTipoIdentificacion;
		hash = hash * prime + this.numeroIdentificacion.hashCode();
		
		return hash;
	}
}