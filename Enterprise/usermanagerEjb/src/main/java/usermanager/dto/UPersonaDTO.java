package usermanager.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the u_personas database table.
 * 
 */

public class UPersonaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private UPersonaPKDTO id;


	private int pEdad;


	private Timestamp pFechaCreacion;


	private Date p_fecha_nacimiento;

	private byte p_hijos;


	private String pPrimerApellido;


	private String pPrimerNombre;

	
	private String pSegundoApellido;

	
	private String pSegundoNombre;

	
	private String pTelefonoCelular;

	
	private List<UDatosContactoDTO> UDatosContactos;


	private UEstadoCivileDTO UEstadoCivile;


	private UTipoDocumentoDTO UTipoDocumento;


	private List<UUserDTO> UUsers;

	public UPersonaDTO() {
	}

	public UPersonaPKDTO getId() {
		return this.id;
	}

	public void setId(UPersonaPKDTO id) {
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

	public List<UDatosContactoDTO> getUDatosContactos() {
		return this.UDatosContactos;
	}

	public void setUDatosContactos(List<UDatosContactoDTO> UDatosContactos) {
		this.UDatosContactos = UDatosContactos;
	}

	public UDatosContactoDTO addUDatosContacto(UDatosContactoDTO UDatosContacto) {
		getUDatosContactos().add(UDatosContacto);
		UDatosContacto.setUPersona(this);

		return UDatosContacto;
	}

	public UDatosContactoDTO removeUDatosContacto(UDatosContactoDTO UDatosContacto) {
		getUDatosContactos().remove(UDatosContacto);
		UDatosContacto.setUPersona(null);

		return UDatosContacto;
	}

	public UEstadoCivileDTO getUEstadoCivile() {
		return this.UEstadoCivile;
	}

	public void setUEstadoCivile(UEstadoCivileDTO UEstadoCivile) {
		this.UEstadoCivile = UEstadoCivile;
	}

	public UTipoDocumentoDTO getUTipoDocumento() {
		return this.UTipoDocumento;
	}

	public void setUTipoDocumento(UTipoDocumentoDTO UTipoDocumento) {
		this.UTipoDocumento = UTipoDocumento;
	}

	public List<UUserDTO> getUUsers() {
		return this.UUsers;
	}

	public void setUUsers(List<UUserDTO> UUsers) {
		this.UUsers = UUsers;
	}

	public UUserDTO addUUser(UUserDTO UUser) {
		getUUsers().add(UUser);
		UUser.setUPersona(this);

		return UUser;
	}

	public UUserDTO removeUUser(UUserDTO UUser) {
		getUUsers().remove(UUser);
		UUser.setUPersona(null);

		return UUser;
	}

}