package usermanager.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the u_roles database table.
 * 
 */
@Entity
@Table(name="u_roles")
@NamedQuery(name="URole.findAll", query="SELECT u FROM URole u")
public class URole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="r_id")
	private int rId;

	@Column(name="r_descripcion")
	private String rDescripcion;

	@Column(name="r_nombre")
	private String rNombre;

	//bi-directional many-to-one association to UFuncione
	@OneToMany(mappedBy="URole")
	private List<UFuncione> UFunciones;

	//bi-directional many-to-one association to USistema
	@ManyToOne
	@JoinColumn(name="r_sistema")
	private USistema USistema;

	//bi-directional many-to-one association to UUser
	@OneToMany(mappedBy="URole")
	private List<UUser> UUsers;

	public URole() {
	}

	public int getRId() {
		return this.rId;
	}

	public void setRId(int rId) {
		this.rId = rId;
	}

	public String getRDescripcion() {
		return this.rDescripcion;
	}

	public void setRDescripcion(String rDescripcion) {
		this.rDescripcion = rDescripcion;
	}

	public String getRNombre() {
		return this.rNombre;
	}

	public void setRNombre(String rNombre) {
		this.rNombre = rNombre;
	}

	public List<UFuncione> getUFunciones() {
		return this.UFunciones;
	}

	public void setUFunciones(List<UFuncione> UFunciones) {
		this.UFunciones = UFunciones;
	}

	public UFuncione addUFuncione(UFuncione UFuncione) {
		getUFunciones().add(UFuncione);
		UFuncione.setURole(this);

		return UFuncione;
	}

	public UFuncione removeUFuncione(UFuncione UFuncione) {
		getUFunciones().remove(UFuncione);
		UFuncione.setURole(null);

		return UFuncione;
	}

	public USistema getUSistema() {
		return this.USistema;
	}

	public void setUSistema(USistema USistema) {
		this.USistema = USistema;
	}

	public List<UUser> getUUsers() {
		return this.UUsers;
	}

	public void setUUsers(List<UUser> UUsers) {
		this.UUsers = UUsers;
	}

	public UUser addUUser(UUser UUser) {
		getUUsers().add(UUser);
		UUser.setURole(this);

		return UUser;
	}

	public UUser removeUUser(UUser UUser) {
		getUUsers().remove(UUser);
		UUser.setURole(null);

		return UUser;
	}

}