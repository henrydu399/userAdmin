package usermanagerapi.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("user")
public class UserController {
	
	 @GET
	    @Path("")
	    public String helloworld() {
	        return "Hello World!";
	    }

}
