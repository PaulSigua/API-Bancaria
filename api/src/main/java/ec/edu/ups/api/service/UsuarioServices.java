package ec.edu.ups.api.service;

import java.util.List;

import ec.edu.ups.api.business.GestionUsuario;
import ec.edu.ups.api.model.Usuario;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("usuario")
public class UsuarioServices {

	@Inject GestionUsuario gUsuario;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear (Usuario Usuario) {
		
		try{
			gUsuario.guardarUsuarios(Usuario);
			ErrorMessage error = new ErrorMessage(1, "ok");
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
			
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Usuario mensajeusuarios) {
		try{
			gUsuario.actualizarUsuario(mensajeusuarios);
			return Response.ok(mensajeusuarios).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrar(@QueryParam("id") int codigo) {
		try {
	        gUsuario.borrarCliente(codigo);
	        
	        return Response.ok("OK, se borró el Usuario").build();
	    } catch (Exception e) {
	        ErrorMessage error = new ErrorMessage(99, "Error al eliminar el Usuario: " + e.getMessage());
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(error)
	                .build();
	    }
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getClientes(){
		List<Usuario> mensajes = gUsuario.getMensajes();
		if(mensajes.size()>0)
			return Response.ok(mensajes).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran clientes");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
	}
}
