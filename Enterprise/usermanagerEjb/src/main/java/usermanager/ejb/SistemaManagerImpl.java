package usermanager.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import usermanager.dto.USistemaDTO;
import usermanager.entitys.USistema;
import usermanager.exceptions.UserManagerExceptions;


@Stateless
public class SistemaManagerImpl implements ISistemaManager {

	@PersistenceContext( unitName = "usermanagerEjb")
	EntityManager em;
	
	@Override
	public void create() throws UserManagerExceptions {
		
		USistema sistema = new USistema();
		sistema.setSNombre("SISTEMA_EJEMPLO");
		em.persist(sistema);
	}

	@Override
	public boolean update() throws UserManagerExceptions {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete() throws UserManagerExceptions {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void find() throws UserManagerExceptions {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<USistema> getAll() throws UserManagerExceptions {
		 List<USistema> listSistemas =  em.createNamedQuery("USistema.findAll")
			    .getResultList();
		 return listSistemas;
		
	}

}
