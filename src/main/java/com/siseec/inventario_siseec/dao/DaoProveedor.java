/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.dao;


import com.siseec.inventario_siseec.entity.Proveedor;
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
public class DaoProveedor {

    @PersistenceContext
    private EntityManager em;

    public void insertarProveedor(Proveedor proveedor) throws Exception {
        em.persist(proveedor);
    }

    public Proveedor buscarProveedorID(int idProveedor) throws Exception {
        return em.find(Proveedor.class, idProveedor);
    }

    public void actualizarProveedor(Proveedor proveedor) throws Exception {
        em.merge(proveedor);
    }

    public Proveedor buscarProveedor(String Ruc) throws Exception {
        Proveedor c = null;
        try {
            String jpql = "SELECT p FROM Proveedor p " + "WHERE Ruc LIKE :Ruc";
            TypedQuery<Proveedor> query = em.createQuery(jpql, Proveedor.class);
            query.setParameter("Ruc", Ruc);

            c = query.getSingleResult();

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return c;
    }

    public void actualizarestadoProveedor(int idProveedor, int nuevoestado) throws Exception {

        String jpql = "UPDATE Proveedor p SET p.estado =" + nuevoestado + " WHERE idProveedor='" + idProveedor + "'";

        Query query = em.createQuery(jpql);
        query.executeUpdate();

    }

    public List<Proveedor> ListaProveedor() throws Exception {
        String jpql = "SELECT c FROM Proveedor c";

        Query q = em.createQuery(jpql, Proveedor.class);

        return q.getResultList();
    }

}
