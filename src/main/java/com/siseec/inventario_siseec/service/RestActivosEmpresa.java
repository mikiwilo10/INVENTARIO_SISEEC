/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.service;

import com.siseec.inventario_siseec.bussines.ONActivosEmpresa;
import com.siseec.inventario_siseec.bussines.ONCategoria;
import com.siseec.inventario_siseec.bussines.ONProducto;
import com.siseec.inventario_siseec.entity.ActivosEmpresa;
import com.siseec.inventario_siseec.entity.Producto;


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


@Path("/activos")
public class RestActivosEmpresa {

    @Inject
    private ONActivosEmpresa onactivos;
    
    Respuesta respuestaProducto ;

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
    @Path("/ingresarActivo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta ingresarActivo(ActivosEmpresa activosEmpresa) throws Exception {
        ActivosEmpresa prod = null;
        Respuesta resp = new Respuesta();
//        prod = onproducto.buscarProveedor(producto.getCodigoProducto());
        prod=onactivos.buscarProveedor(activosEmpresa.getCodigoActivos());
     //   System.err.println(producto.toString());
        try {
            if (prod == null) {
              onactivos.insertarActivosEmpresa(activosEmpresa);

                resp.setCodigo(1);
                resp.setMensaje("Insercion Existoso Activos");
            } else {
                resp.setCodigo(2);
                resp.setMensaje("ERROR AL Inserar Activos");
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
    @Path("/buscarActivo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarActivo(@QueryParam("parametro") String parametro) throws Exception {

        ActivosEmpresa pro = onactivos.buscarActivos(parametro);

        return Response.ok(pro).header("Access-Control-Allow-Origin", "*").build();
       // Response.status(0).
//                return  null;
    }
    
    
    @GET
    @Path("/buscarListaActivo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarListaActivo(@QueryParam("parametro") String parametro) throws Exception {

       List<ActivosEmpresa> pro = onactivos.buscarActivosLista(parametro);

        return Response.ok(pro).header("Access-Control-Allow-Origin", "*").build();
       // Response.status(0).
//                return  null;
    }

    @GET
    @Path("/listaActivos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActivosEmpresa> listaActivos() throws Exception {

        List<ActivosEmpresa> lista = onactivos.ListarActivosEmpresa();

        //return (List<Categoria>) Response.ok(lista).header("Access-Control-Allow-Origin", "*").build();
        return lista;
    }
   
    
      
}
