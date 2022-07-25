package clientAdministradorUsers.models;

import java.io.Serializable;

import java.util.Date;



public class RolesUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private RolesUsuarioPK id;


	private Date fechaCreacion;


	private RolesSistema rolesSistema1;


	private RolesSistema rolesSistema2;

	public RolesUsuario() {
	}

	public RolesUsuarioPK getId() {
		return this.id;
	}

	public void setId(RolesUsuarioPK id) {
		this.id = id;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public RolesSistema getRolesSistema1() {
		return this.rolesSistema1;
	}

	public void setRolesSistema1(RolesSistema rolesSistema1) {
		this.rolesSistema1 = rolesSistema1;
	}

	public RolesSistema getRolesSistema2() {
		return this.rolesSistema2;
	}

	public void setRolesSistema2(RolesSistema rolesSistema2) {
		this.rolesSistema2 = rolesSistema2;
	}

}