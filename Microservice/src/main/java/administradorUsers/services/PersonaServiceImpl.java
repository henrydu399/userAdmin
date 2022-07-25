package administradorUsers.services;

import java.lang.System.Logger.Level;
import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import administradorUsers.controllers.PersonaController;
import administradorUsers.entitys.Persona;
import administradorUsers.entitys.PersonaPK;
import administradorUsers.enums.EntityEnum;
import administradorUsers.enums.LayerEnum;
import administradorUsers.enums.MethodsEnum;
import administradorUsers.enums.TypeErrorEnum;
import administradorUsers.exceptions.AdministradorUserException;

import administradorUsers.logic.IAdministracionUsuarios;
import administradorUsers.repository.IPersonaRepository;
import administradorUsers.utils.UtilsLogs;

@Service
public class PersonaServiceImpl implements IAdministracionUsuarios {
	
	@Autowired
	IPersonaRepository repository;
	
	
	
	//NAME ENTITY
	@Value("${entitys.name.persona}")
	private String entitys_name;
	
	

	
	
	private Logger logger;
	

	
	public PersonaServiceImpl() {
		logger = UtilsLogs.getLogger(PersonaServiceImpl.class.getName());
	}
	

	@Override
	public List getAll() throws AdministradorUserException {
		return repository.findAll();
		
	}

	@Override
	public void save(Object u) throws AdministradorUserException {
		logger.info(UtilsLogs.getInfo(MethodsEnum.SAVE, EntityEnum.PERSONA ,u));
		try {
			Persona p = (Persona) u;	
			
			Optional<Persona> personaFind = this.repository.findById(p.getId());
			
			if( personaFind.isPresent()) {
				throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.SAVE, LayerEnum.DAO , TypeErrorEnum.ENTITY_EXIST);
			}else {
				this.repository.save(p);
			}			
			
		}catch (PersistenceException e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.SAVE, LayerEnum.DAO, null);
		
	    }catch (AdministradorUserException e) {
	    	logger.severe(e.getMessage());
	    	throw e;
		}
		catch (Exception e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.SAVE, LayerEnum.LOGIC , null);
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
				throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.EDITH, LayerEnum.DAO , TypeErrorEnum.ENTITY_NO_EXIST_FOR_EDITH);
			}			
			
		}catch (PersistenceException e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.EDITH, LayerEnum.DAO, null);
		
	    }catch (AdministradorUserException e) {
	    	logger.severe(e.getMessage());
	    	throw e;
		}
		catch (Exception e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.EDITH, LayerEnum.LOGIC , null);
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
				throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.FIND_CUSTOM, LayerEnum.DAO , TypeErrorEnum.ENTITY_NO_RESULT);
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
	public Persona find(Object p) throws AdministradorUserException {
		
		logger.info(UtilsLogs.getInfo(MethodsEnum.FIND_CUSTOM, EntityEnum.PERSONA ,p));
		try {
			Persona persona = (Persona) p;	
			Example<Persona> personaByFind =  Example.of(persona); 
			List<Persona> listPersonas = this.repository.findAll(personaByFind);	
			
			
			if( listPersonas != null && listPersonas.size() > 0) {
				return listPersonas.get(0);
			}else {
				throw new AdministradorUserException( EntityEnum.PERSONA, MethodsEnum.FIND_CUSTOM, LayerEnum.DAO , TypeErrorEnum.ENTITY_NO_RESULT);
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
