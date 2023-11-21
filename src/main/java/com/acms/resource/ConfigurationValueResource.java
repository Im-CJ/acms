package com.acms.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.acms.model.ConfigurationValue;

@Path("configurationvalue")
@Produces(MediaType.APPLICATION_JSON)
public interface ConfigurationValueResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public ConfigurationValue saveConfigurationValue(ConfigurationValue configurationValue);
	
	@GET
	public List<ConfigurationValue> getAllConfigurationValues();
	
	@Path("{id}")
	@GET
	public ConfigurationValue getById(@PathParam("id") Integer id);	
	
	@PUT
	public ConfigurationValue updateConfigurationValue(ConfigurationValue configurationValue);
	
	@DELETE
	public boolean deleteConfigurationValue(ConfigurationValue configurationValue);
}
