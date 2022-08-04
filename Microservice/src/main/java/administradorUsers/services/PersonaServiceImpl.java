package administradorUsers.services;

import java.lang.System.Logger.Level;
import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import administradorUsers.consta.ErrorConstantes;
import administradorUsers.entitys.Persona;

import administradorUsers.enums.EntityEnum;
import administradorUsers.enums.LayerEnum;
import administradorUsers.enums.MethodsEnum;

import administradorUsers.exceptions.AdministradorUserException;
import administradorUsers.logic.IEntityDao;
import administradorUsers.repository.IPersonaRepository;
import administradorUsers.utils.UtilsLogs;

@Service
public class PersonaServiceImpl implements IEntityDao {
	
	@Autowired
	IPersonaRepository repository;


	private Logger logger;
	
	
	public PersonaServiceImpl() {
		logger = UtilsLogs.getLogger(PersonaServiceImpl.class.getName());
	}
	

	@Override
	public List<Persona> getAll() throws AdministradorUserException {
		return repository.findAll();
		
	}

	@Override
	public void save(Object u) throws AdministradorUserException {
		logger.info(UtilsLogs.getInfo(MethodsEnum.SAVE, EntityEnum.PERSONA ,u));
		try {
			Persona p = (Persona) u;	
			
			Optional<Persona> personaFind = this.repository.findById(p.getId());
			
			if( personaFind.isPresent()) {
				throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.SAVE, LayerEnum.DAO , ErrorConstantes.PERSONA_YA_EXISTE);
			}else {
				this.repository.save(p);
			}			
			
		}catch (PersistenceException e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.SAVE, LayerEnum.DAO, ErrorConstantes.ERROR_INTENTAR_GUARDAR);
		
	    }catch (AdministradorUserException e) {
	    	logger.severe(e.getMessage());
	    	throw e;
		}
		catch (Exception e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.SAVE, LayerEnum.LOGIC , ErrorConstantes.ERROR_GENERAL);
		}

		
	}

	@Override
	public void edith(Object p) throws AdministradorUserException {
		logger.info(UtilsLogs.getInfo(MethodsEnum.EDITH, EntityEnum.PERSONA ,p));
		
		try {
			Persona persona = (Persona) p;		
			Optional<Persona> personaFind = this.repository.findById(persona.getId());	
			if( personaFind.isPresent()) {
				this.repository.save(persona);	
			}else {
				throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.EDITH, LayerEnum.LOGIC , ErrorConstantes.PERSONA_NO_EXISTE_EN_EL_SISTEMA);
			}			
			
		}catch (PersistenceException e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.EDITH, LayerEnum.DAO, ErrorConstantes.ERROR_INTENTAR_MODIFICAR);
		
	    }catch (AdministradorUserException e) {
	    	logger.severe(e.getMessage());
	    	throw e;
		}
		catch (Exception e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.EDITH, LayerEnum.LOGIC , ErrorConstantes.ERROR_GENERAL);
		}

		
	}

	@Override
	public List<Persona> findAll(Object p) throws AdministradorUserException {
		
		logger.info(UtilsLogs.getInfo(MethodsEnum.FIND_CUSTOM, EntityEnum.PERSONA ,p));
		try {
			Persona persona = (Persona) p;	
			Example<Persona> personaByFind =  Example.of(persona); 
			List<Persona> listPersonas = this.repository.findAll(personaByFind);	
			
			
			if( listPersonas != null && listPersonas.size() > 0) {
				return listPersonas;
			}else {
				throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.FIND_CUSTOM, LayerEnum.DAO , ErrorConstantes.NO_EXISTEN_REGISTROS);
			}			
			
		}catch (PersistenceException e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.FIND_CUSTOM, LayerEnum.DAO, ErrorConstantes.ERROR_CONSULTANDO);
		
	    }catch (AdministradorUserException e) {
	    	logger.severe(e.getMessage());
	    	throw e;
		}
		catch (Exception e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.FIND_CUSTOM, LayerEnum.LOGIC , ErrorConstantes.ERROR_GENERAL);
		}
	}
	
	
	@Override
	public Persona find(Object p) throws AdministradorUserException {
		
		logger.info(UtilsLogs.getInfo(MethodsEnum.FIND_CUSTOM, EntityEnum.PERSONA ,p));
		try {
			Persona persona = (Persona) p;	
			Example<Persona> personaByFind =  Example.of(persona); 
			List<Persona> listPersonas = this.repository.findAll(personaByFind);	
			
			
			if( listPersonas != null && listPersonas.size() > 0) {
				return listPersonas.get(0);
			}else {
				throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.FIND_CUSTOM, LayerEnum.DAO , ErrorConstantes.NO_SE_ECONTRARON_REGISTRO);
			}			
			
		}catch (PersistenceException e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.FIND_CUSTOM, LayerEnum.DAO, null);
		
	    }catch (AdministradorUserException e) {
	    	logger.severe(e.getMessage());
	    	throw e;
		}
		catch (Exception e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.FIND_CUSTOM, LayerEnum.LOGIC , null);
		}
	}

	@Override
	public void delete(Object p) throws AdministradorUserException {
		// TODO Auto-generated method stub
		
	}


	

}
