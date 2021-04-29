/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.bussines;

import com.siseec.inventario_siseec.dao.DaoMarca;

import com.siseec.inventario_siseec.entity.Marca;

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
public class ONMarca {
    
    @Inject
    private DaoMarca daomarca;
    
    public void insertarMarca(Marca marca) throws Exception {
        daomarca.insertarMarca(marca);
//        if (daocategoria.buscarCategoria(categoria.getIdCategoria())==null) {
//            System.out.println("ingresaro");
//            
//        } else {
//             System.out.println("ya existe");
//           
//        }
    }
    
    public Marca buscarMarca(String codigoCategoria) throws Exception {
        Marca marca = daomarca.buscarMarca(codigoCategoria);
        if (marca == null) {
            return null;
            
        } else {
            return marca;
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

    public void actualizarestadoMarca(Marca marca) throws Exception {
        daomarca.actualizarMarca(marca);
    }
    
    public List<Marca> buscarMarcaDescripcion(String codigoMarca) throws Exception {
        return daomarca.buscarMarcaDescripcion(codigoMarca);
    }

    public List<Marca> ListarMarcas() throws Exception {
        
        List<Marca> Marca = null;
        Marca = daomarca.ListaMarca();
        return Marca;
    }
    
}
