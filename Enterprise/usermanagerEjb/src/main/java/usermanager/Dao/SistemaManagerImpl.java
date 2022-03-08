package usermanager.Dao;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;

import usermanager.builder.USistemaBuilder;
import usermanager.dto.USistemaDTO;
import usermanager.entity.USistema;
import usermanager.enums.ErrorEnum;
import usermanager.exceptions.UserManagerExceptions;


@Stateless
public  class SistemaManagerImpl implements ISistemaManager {

	@PersistenceContext(unitName = "usermanagerEjb")
	EntityManager em;

	
	Logger logger = Logger.getLogger(SistemaManagerImpl.class);
	
	
	@Override
	public Iterable findAll() {
		List<USistemaDTO> out =  null;
		List<USistema> listSistemas =  em.createNamedQuery("USistema.findAll") .getResultList();
		if( listSistemas != null) {
			out =  new ArrayList<USistemaDTO>();
			for (USistema e : listSistemas ) {
				USistemaDTO dto = USistemaBuilder.of(e);
				out.add(dto);	
			}
		}
		 return out;
	}



	@Override
	public List getAll() throws UserManagerExceptions {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public USistemaDTO create(Object t) throws UserManagerExceptions {
		try {
			USistema e = (USistema) t;
			em.persist(e);
			em.flush();
		}catch (PersistenceException e) {
			logger.error(e);
			throw  new UserManagerExceptions(ErrorEnum.ERROR_CREANDO_ENTIDAD, USistema.class.getName());
		}finally {
			//em.close();
		}

		return USistemaBuilder.of((USistema) t);
	}



	@Override
	public void delete(Object t) throws UserManagerExceptions {
		// TODO Auto-generated method stub
		
	}



	@Override
	public USistema find(Object t) throws UserManagerExceptions {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public USistema update(Object t) throws UserManagerExceptions {
		// TODO Auto-generated method stub
		return null;
	}

}
