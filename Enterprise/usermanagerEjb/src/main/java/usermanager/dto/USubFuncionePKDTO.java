package usermanager.dto;

import java.io.Serializable;
import javax.persistence.*;


public class USubFuncionePKDTO implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	
	private int subfId;


	private int subfIdFuncion;

	public USubFuncionePKDTO() {
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
		if (!(other instanceof USubFuncionePKDTO)) {
			return false;
		}
		USubFuncionePKDTO castOther = (USubFuncionePKDTO)other;
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