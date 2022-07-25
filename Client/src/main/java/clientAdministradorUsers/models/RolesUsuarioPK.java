package clientAdministradorUsers.models;

import java.io.Serializable;



public class RolesUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;


	private long id;

	
	private long idRolSistema;

	
	private int idSistema;

	
	private String nombreRol;


	private long idUsuario;


	private int idTipoIdentificacion;

	
	private String numeroIdentificacion;

	public RolesUsuarioPK() {
	}
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdRolSistema() {
		return this.idRolSistema;
	}
	public void setIdRolSistema(long idRolSistema) {
		this.idRolSistema = idRolSistema;
	}
	public int getIdSistema() {
		return this.idSistema;
	}
	public void setIdSistema(int idSistema) {
		this.idSistema = idSistema;
	}
	public String getNombreRol() {
		return this.nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	public long getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
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
		if (!(other instanceof RolesUsuarioPK)) {
			return false;
		}
		RolesUsuarioPK castOther = (RolesUsuarioPK)other;
		return 
			(this.id == castOther.id)
			&& (this.idRolSistema == castOther.idRolSistema)
			&& (this.idSistema == castOther.idSistema)
			&& this.nombreRol.equals(castOther.nombreRol)
			&& (this.idUsuario == castOther.idUsuario)
			&& (this.idTipoIdentificacion == castOther.idTipoIdentificacion)
			&& this.numeroIdentificacion.equals(castOther.numeroIdentificacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.id ^ (this.id >>> 32)));
		hash = hash * prime + ((int) (this.idRolSistema ^ (this.idRolSistema >>> 32)));
		hash = hash * prime + this.idSistema;
		hash = hash * prime + this.nombreRol.hashCode();
		hash = hash * prime + ((int) (this.idUsuario ^ (this.idUsuario >>> 32)));
		hash = hash * prime + this.idTipoIdentificacion;
		hash = hash * prime + this.numeroIdentificacion.hashCode();
		
		return hash;
	}
}