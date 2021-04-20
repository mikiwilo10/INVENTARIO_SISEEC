/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.bussines;




import com.siseec.inventario_siseec.dao.DaoCategoria;
import com.siseec.inventario_siseec.dao.DaoMarca;
import com.siseec.inventario_siseec.dao.DaoProducto;
import com.siseec.inventario_siseec.entity.Categoria;
import com.siseec.inventario_siseec.entity.Marca;
import com.siseec.inventario_siseec.entity.Producto;
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
public class ONProducto {

    @Inject
    private DaoProducto daoproducto;
    
    @Inject
    private ONCategoria oncat;
    
    @Inject
    private ONMarca onmarca;
    
    
    @Inject
    private ONProveedor onproveedor;
    
    @Inject
    private ONTipoProducto ontipo;
    
    
    public void insertarProducto(Producto producto) throws Exception {
      //  Marca marca=onmarca.buscarMarca(producto.getMarcaProducto().);
      // Categoria cat=producto.getCategoriaProducto();
      //  System.out.println("kk"+producto.getCategoriaProducto().getDescripcion());
     // producto.setCategoriaProducto(cat);
        daoproducto.insertarProducto(producto);
    }

    public Producto buscarProveedor(String codigoProducto) throws Exception {
       Producto prod=daoproducto.buscarProducto(codigoProducto);
        if (prod==null) {
            return null;
           
        } else {
            return prod;
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
