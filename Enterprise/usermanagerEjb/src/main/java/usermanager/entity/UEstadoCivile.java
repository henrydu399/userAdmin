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
@Table(name="u_estado_civiles")
@NamedQuery(name="UEstadoCivile.findAll", query="SELECT u FROM UEstadoCivile u")
public class UEstadoCivile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ec_id")
	private byte ecId;

	@Column(name="ec_bombre")
	private String ecBombre;

	//bi-directional many-to-one association to UPersona
	@OneToMany(mappedBy="UEstadoCivile")
	private List<UPersona> UPersonas;

	

	public List<UPersona> getUPersonas() {
		return this.UPersonas;
	}

	public void setUPersonas(List<UPersona> UPersonas) {
		this.UPersonas = UPersonas;
	}

	public UPersona addUPersona(UPersona UPersona) {
		getUPersonas().add(UPersona);
		UPersona.setUEstadoCivile(this);

		return UPersona;
	}

	public UPersona removeUPersona(UPersona UPersona) {
		getUPersonas().remove(UPersona);
		UPersona.setUEstadoCivile(null);

		return UPersona;
	}

}