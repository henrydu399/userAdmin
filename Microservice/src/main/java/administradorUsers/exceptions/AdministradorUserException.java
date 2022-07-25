package administradorUsers.exceptions;

import administradorUsers.enums.EntityEnum;
import administradorUsers.enums.LayerEnum;
import administradorUsers.enums.MethodsEnum;
import administradorUsers.enums.TypeErrorEnum;

public class AdministradorUserException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private String message;
	String tecnicalError;
	String codeError;
	LayerEnum layer;
	
	
	

	/*
	 * Custom contrutor for aplicatiom
	 */
	public AdministradorUserException(EntityEnum entidad ,MethodsEnum operacion , LayerEnum capa ,TypeErrorEnum type  ) {
		
		if( type != null) {
			switch (type) {
			case ENTITY_EXIST:
				this.message = "[MENSAJE] : ERROR YA EXISTE   [ENTIDAD] : "+ entidad .name() + "  [OPERACION] : "+ operacion.getValueName() + " [CAPA]  : "+ capa.name() + "";
				break;
				
			case ENTITY_NO_EXIST_FOR_EDITH:
				this.message = "[MENSAJE] : ERROR NO EXISTE LA ENTIDAD   [ENTIDAD] : "+ entidad .name() + "  [OPERACION] : "+ operacion.getValueName() + " [CAPA]  : "+ capa.name() + "";
				break;
				
			case ENTITY_NO_RESULT:
				this.message = "[MENSAJE] : NO EXISTEN RESULTADOS    [ENTIDAD] : "+ entidad .name() + "  [OPERACION] : "+ operacion.getValueName() + " [CAPA]  : "+ capa.name() + "";
				break;
				
			}
		}else {
			this.message = "[MENSAJE] : ERROR GENERAL   [ENTIDAD] : "+ entidad .name() + "  [OPERACION] : "+ operacion.getValueName() + " [CAPA]  : "+ capa.name() + "";
		}

		

		this.layer = capa;
		

	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}
	
	
	



	
	
	
	
	

}
