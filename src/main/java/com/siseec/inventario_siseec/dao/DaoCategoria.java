/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.dao;


import com.siseec.inventario_siseec.entity.Categoria;
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
public class DaoCategoria {

    @PersistenceContext
    private EntityManager em;

    public void insertarCategoria(Categoria categoria) throws Exception {
        em.persist(categoria);
    }

    public Categoria buscarCategoriaID(int idCategoria) throws Exception {
        return em.find(Categoria.class, idCategoria);
    }

//    public void actualizarCredito(Categoria categoria) throws Exception {
//        em.merge(categoria);
//    }

    public Categoria buscarCategoria(String codigoCategoria,String nombre ) throws Exception {
        Categoria c = null;
        try {
            String jpql = "SELECT p FROM Categoria p " + "WHERE codigoCategoria = '" + codigoCategoria+"' OR nombre = '" + nombre+"' ";
            TypedQuery<Categoria> query = em.createQuery(jpql, Categoria.class);
           // query.setParameter("codigoCategoria", parametro);
            //query.setParameter("descripcion", parametro);

            c = query.getSingleResult();

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return c;
    }
    
    public Categoria buscarCategoriaDescripcion(String parametro) throws Exception {
        Categoria c = null;
        try {
            String jpql = "SELECT p FROM Categoria p " + "WHERE codigoCategoria = '" + parametro+"' OR nombre = '" + parametro+"' ";
            TypedQuery<Categoria> query = em.createQuery(jpql, Categoria.class);
           // query.setParameter("codigoCategoria", parametro);
            //query.setParameter("descripcion", parametro);

            c = query.getSingleResult();

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return c;
    }

    public void actualizarestadoCategoia(Categoria cat) throws Exception {

        String jpql = "UPDATE Categoria p SET p.estado =" + cat.getEstado() + " WHERE codigoCategoria='" + cat.getCodigoCategoria() + "'";

        Query query = em.createQuery(jpql);
        query.executeUpdate();

    }

    public List<Categoria> ListaCategorias() throws Exception {
        String jpql = "SELECT c FROM Categoria c WHERE estado='" + 1 + "'";

        Query q = em.createQuery(jpql, Categoria.class);

        return q.getResultList();
    }

}
