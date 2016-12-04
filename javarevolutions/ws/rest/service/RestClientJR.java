package com.javarevolutions.ws.rest.service;

import com.javarevolutions.ws.rest.vo.VOUsuario2;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class RestClientJR {
	
	public static void main(String[] args){
		VOUsuario2 vo = new VOUsuario2();
		vo.setUsuario("sergio");
		vo.setPassword("Rios");
		vo.setUserValido(false);
		
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
		Client client=Client.create(clientConfig);
		WebResource webResource = client
				.resource("http://localhost:8070/RestJR/services/JavaRevolutions/validaUsuario");
		ClientResponse response = webResource.type("application/json")
				.post(ClientResponse.class,vo);
		vo = response.getEntity(VOUsuario2.class);
		System.out.println("############ Response: [Usuario: "+vo.getUsuario()+"]");
		System.out.println("############ Response: [User is Valid: "+vo.isUserValido()+"]");
		
		
	}

}
