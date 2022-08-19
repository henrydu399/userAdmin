package administradorUsers.services;

import java.util.Optional;

import administradorUsers.entitys.Usuario;
import administradorUsers.logic.IEntityDao;

public interface UserService extends IEntityDao<Usuario> {
	
	 Optional<Usuario>	findByEmail(String email);

}
