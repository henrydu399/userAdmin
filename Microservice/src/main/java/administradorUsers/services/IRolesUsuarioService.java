package administradorUsers.services;


import java.util.List;

import administradorUsers.entitys.RolesUsuario;
import administradorUsers.entitys.Usuario;
import administradorUsers.exceptions.AdministradorUserException;
import administradorUsers.logic.IEntityDao;

public interface IRolesUsuarioService extends IEntityDao<RolesUsuario>{
	
	 List<RolesUsuario> findByUsuario(Usuario usuario) throws AdministradorUserException ;

}
