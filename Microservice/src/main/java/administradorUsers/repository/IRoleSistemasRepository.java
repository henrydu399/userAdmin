package administradorUsers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import administradorUsers.entitys.RolesSistema;
import administradorUsers.entitys.RolesSistemaPK;

public interface IRoleSistemasRepository extends JpaRepository<RolesSistema, RolesSistemaPK> {
	
	
	

}
