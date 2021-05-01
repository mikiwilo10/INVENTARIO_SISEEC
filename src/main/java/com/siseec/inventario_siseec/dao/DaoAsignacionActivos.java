/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.dao;

import com.siseec.inventario_siseec.entity.ActivosEmpresa;
import com.siseec.inventario_siseec.entity.Detalle_AsignarHerramienta;
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
public class DaoAsignacionActivos {

    @PersistenceContext
    private EntityManager em;

    public void insertarHerramientas(Detalle_AsignarHerramienta herramientas) throws Exception {
//       int cantidadHerramientas=0;
//       Detalle_AsignarHerramienta detalle;
//               //herramientas.size();
//        //if (cantidadHerramientas<=herramientas.size()) {
//            for (Detalle_AsignarHerramienta herramienta : herramientas) {
//                detalle= new Detalle_AsignarHerramienta();
//                detalle=herramienta;
        try {
            em.persist(herramientas);
        } catch (Exception e) {
            System.out.println("Error camas"+e.toString());
        }
//       // h
//        }

    }

//    public InventarioActivos buscarInventarioID(int idActivos) throws Exception {
//        return em.find(InventarioActivos.class, idActivos);
//    }
//
//    public void actualizarInventarioActivos(InventarioActivos InventarioActivos) throws Exception {
//        em.merge(InventarioActivos);
//    }
//    public InventarioActivos buscarActivosInsertar(String codigoActivos) throws Exception {
//        InventarioActivos c = null;
//        try {
//            //String jpql = "SELECT p FROM Producto p " + "WHERE codigoProducto LIKE :codigoProducto";
//            String jpql = "SELECT p FROM InventarioActivos p " + "WHERE p.codigoInvActivos  = '"
//                    + codigoActivos + "' ";
//            TypedQuery<InventarioActivos> query = em.createQuery(jpql, InventarioActivos.class);
//            //query.setParameter("codigoProducto", codigoProducto);
//
//            c = query.getSingleResult();
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            return null;
//        }
//        return c;
//    }
//
//    public InventarioActivos buscarActivos(String parametro) throws Exception {
//        InventarioActivos c = null;
//        try {
//            String jpql = "SELECT p FROM InventarioActivos p " + "WHERE idActivos  = '"
//                    + parametro + "' ";
//
//            TypedQuery<InventarioActivos> query = em.createQuery(jpql, InventarioActivos.class);
//            //  query.setParameter("codigoProducto", codigoProducto);
//
//            c = query.getSingleResult();
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            return null;
//        }
//        return c;
//    }
//
    public void actualizarEstadoInventarioActivos(String codigoActivos, String nuevoestado,int idDetalleDesignar) throws Exception {

        String jpql = "UPDATE Detalle_AsignarHerramienta p SET p.estado = '" + nuevoestado 
                + "' WHERE p.idDetalleDesignar=" + idDetalleDesignar 
                + " AND p.codigoDetalleDesignar='" + codigoActivos + "'  ";

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
    public List<Detalle_AsignarHerramienta> ListaAsignacion() throws Exception {
        String jpql = "SELECT c FROM Detalle_AsignarHerramienta c  ";

        Query q = em.createQuery(jpql, Detalle_AsignarHerramienta.class);

        return q.getResultList();
    }

}
