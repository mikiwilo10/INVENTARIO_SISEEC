/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.bussines;

import com.siseec.inventario_siseec.dao.DaoInventarioActivos;
import com.siseec.inventario_siseec.entity.InventarioActivos;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Javier
 */
@Stateless
public class ONInventarioActivos {

    @Inject
    private DaoInventarioActivos daoactivos;

    public void insertarInventarioActivos(InventarioActivos inventarioActivos) throws Exception {

        daoactivos.insertarInventarioActivos(inventarioActivos);
    }

    public InventarioActivos buscarActivosInsertar(String parametro) throws Exception {
        InventarioActivos prod = daoactivos.buscarActivosInsertar(parametro);
        if (prod == null) {
            return null;

        } else {
            return prod;
        }
    }
    
     public InventarioActivos buscarInvenatrioActivos(int parametro) throws Exception {
        InventarioActivos prod = daoactivos.buscarActivos(parametro);
        if (prod == null) {
            return null;

        } else {
            return prod;
        }
    }

    public void actualizarEstadoInventarioActivos(String codigoActivos, int stock) throws Exception {
        daoactivos.actualizarEstadoInventarioActivos(codigoActivos, stock);
    }

     public void actualizarActivosDisponible(int codigoActivos, int stock) throws Exception {

        daoactivos.actualizarActivosDisponible(codigoActivos, stock);

    }
//    public List<InventarioActivos> ListaInventarioActivos(int codigoActivos) throws Exception {
//        List<InventarioActivos> ActivosEmpresa = null;
//        ActivosEmpresa = daoactivos.ListaInventarioActivos(codigoActivos);
//        return ActivosEmpresa;
//    }

    public List<InventarioActivos> ListaInventario() throws Exception {

        List<InventarioActivos> ActivosEmpresa = null;
        ActivosEmpresa = daoactivos.ListaInventario();
        return ActivosEmpresa;
    }

}
