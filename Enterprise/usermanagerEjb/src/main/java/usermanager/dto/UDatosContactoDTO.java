package usermanager.dto;

import java.io.Serializable;
import javax.persistence.*;



public class UDatosContactoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;


	private UDatosContactoPKDTO id;

	
	private String dcDireccion;

	
	private byte dcEstado;

	
	private String dcTelFijo;

	
	private String dcTelMovil;

	
	private UPersonaDTO UPersona;

	public UDatosContactoDTO() {
	}

	public UDatosContactoPKDTO getId() {
		return this.id;
	}

	public void setId(UDatosContactoPKDTO id) {
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

	public UPersonaDTO getUPersona() {
		return this.UPersona;
	}

	public void setUPersona(UPersonaDTO UPersona) {
		this.UPersona = UPersona;
	}

}