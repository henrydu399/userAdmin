package usermanager.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the u_funciones database table.
 * 
 */

public class UFuncioneDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int fId;

	private String fDescripcion;


	private String fNombre;

	
	private URoleDTO URole;


	private List<USubFuncioneDTO> USubFunciones;

	public UFuncioneDTO() {
	}

	public int getFId() {
		return this.fId;
	}

	public void setFId(int fId) {
		this.fId = fId;
	}

	public String getFDescripcion() {
		return this.fDescripcion;
	}

	public void setFDescripcion(String fDescripcion) {
		this.fDescripcion = fDescripcion;
	}

	public String getFNombre() {
		return this.fNombre;
	}

	public void setFNombre(String fNombre) {
		this.fNombre = fNombre;
	}

	public URoleDTO getURole() {
		return this.URole;
	}

	public void setURole(URoleDTO URole) {
		this.URole = URole;
	}

	public List<USubFuncioneDTO> getUSubFunciones() {
		return this.USubFunciones;
	}

	public void setUSubFunciones(List<USubFuncioneDTO> USubFunciones) {
		this.USubFunciones = USubFunciones;
	}

	public USubFuncioneDTO addUSubFuncione(USubFuncioneDTO USubFuncione) {
		getUSubFunciones().add(USubFuncione);
		USubFuncione.setUFuncione(this);

		return USubFuncione;
	}

	public USubFuncioneDTO removeUSubFuncione(USubFuncioneDTO USubFuncione) {
		getUSubFunciones().remove(USubFuncione);
		USubFuncione.setUFuncione(null);

		return USubFuncione;
	}

}