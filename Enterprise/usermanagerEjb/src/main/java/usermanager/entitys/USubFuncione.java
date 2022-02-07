package usermanager.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the u_sub_funciones database table.
 * 
 */
@Entity
@Table(name="u_sub_funciones")
@NamedQuery(name="USubFuncione.findAll", query="SELECT u FROM USubFuncione u")
public class USubFuncione implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private USubFuncionePK id;

	@Column(name="subf_nombre")
	private String subfNombre;

	//bi-directional many-to-one association to UFuncione
	@ManyToOne
	@JoinColumn(name="subf_id_funcion", insertable = false, updatable = false)
	private UFuncione UFuncione;

	public USubFuncione() {
	}

	public USubFuncionePK getId() {
		return this.id;
	}

	public void setId(USubFuncionePK id) {
		this.id = id;
	}

	public String getSubfNombre() {
		return this.subfNombre;
	}

	public void setSubfNombre(String subfNombre) {
		this.subfNombre = subfNombre;
	}

	public UFuncione getUFuncione() {
		return this.UFuncione;
	}

	public void setUFuncione(UFuncione UFuncione) {
		this.UFuncione = UFuncione;
	}

}