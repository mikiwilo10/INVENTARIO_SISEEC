/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.service;

import com.siseec.inventario_siseec.bussines.ONActivosEmpresa;
import com.siseec.inventario_siseec.bussines.ONAsignacionActivos;
import com.siseec.inventario_siseec.bussines.ONCategoria;
import com.siseec.inventario_siseec.bussines.ONInventarioActivos;
import com.siseec.inventario_siseec.bussines.ONProducto;
import com.siseec.inventario_siseec.entity.ActivosEmpresa;
import com.siseec.inventario_siseec.entity.Detalle_AsignarHerramienta;
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

@Path("/asignacionHerramienta")
public class RestAsignacionActivos {

    @Inject
    private ONAsignacionActivos onactivos;

    Respuesta resp;

    @POST
    @Path("/ingresarHerramienta")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta insertarHerramientas(List<Detalle_AsignarHerramienta> herramientas) throws Exception {
        // InventarioActivos prod = null;
        resp = new Respuesta();
        String valor = "";
//        prod = onproducto.buscarProveedor(producto.getCodigoProducto());
        //  prod=onactivos.buscarActivosInsertar(inventarioActivos.getCodigoInvActivos());
        //   System.err.println(producto.toString());
        try {
            if (herramientas.size()>0) {
                valor = onactivos.insertarHerramientas(herramientas);

                if (valor.equals("NDA")) {
                    resp.setCodigo(1);
                    resp.setMensaje("Cantidad no Disponible");

                }
                if (valor.equals("INGRESO")) {
                    resp.setCodigo(2);
                    resp.setMensaje("Insercion Existoso Inventario");
                }

            } else {
                resp.setCodigo(3);
                resp.setMensaje("Objeto sin Valores");
            }

            //return "retirado";
        } catch (Exception e) {
            // e.printStackTrace();
            resp.setCodigo(4);
            resp.setMensaje("ERROR" + e.toString());

            // return "Error AL retirar ";
        }
        return resp;
    }

//    @GET
//    @Path("/buscarInventario")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response buscarActivo(@QueryParam("parametro") String parametro) throws Exception {
//
//        InventarioActivos pro = onactivos.buscarInvenatrioActivos(parametro);
//
//        return Response.ok(pro).header("Access-Control-Allow-Origin", "*").build();
//       // Response.status(0).
////                return  null;
//    }
    @GET
    @Path("/listaInventario")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Detalle_AsignarHerramienta> listaActivos() throws Exception {

        List<Detalle_AsignarHerramienta> lista = onactivos.ListaAsignacion();

        //return (List<Categoria>) Response.ok(lista).header("Access-Control-Allow-Origin", "*").build();
        return lista;
    }

//    @PUT
//    @Path("/actualizarInventario")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Respuesta actualizarProducto(@QueryParam("codigoActivos") String codigoActivos,@QueryParam("stock") int stock) throws Exception {
//        try {
//           
//            respuestaProducto = new Respuesta();
//            respuestaProducto.setCodigo(1);
//            respuestaProducto.setMensaje("Actualizado Estado Inventario");
//            onactivos.actualizarEstadoInventarioActivos(codigoActivos, stock);
//            //return Response.ok(respestaCategoria).header("Access-Control-Allow-Origin", "*").build();
//           
//        } catch (Exception e) {
//            respuestaProducto.setCodigo(2);
//            respuestaProducto.setMensaje("Error Actualizado Estado");
//           // return 
//        }
//         return respuestaProducto;
//    }
//      
}
