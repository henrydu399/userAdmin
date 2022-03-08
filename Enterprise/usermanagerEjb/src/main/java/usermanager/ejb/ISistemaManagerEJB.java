package usermanager.ejb;

import java.util.List;

import javax.ejb.Local;

import usermanager.dto.USistemaDTO;
import usermanager.exceptions.UserManagerExceptions;



@Local
public interface ISistemaManagerEJB {
	
	 List<USistemaDTO> getSistemas() ;
	
	  USistemaDTO createSystem( USistemaDTO d) throws UserManagerExceptions;

}
