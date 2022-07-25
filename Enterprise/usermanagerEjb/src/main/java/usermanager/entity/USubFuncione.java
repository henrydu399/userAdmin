package usermanager.entity;

import java.io.Serializable;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

	

}