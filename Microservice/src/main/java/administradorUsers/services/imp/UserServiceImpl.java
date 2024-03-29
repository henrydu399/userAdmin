package administradorUsers.services.imp;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import administradorUsers.consta.ErrorConstantes;
import administradorUsers.entitys.Persona;
import administradorUsers.entitys.PersonaPK;
import administradorUsers.entitys.Systema;
import administradorUsers.entitys.Usuario;
import administradorUsers.enums.EntityEnum;
import administradorUsers.enums.LayerEnum;
import administradorUsers.enums.MethodsEnum;

import administradorUsers.exceptions.AdministradorUserException;
import administradorUsers.logic.IEntityDao;
import administradorUsers.repository.IPersonaRepository;
import administradorUsers.repository.IUsuariosRepository;
import administradorUsers.services.SistemaService;
import administradorUsers.services.UserService;
import administradorUsers.utils.BCryptPasswordEncoder;
import administradorUsers.utils.UtilsLogs;
import administradorUsers.validations.UserValidation;

@Service
public class UserServiceImpl  implements UserService {
	
	
	@Autowired
	IUsuariosRepository repository;
	
	@Autowired
	IPersonaRepository personaRepository;
	
	@Autowired
	UserValidation userValidation;
	
	@Autowired 
	SistemaService sistemaService;

	private Logger logger;
	
