/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.bussines;

import com.siseec.inventario_siseec.dao.DaoAsignacionActivos;
import com.siseec.inventario_siseec.dao.DaoInventarioActivos;
import com.siseec.inventario_siseec.entity.Detalle_AsignarHerramienta;
import com.siseec.inventario_siseec.entity.InventarioActivos;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Javier
 */
@Stateless
public class ONAsignacionActivos {

    @Inject
    private DaoAsignacionActivos daoactivos;

    @Inject
    private ONInventarioActivos oninventario;

    /*
    public boolean insertarHerramientas(List<Detalle_AsignarHerramienta> herramientas) throws Exception {
        InventarioActivos inventarios;
        boolean estado = false;
        for (Detalle_AsignarHerramienta activo : herramientas) {

            inventarios = oninventario.buscarInvenatrioActivos(activo.getAsignacionactivos().getIdActivos());

            if (inventarios == null) {
                System.out.println("no existe el activo");
                estado = false;
            } else {
                if (activo.getCantidad() >= 0 && activo.getCantidad() > inventarios.getCantidadDisponible()) {
                    System.out.println("no cuenta con muchos activos");
                    estado = false;
                } else {
                    daoactivos.insertarHerramientas(activo);
                    oninventario.actualizarActivosDisponible(activo.getAsignacionactivos().getIdActivos(), activo.getCantidad());
                    estado = true;
                }

            }

        }
        return estado;
    }
     */
    public String insertarHerramientas(List<Detalle_AsignarHerramienta> herramientas) throws Exception {
        String respuesta = "";
       // InventarioActivos inventarios = null;
        boolean estado;

        for (Detalle_AsignarHerramienta activo : herramientas) {

            estado = verificarCantidad(activo.getAsignacionactivos().getIdActivos(), activo.getCantidad());

            if (estado == false) {
                System.out.println("no existe el activo");
                respuesta = "NDA";
            } else {
                respuesta = "INGRESO";
                daoactivos.insertarHerramientas(activo);
                oninventario.actualizarActivosDisponible(activo.getAsignacionactivos().getIdActivos(), activo.getCantidad());
            }

        }
        return respuesta;
    }

    public boolean verificarCantidad(int idActivo, int cantidad)  {
        boolean estado = false;
        InventarioActivos inventarios;
        try {
            inventarios = oninventario.buscarInvenatrioActivos(idActivo);
            if (cantidad <= inventarios.getCantidadDisponible()) {
                estado = true;
            } else {
                estado = false;
            }
        } catch (Exception ex) {
           // Logger.getLogger(ONAsignacionActivos.class.getName()).log(Level.SEVERE, null, ex);
            estado = false;
        }

        return estado;
    }

    public List<Detalle_AsignarHerramienta> ListaAsignacion() throws Exception {

        List<Detalle_AsignarHerramienta> lista = null;
        lista = daoactivos.ListaAsignacion();
        return lista;
    }

}
