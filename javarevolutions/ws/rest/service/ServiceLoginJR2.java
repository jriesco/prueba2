package com.javarevolutions.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.javarevolutions.ws.rest.vo.VOUsuario2;

@Path("/JavaRevolutions")
public class ServiceLoginJR2 {
	@POST
	@Path("/validaUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	 public VOUsuario2 validaUsuario(VOUsuario2 vo){
		 vo.setUserValido(false);
		 if(vo.getUsuario().equals("Java") && vo.getPassword().equals("Revolutions")){
			 vo.setUserValido(true);
		 }
		 vo.setPassword("#####################");
		 return vo;
	 }

}
