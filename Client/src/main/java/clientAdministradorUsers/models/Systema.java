package clientAdministradorUsers.models;

import java.io.Serializable;




public class Systema implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer id;

	private String nombre;

	public Systema() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}