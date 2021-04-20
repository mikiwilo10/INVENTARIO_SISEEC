/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.bussines;



import com.siseec.inventario_siseec.dao.DaoProveedor;
import com.siseec.inventario_siseec.entity.Proveedor;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author Javier
 */
@Stateless
public class ONProveedor {

    @Inject
    private DaoProveedor daoproveedor;
    
    
    public void insertarCategoria(Proveedor proveedor) throws Exception {
        daoproveedor.insertarProveedor(proveedor);
    }

    public Proveedor buscarProveedor(String Ruc) throws Exception {
       Proveedor prov=daoproveedor.buscarProveedor(Ruc);
        if (prov==null) {
            return null;
           
        } else {
            return prov;
        }
    }
//
//    public void actualizarCredito(Marco categoria) throws Exception {
//        em.merge(categoria);
//    }
//
//    public void actualizarestadoCategoia(int idCategoria, int nuevoestado) throws Exception {
//
//        String jpql = "UPDATE Marco p SET p.idCategoria = p.estado+" + nuevoestado + " WHERE idCategoria='" + idCategoria + "'";
//
//        Query query = em.createQuery(jpql);
//        query.executeUpdate();
//
//    }
//
//    public List<Categoria> ListaCategorias() throws Exception {
//        String jpql = "SELECT c FROM Marco c";
//
//        Query q = em.createQuery(jpql, Marco.class);
//
//        return q.getResultList();
//    }

}
