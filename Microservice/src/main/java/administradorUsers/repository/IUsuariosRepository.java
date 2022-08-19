package administradorUsers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import administradorUsers.entitys.Usuario;
import administradorUsers.entitys.UsuarioPK;

public interface IUsuariosRepository extends JpaRepository<Usuario, UsuarioPK> {

   Optional<Usuario>	findByEmail(String email);
   
 
	
}
