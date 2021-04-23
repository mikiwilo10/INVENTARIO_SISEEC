/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.bussines;

import com.siseec.inventario_siseec.dao.*;
import com.siseec.inventario_siseec.entity.Detalle_OrdenCompra;
import com.siseec.inventario_siseec.entity.Orden_Compra;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Javier
 */
@Stateless
public class ONDetalleOrdenCompra {

    @Inject
    private DaoDetalleOrdenCompra daodetalle;

//    public void insertarDetalleOrden(Detalle_OrdenCompra detalleOrden) throws Exception {
//        daodetalle.insertarDetalleOrden(detalleOrden);
//    }
//
//    public Detalle_OrdenCompra buscarDetalleOrdenID(int idDetalleOrden) throws Exception {
//        return daodetalle.buscarDetalleOrdenID(idDetalleOrden);
//    }
//
//    public void actualizarDetalleOrden(Detalle_OrdenCompra detalleOrden) throws Exception {
//        daodetalle.actualizarDetalleOrden(detalleOrden);
//    }

    /**
     * ORDEN COMPRA METODO LISTAR
     *
     * @param codigoOrdenCompra
     * @param codigoProducto
     * @return
     * @throws Exception
     */
    public Orden_Compra buscarDetalleOrden(String codigoOrdenCompra) throws Exception {
        Orden_Compra c = null;
        try {
            c = daodetalle.buscarDetalleOrden(codigoOrdenCompra);

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return c;
    }
    
    
    public void insertarOrdenCompra(Orden_Compra ordenCompra) throws Exception {
    daodetalle.insertarOrdenCompra(ordenCompra);
    }

    public List<Orden_Compra> ListaProveedor() throws Exception {
        List<Orden_Compra> lista = null;
        lista = daodetalle.ListaProveedor();
        return lista;
    }

}
