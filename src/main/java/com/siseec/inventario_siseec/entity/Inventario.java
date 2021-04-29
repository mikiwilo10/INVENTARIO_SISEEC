/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Javier
 */
//@Entity
public class Inventario {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInventario;

    private String codigoInventario;
    private String descripcion;
    private int stock;
    private String fechaIngreso;
    private String usuario;
    private String ubucacion;
    
    private Producto producto;
    private Proveedor proveedor;
    private Orden_Compra ordenCompra;
    
    

}
