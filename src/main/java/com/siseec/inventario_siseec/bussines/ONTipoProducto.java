/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.bussines;



import com.siseec.inventario_siseec.dao.DaoTipo_Producto;
import com.siseec.inventario_siseec.entity.Tipo_Producto;
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
public class ONTipoProducto {

    @Inject
    private DaoTipo_Producto daotipop;
    
    
    public void insertarMarca(Tipo_Producto tipoProducto) throws Exception {
        daotipop.insertarTipoProducto(tipoProducto);
//        if (daocategoria.buscarCategoria(categoria.getIdCategoria())==null) {
//            System.out.println("ingresaro");
//            
//        } else {
//             System.out.println("ya existe");
//           
//        }
    }

    public Tipo_Producto buscarTipoProducto(String codigoTipoProducto) throws Exception {
       Tipo_Producto tipo=daotipop.buscarTipoProducto(codigoTipoProducto);
        if (tipo==null) {
            return null;
           
        } else {
            return tipo;
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
