/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.service;

import com.siseec.inventario_siseec.bussines.ONCategoria;
import com.siseec.inventario_siseec.entity.Categoria;

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
@Path("/categoria")
public class RestCategoria {

    @Inject
    private ONCategoria oncategoria;

    Respuesta respestaCategoria;

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
    @Path("/ingresarCategoria")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta transferirREST(Categoria categoria) throws Exception {
        Categoria cat = null;
        Respuesta resp = new Respuesta();
        cat = oncategoria.buscarCategoria(categoria.getCodigoCategoria(), categoria.getDescripcion());

        try {
            if (cat == null) {
                oncategoria.insertarCategoria(categoria);

                resp.setCodigo(1);
                resp.setMensaje("Insercion Existosa Categoria");
            } else {
                resp.setCodigo(2);
                resp.setMensaje("ERROR AL Inserar Categoria");
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

    @PUT
    @Path("/actualizarCategoria")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta actualizarsocio(Categoria cat) throws Exception {
        try {
            respestaCategoria = new Respuesta();
            respestaCategoria.setCodigo(1);
            respestaCategoria.setMensaje("Actualizado Estado Categoria");
            oncategoria.actualizarestadoCategoia(cat);
            //return Response.ok(respestaCategoria).header("Access-Control-Allow-Origin", "*").build();
           
        } catch (Exception e) {
            respestaCategoria.setCodigo(2);
            respestaCategoria.setMensaje("Error Actualizado Estado");
           // return 
        }
         return respestaCategoria;
    }
//
//

    @GET
    @Path("/buscarCategoria")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarCategoria(@QueryParam("parametro") String parametro) throws Exception {

        Categoria cat = oncategoria.buscarCategoriaDescripcion(parametro);

        return Response.ok(cat).header("Access-Control-Allow-Origin", "*").build();
       // Response.status(0).
//                return  null;
    }
//   	
//   	
//   	

    @GET
    @Path("/listaCategoria")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> Categorias() throws Exception {

        List<Categoria> lista = oncategoria.ListaCategorias();

        //return (List<Categoria>) Response.ok(lista).header("Access-Control-Allow-Origin", "*").build();
        return lista;
    }

}
