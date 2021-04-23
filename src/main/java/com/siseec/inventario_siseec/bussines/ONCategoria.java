/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.bussines;

import com.siseec.inventario_siseec.dao.DaoCategoria;
import com.siseec.inventario_siseec.entity.Categoria;

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
public class ONCategoria {

    @Inject
    private DaoCategoria daocategoria;
    
    
    public void insertarCategoria(Categoria categoria) throws Exception {
        daocategoria.insertarCategoria(categoria);
//        if (daocategoria.buscarCategoria(categoria.getIdCategoria())==null) {
//            System.out.println("ingresaro");
//            
//        } else {
//             System.out.println("ya existe");
//           
//        }
    }

    public Categoria buscarCategoriaID(int idCategoria) throws Exception {
        Categoria cat= daocategoria.buscarCategoriaID(idCategoria);
        return cat;
    }
    
    public Categoria buscarCategoria(String codigoCategoria, String descripcion) throws Exception {
       Categoria cat=daocategoria.buscarCategoria(codigoCategoria, descripcion);
        if (cat==null) {
            return null;
           
        } else {
            return cat;
        }
    }
    
    public Categoria buscarCategoriaDescripcion(String parametro) throws Exception {
       Categoria cat=daocategoria.buscarCategoriaDescripcion(parametro);
        if (cat==null) {
            return null;
           
        } else {
            return cat;
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
    
    
     public void actualizarestadoCategoia(Categoria cat) throws Exception {

       daocategoria.actualizarestadoCategoia(cat);

    }
    public List<Categoria> ListaCategorias() throws Exception {
       List<Categoria> listacategoria=null;
       listacategoria=daocategoria.ListaCategorias();
        return listacategoria;
    }

}
