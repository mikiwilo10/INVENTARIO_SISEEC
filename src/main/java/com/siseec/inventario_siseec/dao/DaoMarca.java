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
            TypedQuery<Marca> query = em.createQuery(jpql, Marca.class);
            query.setParameter("codigoMarca", codigoMarca);

            c = query.getSingleResult();

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return c;
    }

    public void actualizarestadoMarca(int idCategoria, int nuevoestado) throws Exception {

        String jpql = "UPDATE Marca p SET p.idCategoria = p.estado+" + nuevoestado + " WHERE idCategoria='" + idCategoria + "'";

        Query query = em.createQuery(jpql);
        query.executeUpdate();

    }

    public List<Marca> ListaMarca() throws Exception {
        String jpql = "SELECT c FROM Marca c";

        Query q = em.createQuery(jpql, Marca.class);

        return q.getResultList();
    }

}
