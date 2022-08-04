package administradorUsers.validations;

import java.util.Objects;

import org.springframework.stereotype.Component;


import administradorUsers.entitys.Systema;
import administradorUsers.enums.EntityEnum;
import administradorUsers.enums.LayerEnum;
import administradorUsers.enums.MethodsEnum;
import administradorUsers.exceptions.AdministradorUserException;

@Component
public class SistemaValidation {
	
	private final String ERROR_ENTIDAD_NULL_O_VACIA = "EL systema  esta null o vacia";
	private final String ERROR_ENTIDAD_NOMBRE_O_VACIA = "El nombre del systema esta null o vacia";
	
	private final EntityEnum entity = EntityEnum.SYSTEMA ;
	
	
	public void save(Systema e) throws AdministradorUserException{
		if( Objects.isNull(e)) {
			throw new AdministradorUserException( entity, MethodsEnum.SAVE, LayerEnum.VALIDATE , ERROR_ENTIDAD_NULL_O_VACIA);
		}
		
		if(Objects.isNull(e.getNombre()) || e.getNombre().isEmpty() ) {
			throw new AdministradorUserException( entity, MethodsEnum.SAVE, LayerEnum.VALIDATE , ERROR_ENTIDAD_NOMBRE_O_VACIA);
		}
	}

}
