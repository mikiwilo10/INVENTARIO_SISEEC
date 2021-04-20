/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.service;

import com.siseec.inventario_siseec.bussines.ONMarca;
import com.siseec.inventario_siseec.bussines.ONTipoProducto;
import com.siseec.inventario_siseec.entity.Marca;
import com.siseec.inventario_siseec.entity.Tipo_Producto;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Daniel AMay
 */
@Path("/tipoProducto")
public class RestTipoProducto {

    @Inject
    private ONTipoProducto ontipo;

//    @GET
//    @Path("/listado")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String saludar(@QueryParam("x") String nombre) {
//        return "Hola: " + nombre;
//    }
//    
//    
//    //otra forma de llama rlos web servicse
//    
//    @GET
//    @Path("/listado:/{name}/{usr} ")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String saludar2(@PathParam("x") String nombre,@PathParam("usr") String usuario) {
//        return "Hola " + nombre;
//    }
//
//    
//    
//    @PUT
//    @Path("/deposito/{idCuenta}/{cantidad}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String depositarREST(@PathParam("idCuenta") String idCuenta, @PathParam("cantidad") double cantidad) {
//        on.depositar(idCuenta,cantidad);
//        System.out.println("depositando...");
//        return "depositado";
//    }
//    
//    
//     @PUT
//    @Path("/retiro/{idCuenta}/{cantidad}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String retirarREST(@PathParam("idCuenta") String idCuenta, @PathParam("cantidad") double cantidad) {
//        on.retirar(idCuenta,cantidad);
//        System.out.println("retirando...");
//        return "retirado";
//    }
//    
//    
//      
//     @PUT
//    @Path("/transferir/{idCuentaOrigen}/{idCuentaDestino}/{cantidad}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String transferirREST(@PathParam("idCuentaOrigen") String idCuentaOrigen,@PathParam("idCuentaDestino") 
//            String idCuentaDestino, @PathParam("cantidad") double cantidad) {
//        on.transaccion(idCuentaOrigen, idCuentaDestino, cantidad);
//        System.out.println("transfiriendo...");
//        return "transferencia exitosa";
//    }
//    
//    
//    
//    
//    
//    
//
////
////    public String retirarREST(String idCuenta, double cantidad) {
////
////        on.retirar(idCuenta, cantidad);
////        System.out.println("retirando...");
////        return "retirado";
////    }
//    
//    
//    @GET
//    @Path("/socios")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<UsuarioAdministrativo> getUsuarios() {
//
//        try {
//            List<UsuarioAdministrativo> lista = usuarioAdminON.listarUAdmi();
//            
//
//            return lista;
//            
//        } catch (Exception ex) {
//            System.out.println("Error ON getUsuarios");
//        }
//        return null;
//    }
//    
    @POST
    @Path("/ingresarTipo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta transferirREST(Tipo_Producto tipoProducto) throws Exception {
        Tipo_Producto mar = null;
        Respuesta resp = new Respuesta();
        mar = ontipo.buscarTipoProducto(tipoProducto.getCodigoTipoProducto());

        try {
            if (mar == null) {
               ontipo.insertarMarca(tipoProducto);

                resp.setCodigo(1);
                resp.setMensaje("Insercion Existosa TipoProducto");
            } else {
                resp.setCodigo(2);
                resp.setMensaje("ERROR AL Inserar TipoProducto");
            }

            //return "retirado";
        } catch (Exception e) {
            // e.printStackTrace();
            resp.setCodigo(3);
            resp.setMensaje("ERROR");

            // return "Error AL retirar ";
        }
        return resp;
    }

//   	@GET
//   	@Path("logins")
//   	@Produces("application/json")
//   	public Response loginsocio(@QueryParam("usuario") String usu, @QueryParam("password") String pws) throws Exception {
//   		SocioEN p = on.buscarPersona(usu, pws);
//   		if (p == null) {
//   			return Response.ok(p).header("Access-Control-Allow-Origin", "*").build();
//   		}
//   		return Response.ok(p).header("Access-Control-Allow-Origin", "*").build();
//
//   	}
//
//   	@GET
//   	@Path("Updtelogin")
//   	@Produces(MediaType.APPLICATION_JSON)
//   	@Consumes(MediaType.APPLICATION_JSON)
//   	public Response actualizarsocio(@QueryParam("email") String email, @QueryParam("clave") String clave)
//   			throws Exception {
//   		on.actualizarSocio(email, clave);
//   		
//   	
//   		System.out.println("Kajajistan..." + email + clave);
//
//   		return Response.ok("transfiriendo").header("Access-Control-Allow-Origin", "*").build();
//   	}
//
//
//   	@GET
//   	@Path("/CuentaSocio")
//   	@Produces(MediaType.APPLICATION_JSON)
//   	public Response CuentaSocio(@QueryParam("cedula") String cedula) throws Exception {
//
//   		List<CuentaEN> listaCuenta = on.listarCuentaSocio(cedula);
//
//   		return Response.ok(listaCuenta).header("Access-Control-Allow-Origin", "*").build();
//   	}
//   	
//   	
//
//   	@GET
//   	@Path("/Credito")
//   	@Produces(MediaType.APPLICATION_JSON)
//   	public Response Credito(@QueryParam("cedula") String cedula) throws Exception {
//
//   		List<CreditoEN> listaCredito = on.listarCredito(cedula);
//
//   		return Response.ok(listaCredito).header("Access-Control-Allow-Origin", "*").build();
//   	}
//   	
//   	
//   	
//	@GET
//   	@Path("/DetalleCredito")
//   	@Produces(MediaType.APPLICATION_JSON)
//   	public Response DetalleCredito(@QueryParam("idcuenta") String idcuenta) throws Exception {
//
//   		List<DetalleCreditoEN> detalleCredito =on.Amortizacion(idcuenta);
//
//   		return Response.ok(detalleCredito).header("Access-Control-Allow-Origin", "*").build();
//   	}
// 
}
