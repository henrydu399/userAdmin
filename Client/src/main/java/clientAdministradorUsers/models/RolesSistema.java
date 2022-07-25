package clientAdministradorUsers.models;

import java.io.Serializable;

import java.sql.Timestamp;
import java.util.List;



public class RolesSistema implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private RolesSistemaPK id;

	
	private Timestamp fechaCreacion;


	private List<RolesUsuario> rolesUsuarios1;


	private List<RolesUsuario> rolesUsuarios2;

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
		return this.rolesUsuarios1;
	}

	public void setRolesUsuarios1(List<RolesUsuario> rolesUsuarios1) {
		this.rolesUsuarios1 = rolesUsuarios1;
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

	public List<RolesUsuario> getRolesUsuarios2() {
		return this.rolesUsuarios2;
	}

	public void setRolesUsuarios2(List<RolesUsuario> rolesUsuarios2) {
		this.rolesUsuarios2 = rolesUsuarios2;
	}

	public RolesUsuario addRolesUsuarios2(RolesUsuario rolesUsuarios2) {
		getRolesUsuarios2().add(rolesUsuarios2);
		rolesUsuarios2.setRolesSistema2(this);

		return rolesUsuarios2;
	}

	public RolesUsuario removeRolesUsuarios2(RolesUsuario rolesUsuarios2) {
		getRolesUsuarios2().remove(rolesUsuarios2);
		rolesUsuarios2.setRolesSistema2(null);

		return rolesUsuarios2;
	}

}