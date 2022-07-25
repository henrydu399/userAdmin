package clientAdministradorUsers.models;

import java.io.Serializable;



public class RolesSistemaPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;


	private int idSistema;

	
	private String nombreRol;

	public RolesSistemaPK() {
	}
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RolesSistemaPK)) {
			return false;
		}
		RolesSistemaPK castOther = (RolesSistemaPK)other;
		return 
			(this.id == castOther.id)
			&& (this.idSistema == castOther.idSistema)
			&& this.nombreRol.equals(castOther.nombreRol);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.id ^ (this.id >>> 32)));
		hash = hash * prime + this.idSistema;
		hash = hash * prime + this.nombreRol.hashCode();
		
		return hash;
	}
}