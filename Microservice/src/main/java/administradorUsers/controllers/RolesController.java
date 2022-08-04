package administradorUsers.controllers;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import administradorUsers.entitys.Persona;
import administradorUsers.entitys.RolesSistema;
import administradorUsers.exceptions.AdministradorUserException;
import administradorUsers.services.PersonaServiceImpl;
import administradorUsers.services.RolesSistemaServiceImpl;
import administradorUsers.utils.UtilGson;
import administradorUsers.utils.UtilsLogs;

@RestController
@RequestMapping("/rol")
public class RolesController {

	private Logger logger;

	@Value("${spring.application.name}")
	private String nameApp;

	@Autowired
	private RolesSistemaServiceImpl Service;

	public RolesController() {
		logger = UtilsLogs.getLogger(RolesController.class.getName());
	}

	// METODO SAVE
	@PostMapping(value = "/")
	public ResponseEntity<Object> guardar(@RequestBody RolesSistema json, HttpServletRequest req) {
		logger.info(nameApp + "guardar :: INICIO ");
		logger.info(nameApp + "Request ::  " + UtilGson.SerializeObjet(json));
		try {
			Service.save(json);
			return new ResponseEntity<Object>(null, HttpStatus.CREATED);
		} catch (AdministradorUserException e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// EDITAR
	@PutMapping(value = "/")
	public ResponseEntity<Object> editar(@RequestBody RolesSistema json, HttpServletRequest req) {
		logger.info(nameApp + "Editar :: INICIO ");
		logger.info(nameApp + "Request ::  " + UtilGson.SerializeObjet(json));
		try {
			Service.edith(json);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (AdministradorUserException e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// GET ALL
	@GetMapping(value = "/")
	public ResponseEntity<Object> consultarAll() {
		logger.info(nameApp + "GET ALL :: INICIO ");
		List<RolesSistema> list = Service.getAll();
		return new ResponseEntity<Object>(list, HttpStatus.OK);

	}

	// FIND CUSTUM
	@PostMapping(value = "/findCustom")
	public ResponseEntity<Object> findCustom(@RequestBody RolesSistema json) {
		logger.info(nameApp + "FIND CUSTUM :: INICIO ");
		logger.info(nameApp + "Request ::  " + UtilGson.SerializeObjet(json));
		try {
			RolesSistema persona = Service.find(json);
			return new ResponseEntity<Object>(persona, HttpStatus.OK);
		} catch (AdministradorUserException e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// GET BY OD
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> consultarbyId(@PathVariable Long id) {
		logger.info(nameApp + "GET BY ID :: INICIO ");
		logger.info(nameApp + "Request ::  " + UtilGson.SerializeObjet(id));
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}

	// DELETE O DESACTIVAR
	@PostMapping(value = "/delete")
	public ResponseEntity<Object> eliminar(@RequestBody RolesSistema json) {
		logger.info(nameApp + "DELETE O DESACTIVAR :: INICIO ");
		logger.info(nameApp + "Request ::  " + UtilGson.SerializeObjet(json));
		try {
			 Service.delete(json);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (AdministradorUserException e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}

	}

	// DELETE O DESACTIVAR
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> desactivar(@PathVariable Long id) {
		logger.info(nameApp + "DELETE O DESACTIVAR :: INICIO ");
		logger.info(nameApp + "Request ::  " + UtilGson.SerializeObjet(id));
		return new ResponseEntity<Object>(null, HttpStatus.OK);

	}

}