package usermanager.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="u_personas")
@NamedQuery(name="UPersona.findAll", query="SELECT u FROM UPersona u")
public class UPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UPersonaPK id;

	@Column(name="p_edad")
	private int pEdad;

	@Column(name="p_fecha_creacion")
	private Timestamp pFechaCreacion;

	@Temporal(TemporalType.DATE)
	private Date p_fecha_nacimiento;

	private byte p_hijos;

	@Column(name="p_primer_apellido")
	private String pPrimerApellido;

	@Column(name="p_primer_nombre")
	private String pPrimerNombre;

	@Column(name="p_segundo_apellido")
	private String pSegundoApellido;

	@Column(name="p_segundo_nombre")
	private String pSegundoNombre;

	@Column(name="p_telefono_celular")
	private String pTelefonoCelular;

	//bi-directional many-to-one association to UDatosContacto
	@OneToMany(mappedBy="UPersona")
	private List<UDatosContacto> UDatosContactos;

	//bi-directional many-to-one association to UEstadoCivile
	@ManyToOne
	@JoinColumn(name="p_id_estado_civil")
	private UEstadoCivile UEstadoCivile;

	//bi-directional many-to-one association to UTipoDocumento
	@ManyToOne
	@JoinColumn(name="p_id_tipo_identificacion" , insertable = false, updatable = false)
	private UTipoDocumento UTipoDocumento;

	//bi-directional many-to-one association to UUser
	@OneToMany(mappedBy="UPersona")
	private List<UUser> UUsers;

	

	public List<UDatosContacto> getUDatosContactos() {
		return this.UDatosContactos;
	}

	public void setUDatosContactos(List<UDatosContacto> UDatosContactos) {
		this.UDatosContactos = UDatosContactos;
	}

	public UDatosContacto addUDatosContacto(UDatosContacto UDatosContacto) {
		getUDatosContactos().add(UDatosContacto);
		UDatosContacto.setUPersona(this);

		return UDatosContacto;
	}

	public UDatosContacto removeUDatosContacto(UDatosContacto UDatosContacto) {
		getUDatosContactos().remove(UDatosContacto);
		UDatosContacto.setUPersona(null);

		return UDatosContacto;
	}

	

	

	public List<UUser> getUUsers() {
		return this.UUsers;
	}

	public void setUUsers(List<UUser> UUsers) {
		this.UUsers = UUsers;
	}

	public UUser addUUser(UUser UUser) {
		getUUsers().add(UUser);
		UUser.setUPersona(this);

		return UUser;
	}

	public UUser removeUUser(UUser UUser) {
		getUUsers().remove(UUser);
		UUser.setUPersona(null);

		return UUser;
	}

}