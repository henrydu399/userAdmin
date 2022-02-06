package usermanager.dto;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class USistemaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int sId;


	private String sNombre;

	
	private List<URoleDTO> URoles;

	
	private List<UUserDTO> UUsers;

	

	public List<URoleDTO> getURoles() {
		return this.URoles;
	}

	public void setURoles(List<URoleDTO> URoles) {
		this.URoles = URoles;
	}

	public URoleDTO addURole(URoleDTO URole) {
		getURoles().add(URole);
		URole.setUSistema(this);

		return URole;
	}

	public URoleDTO removeURole(URoleDTO URole) {
		getURoles().remove(URole);
		URole.setUSistema(null);

		return URole;
	}

	public List<UUserDTO> getUUsers() {
		return this.UUsers;
	}

	public void setUUsers(List<UUserDTO> UUsers) {
		this.UUsers = UUsers;
	}

	public UUserDTO addUUser(UUserDTO UUser) {
		getUUsers().add(UUser);
		UUser.setUSistema(this);

		return UUser;
	}

	public UUserDTO removeUUser(UUserDTO UUser) {
		getUUsers().remove(UUser);
		UUser.setUSistema(null);

		return UUser;
	}

}