package com.ibm.apiutility.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.apiutility.util.APIRequest;
import com.ibm.apiutility.util.HttpUtility;

@Path(value = "/apihelper")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class APIUtilityResource {

	public static final Logger log = LoggerFactory
			.getLogger(APIUtilityResource.class);

	public APIUtilityResource() {
	}

	@Path("/test")
	@GET
	public String testGet() {
		return "{\"message\":\"Request type: GET. Server is alive\"}";
	}

	@Path("/test")
	@POST
	public String testPost() {
		return "{\"message\":\"Request type: POST. Server is alive\"}";
	}

	@POST
	public String testPost(APIRequest apiRequest) {
		return HttpUtility.executeRequest(apiRequest);

	}
}