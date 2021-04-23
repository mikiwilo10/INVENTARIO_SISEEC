/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Javier
 */
@Entity
public class Detalle_OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleOrden;

    private int cantidad;
    private double subTotal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idOrdenCompra")
    private Orden_Compra ordenCompra;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    public int getIdDetalleOrden() {
        return idDetalleOrden;
    }

    public void setIdDetalleOrden(int idDetalleOrden) {
        this.idDetalleOrden = idDetalleOrden;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Orden_Compra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(Orden_Compra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Detalle_OrdenCompra{" + "idDetalleOrden=" + idDetalleOrden + ", cantidad=" + cantidad + ", subTotal=" + subTotal + ", ordenCompra=" + ordenCompra + ", producto=" + producto + '}';
    }
    
    

}
