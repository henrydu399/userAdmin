package administradorUsers.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonaPK id;

	private String apellidos;

	private Integer edad;

	@Column(name="ESTADO_CIVIL")
	private String estadoCivil;

	@Temporal(TemporalType.DATE)
	@Column(name="`FECHA NACIMIENTO`")
	private Date fecha_nacimiento;

	@JsonIgnore
	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	private String nombres;

	@Column(name="NUMERO_HIJOS")
	private Integer numeroHijos;

	private String profesion;

	private String sexo;

	//bi-directional many-to-one association to TipoIdentificacion
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_TIPO_IDENTIFICACION",  insertable = false , updatable = false)
	private TipoIdentificacion tipoIdentificacion;

	//bi-directional many-to-one association to Usuario
	@JsonIgnore
	@OneToMany(mappedBy="persona")
	private List<Usuario> usuarios;

	public Persona() {
	}

	public PersonaPK getId() {
		return this.id;
	}

	public void setId(PersonaPK id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Date getFecha_nacimiento() {
		return this.fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Integer getNumeroHijos() {
		return this.numeroHijos;
	}

	public void setNumeroHijos(Integer numeroHijos) {
		this.numeroHijos = numeroHijos;
	}

	public String getProfesion() {
		return this.profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPersona(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPersona(null);

		return usuario;
	}

}