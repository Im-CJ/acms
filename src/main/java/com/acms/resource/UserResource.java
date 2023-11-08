package com.acms.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.acms.model.User;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
public interface UserResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean validateUser(User user);
	
}
