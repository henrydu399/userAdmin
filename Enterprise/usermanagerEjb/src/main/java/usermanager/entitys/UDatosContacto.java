package usermanager.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the u_datos_contacto database table.
 * 
 */
@Entity
@Table(name="u_datos_contacto")
@NamedQuery(name="UDatosContacto.findAll", query="SELECT u FROM UDatosContacto u")
public class UDatosContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UDatosContactoPK id;

	@Column(name="dc_direccion")
	private String dcDireccion;

	@Column(name="dc_estado")
	private byte dcEstado;

	@Column(name="dc_tel_fijo")
	private String dcTelFijo;

	@Column(name="dc_tel_movil")
	private String dcTelMovil;

	//bi-directional many-to-one association to UPersona
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="dc_id_tipo_identificacion", referencedColumnName="p_id_tipo_identificacion"),
		@JoinColumn(name="dc_numero_identificacion", referencedColumnName="p_numero_identificacion")
		})
	private UPersona UPersona;

	public UDatosContacto() {
	}

	public UDatosContactoPK getId() {
		return this.id;
	}

	public void setId(UDatosContactoPK id) {
		this.id = id;
	}

	public String getDcDireccion() {
		return this.dcDireccion;
	}

	public void setDcDireccion(String dcDireccion) {
		this.dcDireccion = dcDireccion;
	}

	public byte getDcEstado() {
		return this.dcEstado;
	}

	public void setDcEstado(byte dcEstado) {
		this.dcEstado = dcEstado;
	}

	public String getDcTelFijo() {
		return this.dcTelFijo;
	}

	public void setDcTelFijo(String dcTelFijo) {
		this.dcTelFijo = dcTelFijo;
	}

	public String getDcTelMovil() {
		return this.dcTelMovil;
	}

	public void setDcTelMovil(String dcTelMovil) {
		this.dcTelMovil = dcTelMovil;
	}

	public UPersona getUPersona() {
		return this.UPersona;
	}

	public void setUPersona(UPersona UPersona) {
		this.UPersona = UPersona;
	}

}