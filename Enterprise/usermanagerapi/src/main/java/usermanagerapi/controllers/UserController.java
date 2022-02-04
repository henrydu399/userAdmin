package usermanagerapi.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("tutorial")
public class UserController {
	
	 @GET
	    @Path("helloworld")
	    public String helloworld() {
	        return "Hello World!";
	    }

}
