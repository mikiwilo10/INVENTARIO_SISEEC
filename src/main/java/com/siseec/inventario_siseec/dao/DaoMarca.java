/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.dao;

import com.siseec.inventario_siseec.entity.Marca;
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
public class DaoMarca {

    @PersistenceContext
    private EntityManager em;

    public void insertarMarca(Marca marca) throws Exception {
        em.persist(marca);
    }

    public Marca buscarMarcaID(int idCategoria) throws Exception {
        return em.find(Marca.class, idCategoria);
    }

    public void actualizarMarca(Marca marca) throws Exception {
        em.merge(marca);
    }

    public Marca buscarMarca(String codigoMarca) throws Exception {
        Marca c = null;
        try {
            String jpql = "SELECT p FROM Marca p " + "WHERE codigoMarca LIKE :codigoMarca";
            //   String jpql = "SELECT p FROM Categoria p " + "WHERE codigoCategoria = '" + parametro+"' OR nombre = '" + parametro+"' ";

            TypedQuery<Marca> query = em.createQuery(jpql, Marca.class);
            query.setParameter("codigoMarca", codigoMarca);

            c = query.getSingleResult();

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return c;
    }

    public List<Marca> buscarMarcaDescripcion(String codigoMarca) throws Exception {
        List<Marca> lista = null;
        Query q;
        try {
            // String jpql = "SELECT p FROM Marca p " + "WHERE codigoMarca LIKE :codigoMarca";
            String jpql = "SELECT p FROM Marca p " + "WHERE codigoMarca = '" + codigoMarca + "' OR nombre LIKE '" + codigoMarca + "'  ";

            q = em.createQuery(jpql, Marca.class);
            lista = q.getResultList();
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return lista;
    }

    public void actualizarestadoMarca(Marca marca) throws Exception {

        String jpql = "UPDATE Marca p SET p.estado =" + marca.getEstado() + " WHERE codigoMarca='" + marca.getCodigoMarca() + "'";

        Query query = em.createQuery(jpql);
        query.executeUpdate();

    }

    public List<Marca> ListaMarca() throws Exception {
        String jpql = "SELECT c FROM Marca c WHERE estado='" + 1 + "'";

        Query q = em.createQuery(jpql, Marca.class);

        return q.getResultList();
    }

}
