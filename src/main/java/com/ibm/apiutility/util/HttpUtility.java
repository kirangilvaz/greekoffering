package com.ibm.apiutility.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.AsyncWebResource.Builder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class HttpUtility {
	private static Client client;
	private static WebResource webResource;
	private static ClientResponse response;
	public static final Logger log = LoggerFactory.getLogger(HttpUtility.class);

	public static String executeRequest(APIRequest apiRequest) {
		log.info("Creating HTTP "+apiRequest.getType()+" request, URL:" + apiRequest.getUrl()
				+ ", Payload:" + apiRequest.getPayload());
		Header header = new Header();
		client = Client.create();
		webResource = client.resource(apiRequest.getUrl());
		com.sun.jersey.api.client.WebResource.Builder builder = webResource
				.getRequestBuilder();
		// set headers
		for (int i = 0; i < apiRequest.getHeaders().size(); i++) {
			header = apiRequest.getHeaders().get(i);
			builder.header(header.getKey(), header.getValue());
		}
		if (apiRequest.getType().equals("POST")) {
			response = builder.accept("application/json").post(ClientResponse.class,
					apiRequest.getPayload());
			return response.getEntity(String.class);
		} else if (apiRequest.getType().equals("PUT")) {
			response = builder.accept("application/json").put(ClientResponse.class,
					apiRequest.getPayload());
			return response.getEntity(String.class);
		} else if (apiRequest.getType().equals("GET")) {
			response = builder.accept("application/json").get(ClientResponse.class);
			return response.getEntity(String.class);
		} else
			return "{\"message\":\"Please enter valid request type\"}";
	}
}
