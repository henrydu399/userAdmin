package usermanagerapi.controllers;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import usermanager.builder.SystemaBuilder;
import usermanager.ejb.ISistemaManager;

@Path("sistema")
public class SystemaController {
	
	@Inject
	ISistemaManager sistemaManager;
	
	@GET
	public Response  verSistemas() {
		return Response.ok(  SystemaBuilder.getList( sistemaManager.getAll() ) ).build();
	}

}
