package administradorUsers.entitys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the roles_sistemas database table.
 * 
 */
@Embeddable
public class RolesSistemaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID" , insertable=false, updatable=false)
	private long id;

	@Column(name="ID_SISTEMA", insertable=false, updatable=false)
	private int idSistema;

	@Column(name="NOMBRE_ROL" , insertable=false, updatable=false)
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