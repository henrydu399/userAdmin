package usermanager.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


public class URoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int rId;

	private String rDescripcion;


	private String rNombre;

	
	private List<UFuncioneDTO> UFunciones;


	private USistemaDTO USistema;


	private List<UUserDTO> UUsers;

	public URoleDTO() {
	}

	public int getRId() {
		return this.rId;
	}

	public void setRId(int rId) {
		this.rId = rId;
	}

	public String getRDescripcion() {
		return this.rDescripcion;
	}

	public void setRDescripcion(String rDescripcion) {
		this.rDescripcion = rDescripcion;
	}

	public String getRNombre() {
		return this.rNombre;
	}

	public void setRNombre(String rNombre) {
		this.rNombre = rNombre;
	}

	public List<UFuncioneDTO> getUFunciones() {
		return this.UFunciones;
	}

	public void setUFunciones(List<UFuncioneDTO> UFunciones) {
		this.UFunciones = UFunciones;
	}

	public UFuncioneDTO addUFuncione(UFuncioneDTO UFuncione) {
		getUFunciones().add(UFuncione);
		UFuncione.setURole(this);

		return UFuncione;
	}

	public UFuncioneDTO removeUFuncione(UFuncioneDTO UFuncione) {
		getUFunciones().remove(UFuncione);
		UFuncione.setURole(null);

		return UFuncione;
	}

	public USistemaDTO getUSistema() {
		return this.USistema;
	}

	public void setUSistema(USistemaDTO USistema) {
		this.USistema = USistema;
	}

	public List<UUserDTO> getUUsers() {
		return this.UUsers;
	}

	public void setUUsers(List<UUserDTO> UUsers) {
		this.UUsers = UUsers;
	}

	public UUserDTO addUUser(UUserDTO UUser) {
		getUUsers().add(UUser);
		UUser.setURole(this);

		return UUser;
	}

	public UUserDTO removeUUser(UUserDTO UUser) {
		getUUsers().remove(UUser);
		UUser.setURole(null);

		return UUser;
	}

}