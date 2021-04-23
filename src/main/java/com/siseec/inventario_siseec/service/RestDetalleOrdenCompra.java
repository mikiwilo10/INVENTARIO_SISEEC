/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.service;

import com.siseec.inventario_siseec.bussines.ONCategoria;
import com.siseec.inventario_siseec.bussines.ONDetalleOrdenCompra;
import com.siseec.inventario_siseec.bussines.ONProducto;
import com.siseec.inventario_siseec.bussines.ONProveedor;
import com.siseec.inventario_siseec.entity.Detalle_OrdenCompra;
import com.siseec.inventario_siseec.entity.Orden_Compra;
import com.siseec.inventario_siseec.entity.Producto;
import com.siseec.inventario_siseec.entity.Proveedor;
import com.siseec.inventario_siseec.parametros.DetalleCompra;
import com.siseec.inventario_siseec.parametros.ParametroOrden;
import java.util.ArrayList;


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


@Path("/ordenCompra")
public class RestDetalleOrdenCompra {

    @Inject
    private ONDetalleOrdenCompra ondetalle;
    
    @Inject
    private ONProveedor onproveedor;
    
    @Inject
    private ONProducto onproducto;

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
    @Path("/ingresarOrden")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta transferirREST(Orden_Compra ordenCompra) throws Exception {
        Producto prod = null;
        Respuesta resp = new Respuesta();
       // prod = onproducto.buscarProveedor(producto.getCodigoProducto());
       //System.err.println(producto.toString());
        try {
            if (ordenCompra == null) {
              ondetalle.insertarOrdenCompra(ordenCompra);

                resp.setCodigo(1);
                resp.setMensaje("Insercion Existoso Orden Compra");
            } else {
                resp.setCodigo(2);
                resp.setMensaje("ERROR AL Inserar Orden Compra");
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
    
    
    @POST
    @Path("/ingresarOrdenDetalle")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta insertarOrden(ParametroOrden parametros) throws Exception {
        Respuesta resp = new Respuesta();
        Detalle_OrdenCompra cab;
        
        Orden_Compra ordenCompra = new Orden_Compra();
      
        List<DetalleCompra> lista = parametros.getListaDetalleCompra();
        
        List<Detalle_OrdenCompra> listacab = new ArrayList<Detalle_OrdenCompra>();
        double aux = 0;

        Proveedor proveedor=onproveedor.buscarProveedor(parametros.getRuc());
        try {

            for (DetalleCompra detalles : lista) {

                cab = new Detalle_OrdenCompra();
                
                cab.setCantidad(detalles.getCantidad());

                Producto producto =onproducto.buscarProveedor(detalles.getCodigoProducto());
                aux = aux + (detalles.getCantidad() * producto.getPrecioVenta());

                cab.setSubTotal(detalles.getCantidad() * producto.getPrecioVenta());
                cab.setOrdenCompra(ordenCompra);
                cab.setProducto(producto);
                listacab.add(cab);
                
            }
            
            ordenCompra.setFecha(parametros.getFecha());
            ordenCompra.setDescripcion(parametros.getDescripcion());
            ordenCompra.setCodigoOrdenCompra(parametros.getCodigoOrdenCompra());
            
            ordenCompra.setSubTotal(parametros.getSubTotal());
            ordenCompra.setIva(parametros.getIva());
            ordenCompra.setTotalOrden(aux);
            
            ordenCompra.setUsuario(parametros.getUsuario());
            ordenCompra.setProveedorOrden(proveedor);
            
            ordenCompra.setDetalleOrden(listacab);
            ondetalle.insertarOrdenCompra(ordenCompra);

            resp.setCodigo(1);
            resp.setMensaje("Ingreso correcto de cabecera");
        } catch (Exception e) {
            resp.setCodigo(-1);
            resp.setMensaje("Error al ingresar cabecera");
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
