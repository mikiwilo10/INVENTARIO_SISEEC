/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.dao;

import com.siseec.inventario_siseec.entity.ActivosEmpresa;
import com.siseec.inventario_siseec.entity.InventarioActivos;
import com.siseec.inventario_siseec.entity.Producto;
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
public class DaoInventarioActivos {

    @PersistenceContext
    private EntityManager em;

    public void insertarInventarioActivos(InventarioActivos inventarioActivos) throws Exception {
        em.persist(inventarioActivos);
    }

//    public InventarioActivos buscarInventarioID(int idActivos) throws Exception {
//        return em.find(InventarioActivos.class, idActivos);
//    }
//
//    public void actualizarInventarioActivos(InventarioActivos InventarioActivos) throws Exception {
//        em.merge(InventarioActivos);
//    }

    public InventarioActivos buscarActivosInsertar(String codigoActivos) throws Exception {
        InventarioActivos c = null;
        try {
            //String jpql = "SELECT p FROM Producto p " + "WHERE codigoProducto LIKE :codigoProducto";
            String jpql = "SELECT p FROM InventarioActivos p " + "WHERE p.codigoInvActivos  = '"
                    + codigoActivos + "' ";
            TypedQuery<InventarioActivos> query = em.createQuery(jpql, InventarioActivos.class);
            //query.setParameter("codigoProducto", codigoProducto);

            c = query.getSingleResult();

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return c;
    }

    public InventarioActivos buscarActivos(int parametro) throws Exception {
        InventarioActivos c = null;
        try {
            String jpql = "SELECT p FROM InventarioActivos p " + "WHERE idActivos  = '"
                    + parametro + "' ";

            TypedQuery<InventarioActivos> query = em.createQuery(jpql, InventarioActivos.class);
            //  query.setParameter("codigoProducto", codigoProducto);

            c = query.getSingleResult();

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return c;
    }
    
    
     public List<Producto> buscarActivoCantidad(int Categoria) throws Exception {
        // String jpql = "SELECT e FROM Producto e JOIN e.categoriaProducto p where  p.idCategoria  = '" + Categoria+"' ";
         String jpql = "SELECT e FROM InventarioActivos e JOIN e.idActivos p where  p.idCategoria  = '" + Categoria+"' ";
    	//String jpql = "SELECT p FROM ActivosEmpresa p WHERE codigoActivos LIKE :parametro OR nombre LIKE :parametro OR numeroSerie LIKE :parametro";
        Query q = em.createQuery(jpql, Producto.class);

        return q.getResultList();
    }

    public void actualizarEstadoInventarioActivos(String codigoActivos, int stock) throws Exception {

        String jpql = "UPDATE InventarioActivos p SET p.stock = p.stock+" + stock + ", p.cantidadDisponible=p.cantidadDisponible+ " + stock + " WHERE p.codigoInvActivos='" + codigoActivos + "'";

        Query query = em.createQuery(jpql);
        query.executeUpdate();

    }
    
//    public void actualizarStockctivos(String codigoActivos, int stock) throws Exception {
//
//        String jpql = "UPDATE InventarioActivos p SET p.stock = p.stock+" + stock + ", p.cantidadDisponible=p.cantidadDisponible+ " + stock + " WHERE p.codigoInvActivos='" + codigoActivos + "'";
//
//        Query query = em.createQuery(jpql);
//        query.executeUpdate();
//
//    }
    
     public void actualizarActivosDisponible(int codigoActivos, int stock) throws Exception {

        String jpql = "UPDATE InventarioActivos p SET p.cantidadDisponible = p.cantidadDisponible-" + stock + " WHERE p.activos='" + codigoActivos + "'";
                
        Query query = em.createQuery(jpql);
        query.executeUpdate();

    }

//    public List<InventarioActivos> ListaInventarioActivos(int codigoActivos) throws Exception {
//       // String jspql = "SELECT c FROM InventarioActivos c  ";
//        String jpql = "SELECT p FROM InventarioActivos p " + "WHERE idActivos  = '"
//                + codigoActivos + "'  OR numeroSerie = '" + codigoActivos + "' ";
//        Query q = em.createQuery(jpql, InventarioActivos.class);
//
//        return q.getResultList();
//    }

    public List<InventarioActivos> ListaInventario() throws Exception {
        String jpql = "SELECT c FROM InventarioActivos c  ";

        Query q = em.createQuery(jpql, InventarioActivos.class);

        return q.getResultList();
    }

}
