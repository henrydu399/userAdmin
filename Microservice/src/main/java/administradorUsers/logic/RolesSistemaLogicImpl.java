package administradorUsers.logic;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import administradorUsers.consta.ErrorConstantes;
import administradorUsers.entitys.RolesSistema;
import administradorUsers.entitys.Systema;
import administradorUsers.enums.EntityEnum;
import administradorUsers.enums.LayerEnum;
import administradorUsers.enums.MethodsEnum;
import administradorUsers.exceptions.AdministradorUserException;
import administradorUsers.repository.IRoleSistemasRepository;
import administradorUsers.repository.ISistemaRepository;
import administradorUsers.utils.UtilsLogs;

@Component
public class RolesSistemaLogicImpl {

	@Autowired
	IRoleSistemasRepository repository;
	
	@Autowired
	ISistemaRepository sistemaRepository;
	
	private Logger logger;
	
	private final EntityEnum entity = EntityEnum.ROLES_SISTEMA ;
	
	
	public RolesSistemaLogicImpl() {
		logger = UtilsLogs.getLogger(RolesSistemaLogicImpl.class.getName());
	}
	
	
	public void  save( RolesSistema obj) throws AdministradorUserException{
		
		Optional<Systema> s = sistemaRepository.findById(obj.getId().getIdSistema());
		if( !s.isPresent()) {
			throw new AdministradorUserException( entity, MethodsEnum.SAVE, LayerEnum.DAO , ErrorConstantes.ERROR_SISTEMA_NO_EXISTE_EN_EL_SISTEMA);
		}
		
		Optional<RolesSistema>  e = repository.findById(obj.getId());
		if(e.isPresent()) {
			throw new AdministradorUserException( entity, MethodsEnum.SAVE, LayerEnum.DAO , ErrorConstantes.ERROR_ROL_EXISTE_EN_EL_SISTEMA);
		}
		
		
	}
	
	
}
