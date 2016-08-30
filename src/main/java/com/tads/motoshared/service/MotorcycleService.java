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
import com.tads.motoshared.model.Motorcycle;

@ApplicationPath("/resource")
@Path("/motorcycle")
public class MotorcycleService extends Application{
	private GenericDAO dao = new GenericDAO();
	
	@POST
	@Path("/cadastrar")
	@Consumes("application/json")
	public Response cadastrar(Motorcycle obj) {
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
	public Response alterar(Motorcycle obj) {
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
	public List<Motorcycle> listar() {
		try {
			List<Motorcycle> motorcycles = dao.buscarTodos(Motorcycle.class);
			return motorcycles;
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	
	@GET
	@Path("/buscar/{id_motorcycle}")
	@Produces("application/json")
	public Motorcycle buscar(@PathParam("id_motorcycle") Long id_motorcycle) {
		try {
			Motorcycle motorcycle = (Motorcycle) dao.buscarPorId(Motorcycle.class, id_motorcycle);
			return motorcycle;
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	
	@DELETE
	@Path("/excluir/{id_motorcycle}")
	public Response excluir(@PathParam("id_motorcycle") Long id_motorcycle) {
		try {
			Motorcycle obj = (Motorcycle) dao.buscarPorId(Motorcycle.class, id_motorcycle);
			dao.excluir(obj);
			return Response.status(200).entity("registro excluído.").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
}
