package com.acms.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.acms.model.Configuration;

@Path("configuration")
@Produces(MediaType.APPLICATION_JSON)
public interface ConfigurationResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Configuration saveConfiguration(Configuration configuration);
	
	@GET
	public List<Configuration> getAllConfigurations();
	
	@Path("{id}")
	@GET
	public Configuration getById(@PathParam("id") Integer id);	
	
	@PATCH
	public Configuration updateConfiguration(Configuration configuration);
	
	@DELETE
	public boolean deleteConfiguration(Configuration configuration);
}
