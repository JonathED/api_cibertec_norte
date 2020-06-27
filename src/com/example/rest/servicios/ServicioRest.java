package com.example.rest.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.dao.MarcaModel;
import com.example.rest.dao.ProveedorModel;
import com.example.rest.dao.UsuarioModel;
import com.example.rest.entidades.Marca;
import com.example.rest.entidades.Proveedor;
import com.example.rest.entidades.Usuario;

@Path("/servicios")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ServicioRest {
	private static final Log log = LogFactory.getLog(ServicioRest.class);
	private UsuarioModel daoUser = new UsuarioModel();
	//private MarcaModel daoMarca = new MarcaModel();
	private ProveedorModel daoProv = new ProveedorModel();
	
	@GET
	@Path("/login")
	public Response login(Usuario obj) {
		log.info("login rest ");
		return Response.ok(daoUser.login(obj)).build();
	}

//	@GET
//	@Path("/usuario")
//	public Response listarUsuarioTodos() {
//		log.info("listar usuario rest ");
//		return Response.ok(daoUser.listarTodos()).build();
//	}
//
//	@GET
//	@Path("/marca")
//	public Response listarMarcaTodos() {
//		log.info("listar Marca rest ");
//		return Response.ok(daoMarca.listarMarcaTodos()).build();
//	}
//
//	@POST
//	@Path("/marca")
//	public Response registraMarca(Marca obj) {
//		log.info("Registra marca " + obj.getIdMarca());
//		if (daoMarca.insertaMarca(obj) >0)
//			return Response.ok().build();
//		else
//			return Response.notModified().build();
//	}
//	
//	@PUT
//	@Path("/marca")
//	@Produces({ MediaType.APPLICATION_JSON })
//	public Response atualiza(Marca obj) {
//		log.info("Actualiza marca " + obj.getIdMarca());
//		if (daoMarca.actualizaMarca(obj) >0)
//			return Response.ok().build();
//		else
//			return Response.notModified().build();
//	}
//
//	//@DELETE
//	//@Path("/users")
//	//@Produces({ MediaType.APPLICATION_JSON })
//	//public Response elimina(Usuario obj) {
//	////	log.info("Elimina usuario " + obj);
//		//if (daoUser.eliminaUser(obj) >0)
//		//	return Response.ok().build();
//		////else
//		//	return Response.notModified().build();
//	//}
//	
//	@DELETE
//	@Path("/marca/{idMarca}")
//	@Produces({ MediaType.APPLICATION_JSON })
//	public Response eliminaMarca(@PathParam("idMarca") int id) {
//		log.info("Elimina marca " + id);
//		if (daoMarca.eliminaMarca(id) > 0)
//			return Response.ok().build();
//		else
//			return Response.notModified().build();
//	}
	
	@GET
	@Path("/usuario")
	public Response listarUsuarioTodos() {
		log.info("listar usuario rest ");
		return Response.ok(daoUser.listarTodos()).build();
	}

	@GET
	@Path("/proveedor")
	public Response listarProveedorTodos() {
		log.info("listar proveedor rest ");
		return Response.ok(daoProv.listarProveedorTodos()).build();
	}

	@POST
	@Path("/proveedor")
	public Response registraProveedor(Proveedor obj) {
		log.info("Registra proveedor " + obj.getIdProveedor());
		if (daoProv.insertaProveedor(obj) >0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	
	@PUT
	@Path("/proveedor")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response atualiza(Proveedor obj) {
		log.info("Actualiza proveedor " + obj.getIdProveedor());
		if (daoProv.actualizaProveedor(obj) >0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	//@DELETE
	//@Path("/users")
	//@Produces({ MediaType.APPLICATION_JSON })
	//public Response elimina(Usuario obj) {
	////	log.info("Elimina usuario " + obj);
		//if (daoUser.eliminaUser(obj) >0)
		//	return Response.ok().build();
		////else
		//	return Response.notModified().build();
	//}
	
	@DELETE
	@Path("/proveedor/{idProveedor}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response eliminaProveedor(@PathParam("idProveedor") int id) {
		log.info("Elimina proveedor " + id);
		if (daoProv.eliminaProveedor(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	
	
	
	
	
	
	
	
	
}