	BCryptPasswordEncoder passwordEncoder ;
	

	
	public UserServiceImpl() {
		logger = UtilsLogs.getLogger(UserServiceImpl.class.getName());
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	
	@Override
	public List<Usuario> getAll() throws AdministradorUserException {
		return repository.findAll();
		
	}

	@Override
	public void save(Usuario usuario) throws AdministradorUserException {
		logger.info(UtilsLogs.getInfo(MethodsEnum.SAVE, EntityEnum.USUARIO ,usuario));
		try {					

			userValidation.save(usuario);
			
			
			//#1.BUSCAMOS SI EXISTE LA PERSONA PARA GUARDAR EL USUARIO
			Optional<Persona> p = personaRepository.findById(new PersonaPK(usuario.getId().getNumeroIdentificacion() , usuario.getId().getIdTipoIdentificacion()));
			if( !p.isPresent()) {
				throw new AdministradorUserException( EntityEnum.USUARIO, MethodsEnum.SAVE, LayerEnum.DAO ,  ErrorConstantes.PERSONA_NO_EXISTE_EN_EL_SISTEMA);	
			}
			
			//#2.VALIDAMOS EL SISTEMA QUE EXISTA
			Optional<Systema> sistemaFindByName = sistemaService.findBynombre(usuario.getSistema());
			if(!sistemaFindByName.isPresent() ) {
				throw new AdministradorUserException( EntityEnum.USUARIO, MethodsEnum.SAVE, LayerEnum.DAO ,  ErrorConstantes.ERROR_SISTEMA_NO_EXISTE_EN_EL_SISTEMA);
			}
			
			
			//3.VALIDAMOS QUE NO EXISTA UN USUARIO CON EL EMAIL EN EL SISTEMA
			Optional<Usuario> userFindbyEmail = this.repository.findByEmail(usuario.getEmail());
			if( userFindbyEmail.isPresent()) {
				 
				throw new AdministradorUserException( EntityEnum.USUARIO, MethodsEnum.SAVE, LayerEnum.DAO ,  ErrorConstantes.USUARIO_EMAIL_YA_EXISTE);
			}
			
			
			
			//PASSWORD ENCRIP
			String passwordEncrip = passwordEncoder.encode(usuario.getPassword());
			usuario.setPassword(passwordEncrip);
			///
				this.repository.save(usuario);
						
			
		}catch (PersistenceException e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.USUARIO, MethodsEnum.SAVE, LayerEnum.DAO, ErrorConstantes.ERROR_INTENTAR_GUARDAR);
		
	    }catch (AdministradorUserException e) {
	    	logger.severe(e.getMessage());
	    	throw e;
		}
		catch (Exception e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.USUARIO, MethodsEnum.SAVE, LayerEnum.LOGIC , ErrorConstantes.ERROR_GENERAL);
		}

		
	}

	@Override
	public void edith(Usuario usuario) throws AdministradorUserException {
		logger.info(UtilsLogs.getInfo(MethodsEnum.EDITH, EntityEnum.USUARIO , usuario));
		
		try {	
			Optional<Usuario> usuarioFind = this.repository.findById(usuario.getId());	
			if( usuarioFind.isPresent()) {
				this.repository.save(usuario);	
			}else {
				throw new AdministradorUserException( EntityEnum.USUARIO, MethodsEnum.EDITH, LayerEnum.DAO , ErrorConstantes.USUARIO_YA_EXISTE);
			}			
			
		}catch (PersistenceException e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.USUARIO, MethodsEnum.SAVE, LayerEnum.DAO, ErrorConstantes.ERROR_INTENTAR_MODIFICAR);
		
	    }catch (AdministradorUserException e) {
	    	logger.severe(e.getMessage());
	    	throw e;
		}
		catch (Exception e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.USUARIO, MethodsEnum.SAVE, LayerEnum.LOGIC , ErrorConstantes.ERROR_GENERAL);
		}

		
	}

	@Override
	public List<Usuario> findAll(Usuario usuario) throws AdministradorUserException {
		
		logger.info(UtilsLogs.getInfo(MethodsEnum.FIND_CUSTOM, EntityEnum.USUARIO , usuario));
		try {
			Example<Usuario> usuarioByFind =  Example.of(usuario); 
			List<Usuario> list = this.repository.findAll(usuarioByFind);	
				
			if( list != null && list.size() > 0) {
				return list;
			}else {
				throw new AdministradorUserException( EntityEnum.USUARIO, MethodsEnum.FIND_CUSTOM, LayerEnum.DAO , ErrorConstantes.NO_EXISTEN_REGISTROS);
			}			
			
		}catch (PersistenceException e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.USUARIO, MethodsEnum.FIND_CUSTOM, LayerEnum.DAO, ErrorConstantes.ERROR_CONSULTANDO);
		
	    }catch (AdministradorUserException e) {
	    	logger.severe(e.getMessage());
	    	throw e;
		}
		catch (Exception e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.USUARIO, MethodsEnum.SAVE, LayerEnum.LOGIC , ErrorConstantes.ERROR_GENERAL);
		}
	}
	
	
	@Override
	public Usuario find(Usuario obj) throws AdministradorUserException {
		
		logger.info(UtilsLogs.getInfo(MethodsEnum.FIND_CUSTOM, EntityEnum.USUARIO ,obj));
		try {
			Usuario usuario =  ( Usuario ) obj;
			Example<Usuario> entityFind =  Example.of(usuario); 
			List<Usuario> list = this.repository.findAll(entityFind);	
			
			
			if( list != null && list.size() > 0) {
				return list.get(0);
			}else {
				throw new AdministradorUserException( EntityEnum.USUARIO, MethodsEnum.FIND_CUSTOM, LayerEnum.DAO , ErrorConstantes.NO_SE_ECONTRARON_REGISTRO);
			}			
			
		}catch (PersistenceException e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.USUARIO, MethodsEnum.FIND_CUSTOM, LayerEnum.DAO, ErrorConstantes.ERROR_CONSULTANDO_EL_REGISTROS);
		
	    }catch (AdministradorUserException e) {
	    	logger.severe(e.getMessage());
	    	throw e;
		}
		catch (Exception e) {
			logger.severe(e.getMessage());
			throw new AdministradorUserException( EntityEnum.USUARIO, MethodsEnum.FIND_CUSTOM, LayerEnum.LOGIC , null);
		}
	}

	@Override
	public void delete(Usuario p) throws AdministradorUserException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Optional<Usuario> findByEmail(String email) {
		return repository.findByEmail(email);
	}

}
