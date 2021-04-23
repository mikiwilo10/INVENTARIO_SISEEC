/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.dao;



import com.siseec.inventario_siseec.entity.Detalle_OrdenCompra;
import com.siseec.inventario_siseec.entity.Orden_Compra;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Javier
 */
@Stateless
public class DaoDetalleOrdenCompra {

    @PersistenceContext
    private EntityManager em;

    public void insertarDetalleOrden(Detalle_OrdenCompra detalleOrden) throws Exception {
        em.persist(detalleOrden);
    }

    public Detalle_OrdenCompra buscarDetalleOrdenID(int idDetalleOrden) throws Exception {
        return em.find(Detalle_OrdenCompra.class, idDetalleOrden);
    }

    public void actualizarDetalleOrden(Detalle_OrdenCompra detalleOrden) throws Exception {
        em.merge(detalleOrden);
    }

    /**
     * ORDEN COMPRA METODO LISTAR
     * @param codigoOrdenCompra
     * @param codigoProducto
     * @return
     * @throws Exception 
     */
    public Orden_Compra buscarDetalleOrden(String codigoOrdenCompra) throws Exception {
        Orden_Compra c = null;
        try {
            String jpql = "SELECT p FROM Orden_Compra p " + "WHERE codigoOrdenCompra LIKE :codigoOrdenCompra";
            TypedQuery<Orden_Compra> query = em.createQuery(jpql, Orden_Compra.class);
            query.setParameter("codigoOrdenCompra", codigoOrdenCompra);

            c = query.getSingleResult();

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return c;
    }

     public void insertarOrdenCompra(Orden_Compra ordenCompra) throws Exception {
    em.persist(ordenCompra);
    }
 

    public List<Orden_Compra> ListaProveedor() throws Exception {
        String jpql = "SELECT c FROM Orden_Compra c";

        Query q = em.createQuery(jpql, Orden_Compra.class);

        return q.getResultList();
    }

}
