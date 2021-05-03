/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.dao;

import com.siseec.inventario_siseec.entity.ActivosEmpresa;
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
public class DaoActivosEmpresa {

    @PersistenceContext
    private EntityManager em;

    public void insertarActivosEmpresa(ActivosEmpresa activosEmpresa) throws Exception {
        em.persist(activosEmpresa);
        em.close();
    }

    public ActivosEmpresa buscarActivosID(int idActivos) throws Exception {
        ActivosEmpresa am = em.find(ActivosEmpresa.class, idActivos);
        em.close();
        return am;
    }

    public void actualizarProducto(ActivosEmpresa activosEmpresa) throws Exception {
        em.merge(activosEmpresa);
        em.close();
    }

    public ActivosEmpresa buscarActivosInsertar(String codigoActivos) throws Exception {
        ActivosEmpresa c = null;
        try {
            //String jpql = "SELECT p FROM Producto p " + "WHERE codigoProducto LIKE :codigoProducto";
            String jpql = "SELECT p FROM ActivosEmpresa p " + "WHERE codigoActivos  = '"
                    + codigoActivos + "'  OR numeroSerie = '" + codigoActivos + "' ";
            TypedQuery<ActivosEmpresa> query = em.createQuery(jpql, ActivosEmpresa.class);
            //query.setParameter("codigoProducto", codigoProducto);

            c = query.getSingleResult();
            em.close();
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return c;
    }

    public ActivosEmpresa buscarActivos(String parametro) throws Exception {
        ActivosEmpresa c = null;
        try {
//           String jpql = "SELECT p FROM ActivosEmpresa p " + "WHERE codigoActivos  = '" 
//                    + parametro+"' OR nombre = '" + parametro+"'  OR numeroSerie = '" + parametro+"' ";

            String jpql = "SELECT p FROM ActivosEmpresa p WHERE codigoActivos LIKE :parametro OR nombre LIKE :parametro OR numeroSerie LIKE :parametro";
            TypedQuery<ActivosEmpresa> query = em.createQuery(jpql, ActivosEmpresa.class);
            query.setParameter("parametro", parametro + "%");
//            String jpqsl = "SELECT p FROM LoginHistoricos p "
//                    + " WHERE id_socio LIKE :id";
//            Query q = em.createQuery(jpql, LoginHistoricos.class);
//            q.setParameter("id", id + "%");
//            return q.getResultList();
            c = query.getSingleResult();
            em.close();
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return c;
    }

    public List<ActivosEmpresa> buscarActivosLista(String parametro) throws Exception {
        List<ActivosEmpresa> c = null;
        try {
//           String jpql = "SELECT p FROM ActivosEmpresa p " + "WHERE codigoActivos  = '" 
//                    + parametro+"' OR nombre = '" + parametro+"'  OR numeroSerie = '" + parametro+"' ";

            String jpql = "SELECT p FROM ActivosEmpresa p WHERE codigoActivos LIKE :parametro OR nombre LIKE :parametro OR numeroSerie LIKE :parametro";
            TypedQuery<ActivosEmpresa> query = em.createQuery(jpql, ActivosEmpresa.class);
            query.setParameter("parametro", parametro + "%");
//            String jpqsl = "SELECT p FROM LoginHistoricos p "
//                    + " WHERE id_socio LIKE :id";
//            Query q = em.createQuery(jpql, LoginHistoricos.class);
//            q.setParameter("id", id + "%");
//            return q.getResultList();
            c = query.getResultList();
            em.close();
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return c;
    }
//    public void actualizarEstadoActivo(String codigoActivos, int nuevoestado) throws Exception {
//
//        String jpql = "UPDATE ActivosEmpresa p SET p.estado =" + nuevoestado + " WHERE codigoActivos='" + codigoActivos + "'";
//
//        Query query = em.createQuery(jpql);
//        query.executeUpdate();
//
//    }
//    public List<ActivosEmpresa> ListaActivosEmpresa() throws Exception {
//        String jpql = "SELECT c FROM ActivosEmpresa c ";
//
//        Query q = em.createQuery(jpql, ActivosEmpresa.class);
//
//        return q.getResultList();
//    }

    public List<ActivosEmpresa> ListaActivosEmpresaTodos() throws Exception {
        String jpql = "SELECT c FROM ActivosEmpresa c  ";

        Query q = em.createQuery(jpql, ActivosEmpresa.class);
        em.close();
        return q.getResultList();
    }

}
