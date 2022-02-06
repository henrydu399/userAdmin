package usermanager.entitys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the u_sub_funciones database table.
 * 
 */
@Embeddable
public class USubFuncionePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="subf_id")
	private int subfId;

	@Column(name="subf_id_funcion", insertable=false, updatable=false)
	private int subfIdFuncion;

	public USubFuncionePK() {
	}
	public int getSubfId() {
		return this.subfId;
	}
	public void setSubfId(int subfId) {
		this.subfId = subfId;
	}
	public int getSubfIdFuncion() {
		return this.subfIdFuncion;
	}
	public void setSubfIdFuncion(int subfIdFuncion) {
		this.subfIdFuncion = subfIdFuncion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof USubFuncionePK)) {
			return false;
		}
		USubFuncionePK castOther = (USubFuncionePK)other;
		return 
			(this.subfId == castOther.subfId)
			&& (this.subfIdFuncion == castOther.subfIdFuncion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.subfId;
		hash = hash * prime + this.subfIdFuncion;
		
		return hash;
	}
}