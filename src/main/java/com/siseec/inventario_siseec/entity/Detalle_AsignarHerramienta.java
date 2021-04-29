/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.entity;

/**
 *
 * @author Javier
 */
public class Detalle_AsignarHerramienta {
    
    private int idDetalleDesignar;
    private String codigoDetalleDesignar;
    
    
    private int cantidad;
    private String observacion;
    private String estado;
   
    private String usuario;
    
    private Asignar_Herramienta designar;
    
    private ActivosEmpresa activo;
    
}
