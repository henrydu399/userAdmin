package usermanagerapi.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import usermanager.dto.USistemaDTO;
import usermanager.ejb.ISistemaManagerEJB;
import usermanager.exceptions.UserManagerExceptions;




@Path("/sistema")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SystemaController {
	
	@Inject
	ISistemaManagerEJB sistemaManager;
	
	 @GET
	public Response  verSistemas() {	 
			List<USistemaDTO> list =    sistemaManager.getSistemas() ;		
		return Response.ok( list).build();
	}
	 
	 @POST
	public Response  crearSistema(USistemaDTO d) {	 
			USistemaDTO dto = null;
			try {
				dto = sistemaManager.createSystem(d);
			} catch (UserManagerExceptions e) {
				return Response.status(500).build();
			}
		return Response.ok( dto).build();
	}

}
