/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.dao;

import com.siseec.inventario_siseec.entity.Tipo_Producto;
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
public class DaoTipo_Producto {

    @PersistenceContext
    private EntityManager em;

    public void insertarTipoProducto(Tipo_Producto tipoproducto) throws Exception {
        em.persist(tipoproducto);
    }

    public Tipo_Producto buscarTipoProductoID(int idProducto) throws Exception {
        return em.find(Tipo_Producto.class, idProducto);
    }

    public void actualizarTipoProducto(Tipo_Producto tipoProducto) throws Exception {
        em.merge(tipoProducto);
    }

    public Tipo_Producto buscarTipoProducto(String codigoTipoProducto) throws Exception {
        Tipo_Producto tp = null;
        try {
            String jpql = "SELECT p FROM Tipo_Producto p " + "WHERE codigoTipoProducto LIKE :codigoTipoProducto";
            TypedQuery<Tipo_Producto> query = em.createQuery(jpql, Tipo_Producto.class);
            query.setParameter("codigoTipoProducto", codigoTipoProducto);

            tp = query.getSingleResult();

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return tp;
    }

    public void actualizarestadoTipoProducto(int idTipoProducto, int nuevoestado) throws Exception {

        String jpql = "UPDATE Tipo_Producto p SET p.estado =" + nuevoestado + " WHERE idTipoProducto='" + idTipoProducto + "'";

        Query query = em.createQuery(jpql);
        query.executeUpdate();

    }

    public List<Tipo_Producto> ListaTipoProducto() throws Exception {
        String jpql = "SELECT c FROM Tipo_Producto c";

        Query q = em.createQuery(jpql, Tipo_Producto.class);

        return q.getResultList();
    }

}
