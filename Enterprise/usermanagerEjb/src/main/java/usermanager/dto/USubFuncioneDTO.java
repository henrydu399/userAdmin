package usermanager.dto;

import java.io.Serializable;


public class USubFuncioneDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private USubFuncionePKDTO id;

	
	private String subfNombre;

	
	private UFuncioneDTO UFuncione;

	public USubFuncioneDTO() {
	}

	public USubFuncionePKDTO getId() {
		return this.id;
	}

	public void setId(USubFuncionePKDTO id) {
		this.id = id;
	}

	public String getSubfNombre() {
		return this.subfNombre;
	}

	public void setSubfNombre(String subfNombre) {
		this.subfNombre = subfNombre;
	}

	public UFuncioneDTO getUFuncione() {
		return this.UFuncione;
	}

	public void setUFuncione(UFuncioneDTO UFuncione) {
		this.UFuncione = UFuncione;
	}

}