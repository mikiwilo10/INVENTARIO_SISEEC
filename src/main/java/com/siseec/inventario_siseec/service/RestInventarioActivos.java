/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.service;

import com.siseec.inventario_siseec.bussines.ONActivosEmpresa;
import com.siseec.inventario_siseec.bussines.ONCategoria;
import com.siseec.inventario_siseec.bussines.ONInventarioActivos;
import com.siseec.inventario_siseec.bussines.ONProducto;
import com.siseec.inventario_siseec.entity.ActivosEmpresa;
import com.siseec.inventario_siseec.entity.InventarioActivos;
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


@Path("/inventarioActivos")
public class RestInventarioActivos {

    @Inject
    private ONInventarioActivos onactivos;
    
    Respuesta respuestaProducto ;

    
    @POST
    @Path("/ingresarInventario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta ingresarActivo(InventarioActivos inventarioActivos) throws Exception {
        InventarioActivos prod = null;
        Respuesta resp = new Respuesta();
//        prod = onproducto.buscarProveedor(producto.getCodigoProducto());
        prod=onactivos.buscarActivosInsertar(inventarioActivos.getCodigoInvActivos());
     //   System.err.println(producto.toString());
        try {
            if (prod == null) {
              onactivos.insertarInventarioActivos(inventarioActivos);

                resp.setCodigo(1);
                resp.setMensaje("Insercion Existoso Inventario");
            } else {
                resp.setCodigo(2);
                resp.setMensaje("ERROR AL Inserar Inventario");
            }

            //return "retirado";
        } catch (Exception e) {
            // e.printStackTrace();
            resp.setCodigo(3);
            resp.setMensaje("ERROR" + e.toString());

            // return "Error AL retirar ";
        }
        return resp;
    }
    
    
    @GET
    @Path("/buscarInventario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarActivo(@QueryParam("parametro") int parametro) throws Exception {

        InventarioActivos pro = onactivos.buscarInvenatrioActivos(parametro);

        return Response.ok(pro).header("Access-Control-Allow-Origin", "*").build();
       // Response.status(0).
//                return  null;
    }

    @GET
    @Path("/listaInventario")
    @Produces(MediaType.APPLICATION_JSON)
    public List<InventarioActivos> listaActivos() throws Exception {

        List<InventarioActivos> lista = onactivos.ListaInventario();

        //return (List<Categoria>) Response.ok(lista).header("Access-Control-Allow-Origin", "*").build();
        return lista;
    }
   
    
    @PUT
    @Path("/actualizarInventario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta actualizarProducto(@QueryParam("codigoActivos") String codigoActivos,@QueryParam("stock") int stock) throws Exception {
        try {
           
            respuestaProducto = new Respuesta();
            respuestaProducto.setCodigo(1);
            respuestaProducto.setMensaje("Actualizado Estado Inventario");
            onactivos.actualizarEstadoInventarioActivos(codigoActivos, stock);
            //return Response.ok(respestaCategoria).header("Access-Control-Allow-Origin", "*").build();
           
        } catch (Exception e) {
            respuestaProducto.setCodigo(2);
            respuestaProducto.setMensaje("Error Actualizado Estado");
           // return 
        }
         return respuestaProducto;
    }
      
}
