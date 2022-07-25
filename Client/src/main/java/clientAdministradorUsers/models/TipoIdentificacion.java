package clientAdministradorUsers.models;

import java.io.Serializable;

import java.util.List;



public class TipoIdentificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int id;

	private String prefijo;

	private String tipo;


	private List<Persona> personas;

	public TipoIdentificacion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrefijo() {
		return this.prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setTipoIdentificacion(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setTipoIdentificacion(null);

		return persona;
	}

}