package administradorUsers.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the roles_usuario database table.
 * 
 */
@Entity
@Table(name="roles_usuario")
@NamedQuery(name="RolesUsuario.findAll", query="SELECT r FROM RolesUsuario r")
public class RolesUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RolesUsuarioPK idPk;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	//bi-directional many-to-one association to RolesSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="ID_ROL_SISTEMA", referencedColumnName="ID" ,  insertable = false , updatable = false ),
		@JoinColumn(name="ID_SISTEMA", referencedColumnName="ID_SISTEMA" ,  insertable = false , updatable = false),
		@JoinColumn(name="NOMBRE_ROL", referencedColumnName="NOMBRE_ROL" ,  insertable = false , updatable = false)
		})
	private RolesSistema rolesSistema;

	
	//bi-directional many-to-one association to RolesSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="ID_USUARIO", referencedColumnName="ID" ,  insertable = false , updatable = false  ),
		@JoinColumn(name="ID_TIPO_IDENTIFICACION", referencedColumnName="ID_TIPO_IDENTIFICACION" ,  insertable = false , updatable = false ),
		@JoinColumn(name="NUMERO_IDENTIFICACION", referencedColumnName="NUMERO_IDENTIFICACION" ,  insertable = false , updatable = false )
		})
	private Usuario usuario;


	public RolesUsuario() {
	}

	public RolesUsuarioPK getId() {
		return this.idPk;
	}

	public void setId(RolesUsuarioPK id) {
		this.idPk = id;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public RolesSistema getRolesSistema() {
		return this.rolesSistema;
	}

	public void setRolesSistema(RolesSistema rolesSistema) {
		this.rolesSistema = rolesSistema;
	}


}