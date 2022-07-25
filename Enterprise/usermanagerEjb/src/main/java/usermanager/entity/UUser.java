package usermanager.entity;

import java.io.Serializable;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
		@JoinColumn(name="u_id_tipo_identificacion", referencedColumnName="p_id_tipo_identificacion" ,insertable = false, updatable = false),
		@JoinColumn(name="u_numero_identificacion", referencedColumnName="p_numero_identificacion", insertable = false, updatable = false)
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

	
}