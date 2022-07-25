package administradorUsers.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the roles_sistemas database table.
 * 
 */
@Entity
@Table(name="roles_sistemas")
@NamedQuery(name="RolesSistema.findAll", query="SELECT r FROM RolesSistema r")
public class RolesSistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId 
	private RolesSistemaPK id;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to RolesUsuario
	@OneToMany(mappedBy="rolesSistema")
	private List<RolesUsuario> rolesUsuarios;


	public RolesSistema() {
	}

	public RolesSistemaPK getId() {
		return this.id;
	}

	public void setId(RolesSistemaPK id) {
		this.id = id;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<RolesUsuario> getRolesUsuarios1() {
		return this.rolesUsuarios;
	}

	public void setRolesUsuarios1(List<RolesUsuario> rolesUsuarios1) {
		this.rolesUsuarios = rolesUsuarios1;
	}

	public RolesUsuario addRolesUsuarios1(RolesUsuario rolesUsuarios1) {
		getRolesUsuarios1().add(rolesUsuarios1);
		rolesUsuarios1.setRolesSistema1(this);

		return rolesUsuarios1;
	}

	public RolesUsuario removeRolesUsuarios1(RolesUsuario rolesUsuarios1) {
		getRolesUsuarios1().remove(rolesUsuarios1);
		rolesUsuarios1.setRolesSistema1(null);

		return rolesUsuarios1;
	}



}