package administradorUsers.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the systema database table.
 * 
 */
@Entity
@NamedQuery(name="Systema.findAll", query="SELECT s FROM Systema s")
public class Systema implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private String nombre;

	public Systema() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}