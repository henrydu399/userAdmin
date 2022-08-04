package administradorUsers.exceptions;

import administradorUsers.enums.EntityEnum;
import administradorUsers.enums.LayerEnum;
import administradorUsers.enums.MethodsEnum;
import administradorUsers.utils.UtilGson;


public class AdministradorUserException extends RuntimeException {
	
	/**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	 
	 //private String tecnicalError;
	// private String codeError;
	 
	 private AdministradorUserExceptionDto data;
	 private String mensaje;
	
	
	

	/*
	 * Custom contrutor for aplicatiom
	 */
	public AdministradorUserException(EntityEnum _entidad ,MethodsEnum _operacion , LayerEnum _layer  , String _mensaje ) {
		data = new AdministradorUserExceptionDto();
		this.data.layer = _layer;
		this.data.message = _mensaje;
		this.data.entidad = _entidad.name();
		this.data.operacion = _operacion.getValueName();	
			//this.message = "[MENSAJE] : "+this.buildMensaje(mensaje)+"   [ENTIDAD] : "+ entidad .name() + "  [OPERACION] : "+ operacion.getValueName() + " [CAPA]  : "+ capa.name() + "";
		

	}
	
	

	
	@Override
    public String getMessage() {
    	return UtilGson.SerializeObjet(data);
    }

	
	
	public String getMensaje() {
		return UtilGson.SerializeObjet(data);
	}



	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}



	public AdministradorUserExceptionDto getData() {
		return data;
	}


	public void setData(AdministradorUserExceptionDto data) {
		this.data = data;
	}









	public static class AdministradorUserExceptionDto {
		  String message;
		  LayerEnum layer;
		  String entidad;
		  String operacion;
	}



	
	
	
	
	

}
