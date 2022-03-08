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

	


}