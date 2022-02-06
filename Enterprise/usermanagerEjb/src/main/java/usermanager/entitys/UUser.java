package usermanager.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the u_users database table.
 * 
 */
@Entity
@Table(name="u_users")
@NamedQuery(name="UUser.findAll", query="SELECT u FROM UUser u")
public class UUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UUserPK id;

	@Column(name="u_email")
	private String uEmail;

	@Column(name="u_token_security")
	private String uTokenSecurity;

	//bi-directional many-to-one association to UPersona
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="u_id_tipo_identificacion", referencedColumnName="p_id_tipo_identificacion"),
		@JoinColumn(name="u_numero_identificacion", referencedColumnName="p_numero_identificacion")
		})
	private UPersona UPersona;

	//bi-directional many-to-one association to USistema
	@ManyToOne
	@JoinColumn(name="u_id_sistema")
	private USistema USistema;

	//bi-directional many-to-one association to URole
	@ManyToOne
	@JoinColumn(name="u_id_rol")
	private URole URole;

	public UUser() {
	}

	public UUserPK getId() {
		return this.id;
	}

	public void setId(UUserPK id) {
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

	public UPersona getUPersona() {
		return this.UPersona;
	}

	public void setUPersona(UPersona UPersona) {
		this.UPersona = UPersona;
	}

	public USistema getUSistema() {
		return this.USistema;
	}

	public void setUSistema(USistema USistema) {
		this.USistema = USistema;
	}

	public URole getURole() {
		return this.URole;
	}

	public void setURole(URole URole) {
		this.URole = URole;
	}

}