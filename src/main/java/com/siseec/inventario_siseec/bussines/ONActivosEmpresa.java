/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.bussines;




import com.siseec.inventario_siseec.dao.DaoActivosEmpresa;
import com.siseec.inventario_siseec.entity.ActivosEmpresa;
import com.siseec.inventario_siseec.entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;


/**
 *
 * @author Javier
 */
@Stateless
public class ONActivosEmpresa {

    @Inject
    private DaoActivosEmpresa daoactivos;
    
   
    
    
    public void insertarActivosEmpresa(ActivosEmpresa activosEmpresa) throws Exception {
      
        daoactivos.insertarActivosEmpresa(activosEmpresa);
    }

    public ActivosEmpresa buscarProveedor(String codigoProducto) throws Exception {
       ActivosEmpresa prod=daoactivos.buscarActivosInsertar(codigoProducto);
        if (prod==null) {
            return null;
           
        } else {
            return prod;
        }
    }
    
    
    public ActivosEmpresa buscarActivos(String parametro) throws Exception {
       ActivosEmpresa prod=daoactivos.buscarActivos(parametro);
        if (prod==null) {
            return null;
           
        } else {
            return prod;
        }
    }

    
//    public void actualizarEstadoProducto(String codigoProducto, int nuevoestado) throws Exception {
//
//      daoproducto.actualizarEstadoProducto(codigoProducto, nuevoestado);
//    }

    public List<ActivosEmpresa> buscarActivosLista(String parametro) throws Exception {
    
       List<ActivosEmpresa> ActivosEmpresa=null;
       ActivosEmpresa=daoactivos.buscarActivosLista(parametro);
        return ActivosEmpresa;
    }
    
    public List<ActivosEmpresa> ListarActivosEmpresa() throws Exception {
    
       List<ActivosEmpresa> ActivosEmpresa=null;
       ActivosEmpresa=daoactivos.ListaActivosEmpresaTodos();
        return ActivosEmpresa;
    }
    
    

    
   
}
