package usermanager.dto;

import java.io.Serializable;
import javax.persistence.*;


public class UUserDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private UUserPKDTO id;


	private String uEmail;

	
	private String uTokenSecurity;

	
	private UPersonaDTO UPersona;

	
	private USistemaDTO USistema;

	
	private URoleDTO URole;

	public UUserDTO() {
	}

	public UUserPKDTO getId() {
		return this.id;
	}

	public void setId(UUserPKDTO id) {
		this.id = id;
	}

	public String getUEmail() {
		return this.uEmail;
	}

	public void setUEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getUTokenSecurity() {
		return this.uTokenSecurity;
	}

	public void setUTokenSecurity(String uTokenSecurity) {
		this.uTokenSecurity = uTokenSecurity;
	}

	public UPersonaDTO getUPersona() {
		return this.UPersona;
	}

	public void setUPersona(UPersonaDTO UPersona) {
		this.UPersona = UPersona;
	}

	public USistemaDTO getUSistema() {
		return this.USistema;
	}

	public void setUSistema(USistemaDTO USistema) {
		this.USistema = USistema;
	}

	public URoleDTO getURole() {
		return this.URole;
	}

	public void setURole(URoleDTO URole) {
		this.URole = URole;
	}

}