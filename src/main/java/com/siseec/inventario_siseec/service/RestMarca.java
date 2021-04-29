/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.service;

import com.siseec.inventario_siseec.bussines.ONMarca;
import com.siseec.inventario_siseec.entity.Marca;

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
@Path("/marca")
public class RestMarca {

    @Inject
    private ONMarca onmarca;

    Respuesta respuestaProducto;
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
    @Path("/ingresarMarca")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta transferirREST(Marca marca) throws Exception {
        Marca mar = null;
        Respuesta resp = new Respuesta();
        mar = onmarca.buscarMarca(marca.getCodigoMarca());

        try {
            if (mar == null) {
                onmarca.insertarMarca(marca);

                resp.setCodigo(1);
                resp.setMensaje("Insercion Existosa Marca");
            } else {
                resp.setCodigo(2);
                resp.setMensaje("ERROR AL Inserar Marca");
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

    @GET
    @Path("/listarMarca")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Marca> listaMarca() throws Exception {

        List<Marca> lista = onmarca.ListarMarcas();

        //return (List<Categoria>) Response.ok(lista).header("Access-Control-Allow-Origin", "*").build();
        return lista;
    }

    @GET
    @Path("/buscarMarcaDescripcion")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Marca> buscarMarcaDescripcion(@QueryParam("parametro") String parametro) throws Exception {

        List<Marca> lista = onmarca.buscarMarcaDescripcion(parametro);

        //return (List<Categoria>) Response.ok(lista).header("Access-Control-Allow-Origin", "*").build();
        return lista;
    }

    @PUT
    @Path("/actualizarMarca")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta actualizarMarca(Marca marca) throws Exception {
        try {
            respuestaProducto = new Respuesta();
            respuestaProducto.setCodigo(1);
            respuestaProducto.setMensaje("Actualizado Estado Categoria");
           onmarca.actualizarestadoMarca(marca);
            //return Response.ok(respestaCategoria).header("Access-Control-Allow-Origin", "*").build();

        } catch (Exception e) {
            respuestaProducto.setCodigo(2);
            respuestaProducto.setMensaje("Error Actualizado Estado");
            // return 
        }
        return respuestaProducto;
    }

}
