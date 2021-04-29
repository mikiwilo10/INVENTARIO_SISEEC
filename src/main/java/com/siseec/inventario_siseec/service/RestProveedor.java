/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.service;

import com.siseec.inventario_siseec.bussines.ONCategoria;
import com.siseec.inventario_siseec.bussines.ONProveedor;
import com.siseec.inventario_siseec.entity.Proveedor;

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
@Path("/proveedor")
public class RestProveedor {

    @Inject
    private ONProveedor onproveedor;
    
    Respuesta respuestaProducto;

    @POST
    @Path("/ingresarProveedor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta ingresarProveedor(Proveedor proveedor) throws Exception {
        Proveedor cat = null;
        Respuesta resp = new Respuesta();
        cat = onproveedor.buscarProveedor(proveedor.getRuc());

        try {
            if (cat == null) {
                onproveedor.insertarCategoria(proveedor);

                resp.setCodigo(1);
                resp.setMensaje("Insercion Existosa Proveedor");
            } else {
                resp.setCodigo(2);
                resp.setMensaje("ERROR AL Inserar Proveedor");
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
    @Path("/buscarProveedor")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarProducto(@QueryParam("parametro") String parametro) throws Exception {

        Proveedor pro = onproveedor.buscarProveedor(parametro);

        return Response.ok(pro).header("Access-Control-Allow-Origin", "*").build();
        // Response.status(0).
//                return  null;
    }

    @GET
    @Path("/listaProveedor")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proveedor> listarProveedor() throws Exception {

        List<Proveedor> lista = onproveedor.ListarProveedor();

        //return (List<Categoria>) Response.ok(lista).header("Access-Control-Allow-Origin", "*").build();
        return lista;
    }

   

    @PUT
    @Path("/actualizarProveedor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta actualizarProveedor(Proveedor proveedor) throws Exception {
        try {
            respuestaProducto = new Respuesta();
            respuestaProducto.setCodigo(1);
            respuestaProducto.setMensaje("Actualizado Estado Categoria");
            onproveedor.actualizarestadoProveedor(proveedor);
            //return Response.ok(respestaCategoria).header("Access-Control-Allow-Origin", "*").build();

        } catch (Exception e) {
            respuestaProducto.setCodigo(2);
            respuestaProducto.setMensaje("Error Actualizado Estado");
            // return 
        }
        return respuestaProducto;
    }

}
