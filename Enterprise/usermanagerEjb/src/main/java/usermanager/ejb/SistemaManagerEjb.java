package usermanager.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import usermanager.Dao.ISistemaManager;
import usermanager.builder.USistemaBuilder;
import usermanager.dto.USistemaDTO;
import usermanager.entity.USistema;
import usermanager.enums.ErrorEnum;
import usermanager.exceptions.UserManagerExceptions;



@Stateless
public class SistemaManagerEjb  implements ISistemaManagerEJB {

	
	@Inject
    private ISistemaManager sistemaManagerDao;
	
	
	@Override
	public List<USistemaDTO> getSistemas() {		
		try {
			return (List<USistemaDTO>) sistemaManagerDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public USistemaDTO createSystem( USistemaDTO d) throws UserManagerExceptions {		
		try {
			if( d!= null) {
				USistema e = USistemaBuilder.of(d);
				return (USistemaDTO) sistemaManagerDao.create(e);
			}
		} catch (UserManagerExceptions e) {
			throw  e;
		}
		return null;
	}
	

}
