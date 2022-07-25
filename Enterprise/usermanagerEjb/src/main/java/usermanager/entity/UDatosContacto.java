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
@Table(name="u_datos_contacto")
@NamedQuery(name="UDatosContacto.findAll", query="SELECT u FROM UDatosContacto u")
public class UDatosContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UDatosContactoPK id;

	@Column(name="dc_direccion")
	private String dcDireccion;

	@Column(name="dc_estado")
	private byte dcEstado;

	@Column(name="dc_tel_fijo")
	private String dcTelFijo;

	@Column(name="dc_tel_movil")
	private String dcTelMovil;

	//bi-directional many-to-one association to UPersona
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="dc_id_tipo_identificacion", referencedColumnName="p_id_tipo_identificacion" ,  insertable = false, updatable = false),
		@JoinColumn(name="dc_numero_identificacion", referencedColumnName="p_numero_identificacion" , insertable = false, updatable = false)
		})
	private UPersona UPersona;

	
}