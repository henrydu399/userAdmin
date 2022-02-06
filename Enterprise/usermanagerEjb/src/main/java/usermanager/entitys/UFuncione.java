package usermanager.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the u_funciones database table.
 * 
 */
@Entity
@Table(name="u_funciones")
@NamedQuery(name="UFuncione.findAll", query="SELECT u FROM UFuncione u")
public class UFuncione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="f_id")
	private int fId;

	@Column(name="f_descripcion")
	private String fDescripcion;

	@Column(name="f_nombre")
	private String fNombre;

	//bi-directional many-to-one association to URole
	@ManyToOne
	@JoinColumn(name="f_id_rol")
	private URole URole;

	//bi-directional many-to-one association to USubFuncione
	@OneToMany(mappedBy="UFuncione")
	private List<USubFuncione> USubFunciones;

	public UFuncione() {
	}

	public int getFId() {
		return this.fId;
	}

	public void setFId(int fId) {
		this.fId = fId;
	}

	public String getFDescripcion() {
		return this.fDescripcion;
	}

	public void setFDescripcion(String fDescripcion) {
		this.fDescripcion = fDescripcion;
	}

	public String getFNombre() {
		return this.fNombre;
	}

	public void setFNombre(String fNombre) {
		this.fNombre = fNombre;
	}

	public URole getURole() {
		return this.URole;
	}

	public void setURole(URole URole) {
		this.URole = URole;
	}

	public List<USubFuncione> getUSubFunciones() {
		return this.USubFunciones;
	}

	public void setUSubFunciones(List<USubFuncione> USubFunciones) {
		this.USubFunciones = USubFunciones;
	}

	public USubFuncione addUSubFuncione(USubFuncione USubFuncione) {
		getUSubFunciones().add(USubFuncione);
		USubFuncione.setUFuncione(this);

		return USubFuncione;
	}

	public USubFuncione removeUSubFuncione(USubFuncione USubFuncione) {
		getUSubFunciones().remove(USubFuncione);
		USubFuncione.setUFuncione(null);

		return USubFuncione;
	}

}