package administradorUsers.controllers;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import administradorUsers.entitys.Usuario;
import administradorUsers.exceptions.AdministradorUserException;
import administradorUsers.services.UserService;

import administradorUsers.utils.UtilGson;
import administradorUsers.utils.UtilsLogs;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
private Logger logger;
	
	@Autowired
	private UserService Service;
	
	@Value("${spring.application.name}")
	private String nameApp;

	public UsuarioController() {
		logger = UtilsLogs.getLogger(PersonaController.class.getName());
	}
	
	
	// METODO SAVE
	@PostMapping(value = "/" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody Usuario json, HttpServletRequest req) {	
		logger.info(nameApp + " guardar :: INICIO ");
		logger.info(nameApp + " Request ::  " + UtilGson.SerializeObjet( json));
		try {
			Service.save(json);
			return new ResponseEntity<Object>(null, HttpStatus.CREATED);
		}catch (AdministradorUserException e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }catch (Exception e) {
	    	logger.severe(e.getMessage());
	    	return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}

	} 	
		
	
	// EDITAR
	@PutMapping(value = "/" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> editar(@RequestBody Usuario json, HttpServletRequest req) {
		logger.info(nameApp + " Editar :: INICIO ");	
		logger.info(nameApp + " Request ::  " + UtilGson.SerializeObjet( json));
		try {
			Service.edith(json);
			return new ResponseEntity<Object>(null, HttpStatus.OK);

		}catch (AdministradorUserException e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }catch (Exception e) {
	    	logger.severe(e.getMessage());
	    	return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}

	
	} 
	
	
	//GET ALL 
	@GetMapping(value = "/")
	public ResponseEntity<Object> consultarAll() {
		logger.info(nameApp + " GET ALL :: INICIO ");	
		List<Usuario> list =   Service.getAll();
		return new ResponseEntity<Object>(list, HttpStatus.OK);

	} 
	
	//FIND CUSTUM 
	@PostMapping(value = "/find" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> find(@RequestBody Usuario json) {
		logger.info(nameApp + " FIND CUSTUM :: INICIO ");
		logger.info(nameApp + " Request ::  " + UtilGson.SerializeObjet( json));

		try {
			Usuario e = Service.find(json);
			return new ResponseEntity<Object>(e, HttpStatus.OK);
			
		}catch (AdministradorUserException e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }catch (Exception e) {
	    	logger.severe(e.getMessage());
	    	return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}

		
	} 
	
	
	//FIND ALL CUSTUM 
	@PostMapping(value = "/findAll" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findAll(@RequestBody Usuario json) {
		logger.info(nameApp + " FIND CUSTUM :: INICIO ");
		logger.info(nameApp + " Request ::  " + UtilGson.SerializeObjet( json));

		try {
			List<Usuario> personas = Service.findAll(json);
			return new ResponseEntity<Object>(personas, HttpStatus.OK);
			
		}catch (AdministradorUserException e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }catch (Exception e) {
	    	logger.severe(e.getMessage());
	    	return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}

		
	} 
	
	//GET BY OD
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> consultarbyId(@PathVariable Long id) {
		logger.info(nameApp + " GET BY ID :: INICIO ");	
		logger.info(nameApp + " Request ::  " + UtilGson.SerializeObjet(id));
		
		
		
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
	

	//DELETE O DESACTIVAR
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> desactivar(@PathVariable Long id) {
		logger.info(nameApp + " DELETE O DESACTIVAR :: INICIO ");
		logger.info(nameApp + " Request ::  " + UtilGson.SerializeObjet(id));
		return new ResponseEntity<Object>(null, HttpStatus.OK);
		
	}
	

}
