/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.dao;


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
public class DaoProducto {

    @PersistenceContext
    private EntityManager em;

    public void insertarProducto(Producto producto) throws Exception {
        em.persist(producto);
    }

    public Producto buscarProductoID(int idProducto) throws Exception {
        return em.find(Producto.class, idProducto);
    }

    public void actualizarProducto(Producto producto) throws Exception {
        em.merge(producto);
    }

    public Producto buscarProducto(String codigoProducto) throws Exception {
        Producto c = null;
        try {
            //String jpql = "SELECT p FROM Producto p " + "WHERE codigoProducto LIKE :codigoProducto";
             String jpql = "SELECT p FROM Producto p " + "WHERE codigoProducto  = '" 
                    + codigoProducto+"' OR descripcion = '" + codigoProducto+"'  OR numeroSerie = '" + codigoProducto+"' ";
            TypedQuery<Producto> query = em.createQuery(jpql, Producto.class);
            //query.setParameter("codigoProducto", codigoProducto);

            c = query.getSingleResult();

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return c;
    }
    
    public Producto buscarProductos(String parametro) throws Exception {
        Producto c = null;
        try {
            String jpql = "SELECT p FROM Producto p " + "WHERE codigoProducto  = '" 
                    + parametro+"' OR descripcion = '" + parametro+"'  OR numeroSerie = '" + parametro+"' ";
            
            TypedQuery<Producto> query = em.createQuery(jpql, Producto.class);
          //  query.setParameter("codigoProducto", codigoProducto);

            c = query.getSingleResult();

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return c;
    }

    public void actualizarEstadoProducto(String codigoProducto, int nuevoestado) throws Exception {

        String jpql = "UPDATE Producto p SET p.estado =" + nuevoestado + " WHERE codigoProducto='" + codigoProducto + "'";

        Query query = em.createQuery(jpql);
        query.executeUpdate();

    }

    public List<Producto> ListaProducto() throws Exception {
        String jpql = "SELECT c FROM Producto c WHERE estado='" + 1 + "'";

        Query q = em.createQuery(jpql, Producto.class);

        return q.getResultList();
    }
    
    public List<Producto> ListaProductoTodos() throws Exception {
        String jpql = "SELECT c FROM Producto c  ";

        Query q = em.createQuery(jpql, Producto.class);

        return q.getResultList();
    }
    
     public List<Producto> ListaProductoMarca(int marca)throws Exception{
      
        String jpql = "SELECT e FROM Producto e JOIN e.marcaProducto p where  p.idMarca  = '" + marca+"' ";
    	   
        Query q = em.createQuery(jpql,Producto.class);
        return q.getResultList();
    }
   
     public List<Producto> ListaProductoCategoria(int Categoria) throws Exception {
         String jpql = "SELECT e FROM Producto e JOIN e.categoriaProducto p where  p.idCategoria  = '" + Categoria+"' ";
    	
        Query q = em.createQuery(jpql, Producto.class);

        return q.getResultList();
    }
    
     public List<Producto> ListaProductoProveedor(int Proveedor)throws Exception{
    
        String jpql = "SELECT e FROM Producto e JOIN e.proveedor p where  p.idProveedor  = '" + Proveedor+"' ";
    	   
        Query q = em.createQuery(jpql,Producto.class);
        return q.getResultList();
    }
    
    
    
   

}
