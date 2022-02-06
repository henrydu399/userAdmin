package usermanager.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the u_personas database table.
 * 
 */
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
	@JoinColumn(name="p_id_tipo_identificacion")
	private UTipoDocumento UTipoDocumento;

	//bi-directional many-to-one association to UUser
	@OneToMany(mappedBy="UPersona")
	private List<UUser> UUsers;

	public UPersona() {
	}

	public UPersonaPK getId() {
		return this.id;
	}

	public void setId(UPersonaPK id) {
		this.id = id;
	}

	public int getPEdad() {
		return this.pEdad;
	}

	public void setPEdad(int pEdad) {
		this.pEdad = pEdad;
	}

	public Timestamp getPFechaCreacion() {
		return this.pFechaCreacion;
	}

	public void setPFechaCreacion(Timestamp pFechaCreacion) {
		this.pFechaCreacion = pFechaCreacion;
	}

	public Date getP_fecha_nacimiento() {
		return this.p_fecha_nacimiento;
	}

	public void setP_fecha_nacimiento(Date p_fecha_nacimiento) {
		this.p_fecha_nacimiento = p_fecha_nacimiento;
	}

	public byte getP_hijos() {
		return this.p_hijos;
	}

	public void setP_hijos(byte p_hijos) {
		this.p_hijos = p_hijos;
	}

	public String getPPrimerApellido() {
		return this.pPrimerApellido;
	}

	public void setPPrimerApellido(String pPrimerApellido) {
		this.pPrimerApellido = pPrimerApellido;
	}

	public String getPPrimerNombre() {
		return this.pPrimerNombre;
	}

	public void setPPrimerNombre(String pPrimerNombre) {
		this.pPrimerNombre = pPrimerNombre;
	}

	public String getPSegundoApellido() {
		return this.pSegundoApellido;
	}

	public void setPSegundoApellido(String pSegundoApellido) {
		this.pSegundoApellido = pSegundoApellido;
	}

	public String getPSegundoNombre() {
		return this.pSegundoNombre;
	}

	public void setPSegundoNombre(String pSegundoNombre) {
		this.pSegundoNombre = pSegundoNombre;
	}

	public String getPTelefonoCelular() {
		return this.pTelefonoCelular;
	}

	public void setPTelefonoCelular(String pTelefonoCelular) {
		this.pTelefonoCelular = pTelefonoCelular;
	}

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

	public UEstadoCivile getUEstadoCivile() {
		return this.UEstadoCivile;
	}

	public void setUEstadoCivile(UEstadoCivile UEstadoCivile) {
		this.UEstadoCivile = UEstadoCivile;
	}

	public UTipoDocumento getUTipoDocumento() {
		return this.UTipoDocumento;
	}

	public void setUTipoDocumento(UTipoDocumento UTipoDocumento) {
		this.UTipoDocumento = UTipoDocumento;
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