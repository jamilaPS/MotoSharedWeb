package com.tads.motoshared.service;

import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import com.tads.motoshared.dao.GenericDAO;
import com.tads.motoshared.model.User;

@ApplicationPath("/resource")
@Path("/user")
public class UserService extends Application{
	private GenericDAO dao = new GenericDAO();
	
	@POST
	@Path("/cadastrar")
	@Consumes("application/json")
	public Response cadastrar(User obj) {
		try {
			dao.inserir(obj);
			return Response.status(200).entity("Cadastro realizado.").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/alterar")
	@Consumes("application/json")
	public Response alterar(User obj) {
		try {
			dao.alterar(obj);
			return Response.status(200).entity("Registro alterado.").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<User> listar() {
		try {
			List<User> users = dao.buscarTodos(User.class);
			return users;
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	
	@GET
	@Path("/buscar/{id_user}")
	@Produces("application/json")
	public User buscar(@PathParam("id_user") Long id_user) {
		try {
			User user = (User) dao.buscarPorId(User.class, id_user);
			return user;
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	
	@DELETE
	@Path("/excluir/{id_user}")
	public Response excluir(@PathParam("id_user") Long id_user) {
		try {
			User obj = (User) dao.buscarPorId(User.class, id_user);
			dao.excluir(obj);
			return Response.status(200).entity("registro excluído.").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
}
