package usermanager.entity;

import java.io.Serializable;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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