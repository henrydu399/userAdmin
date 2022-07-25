package administradorUsers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import administradorUsers.entitys.Persona;
import administradorUsers.enums.EntityEnum;
import administradorUsers.enums.LayerEnum;
import administradorUsers.enums.MethodsEnum;
import administradorUsers.exceptions.AdministradorUserException;
import administradorUsers.services.PersonaServiceImpl;
import administradorUsers.utils.UtilGson;
import administradorUsers.utils.UtilsLogs;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	private Logger logger;
	
	@Autowired
	private PersonaServiceImpl personaService;
	
	@Value("${spring.application.name}")
	private String nameApp;

	public PersonaController() {
		logger = UtilsLogs.getLogger(PersonaController.class.getName());
	}
	
	
	// METODO SAVE
	@PostMapping(value = "/")
	public ResponseEntity<Object> guardar(@RequestBody Persona json, HttpServletRequest req) {	
		logger.info(nameApp + " guardar :: INICIO ");
		logger.info(nameApp + " Request ::  " + UtilGson.SerializeObjet( json));
		try {
			personaService.save(json);
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
	@PutMapping(value = "/")
	public ResponseEntity<Object> editar(@RequestBody Persona json, HttpServletRequest req) {
		logger.info(nameApp + " Editar :: INICIO ");	
		logger.info(nameApp + " Request ::  " + UtilGson.SerializeObjet( json));
		try {
			personaService.edith(json);
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
		List<Persona> listPersonas =  personaService.getAll();
		return new ResponseEntity<Object>(listPersonas, HttpStatus.OK);

	} 
	
	//FIND CUSTUM 
	@PostMapping(value = "/find")
	public ResponseEntity<Object> find(@RequestBody Persona json) {
		logger.info(nameApp + " FIND CUSTUM :: INICIO ");
		logger.info(nameApp + " Request ::  " + UtilGson.SerializeObjet( json));

		try {
			Persona persona = personaService.find(json);
			return new ResponseEntity<Object>(persona, HttpStatus.OK);
			
		}catch (AdministradorUserException e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }catch (Exception e) {
	    	logger.severe(e.getMessage());
	    	return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}

		
	} 
	
	
	//FIND ALL CUSTUM 
	@PostMapping(value = "/findAll")
	public ResponseEntity<Object> findAll(@RequestBody Persona json) {
		logger.info(nameApp + " FIND CUSTUM :: INICIO ");
		logger.info(nameApp + " Request ::  " + UtilGson.SerializeObjet( json));

		try {
			List<Persona> personas = personaService.findAll(json);
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
