package usermanager.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="u_sistemas")
@NamedQuery(name="USistema.findAll", query="SELECT u FROM USistema u")
public class USistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="s_id")
	private int sId;

	@Column(name="s_nombre")
	private String sNombre;

	//bi-directional many-to-one association to URole
	@OneToMany(mappedBy="USistema")
	private List<URole> URoles;

	//bi-directional many-to-one association to UUser
	@OneToMany(mappedBy="USistema")
	private List<UUser> UUsers;

	

	public List<URole> getURoles() {
		return this.URoles;
	}

	public void setURoles(List<URole> URoles) {
		this.URoles = URoles;
	}

	public URole addURole(URole URole) {
		getURoles().add(URole);
		URole.setUSistema(this);

		return URole;
	}

	public URole removeURole(URole URole) {
		getURoles().remove(URole);
		URole.setUSistema(null);

		return URole;
	}

	public List<UUser> getUUsers() {
		return this.UUsers;
	}

	public void setUUsers(List<UUser> UUsers) {
		this.UUsers = UUsers;
	}

	public UUser addUUser(UUser UUser) {
		getUUsers().add(UUser);
		UUser.setUSistema(this);

		return UUser;
	}

	public UUser removeUUser(UUser UUser) {
		getUUsers().remove(UUser);
		UUser.setUSistema(null);

		return UUser;
	}

}