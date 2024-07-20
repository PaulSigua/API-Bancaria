package ec.edu.ups.api.service;

import java.util.List;

import ec.edu.ups.api.business.GestionCuentas;
import ec.edu.ups.api.model.Cuenta;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("cuenta")
public class CuentaServices {

@Inject GestionCuentas gCuenta;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear (Cuenta Cuenta) {
		
		try{
			gCuenta.guardarCuentas(Cuenta);
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
	public Response actualizar(Cuenta mensajeCuentas) {
		try{
			gCuenta.actualizarCuenta(mensajeCuentas);
			return Response.ok(mensajeCuentas).build();
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
	        gCuenta.borrarCliente(codigo);
	        
	        return Response.ok("OK, se borró el Cuenta").build();
	    } catch (Exception e) {
	        ErrorMessage error = new ErrorMessage(99, "Error al eliminar el Cuenta: " + e.getMessage());
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(error)
	                .build();
	    }
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getClientes(){
		List<Cuenta> mensajes = gCuenta.getMensajes();
		if(mensajes.size()>0)
			return Response.ok(mensajes).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran clientes");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
	}
}
