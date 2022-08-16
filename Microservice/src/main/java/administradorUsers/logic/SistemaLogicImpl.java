package administradorUsers.logic;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import administradorUsers.entitys.Systema;
import administradorUsers.enums.EntityEnum;

import administradorUsers.exceptions.AdministradorUserException;
import administradorUsers.repository.IRoleSistemasRepository;
import administradorUsers.repository.ISistemaRepository;
import administradorUsers.utils.UtilsLogs;

@Component
public class SistemaLogicImpl {

	@Autowired
	IRoleSistemasRepository repository;
	
	@Autowired
	ISistemaRepository sistemaRepository;
	
	private Logger logger;
	
	private final EntityEnum entity = EntityEnum.ROLES_SISTEMA ;
	
	
	public SistemaLogicImpl() {
		logger = UtilsLogs.getLogger(SistemaLogicImpl.class.getName());
	}
	
	
	public void  save( Systema obj) throws AdministradorUserException{
		//EL NOMBRE EN MAYUSCULA
		obj.setNombre(obj.getNombre().toUpperCase());
		
	}
	
	
}
