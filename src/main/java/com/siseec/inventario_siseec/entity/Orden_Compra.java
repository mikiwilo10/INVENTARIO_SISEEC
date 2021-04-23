/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Javier
 */
@Entity
public class Orden_Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrdenCompra;

    private String codigoOrdenCompra;
    private String descripcion;

    private String fecha;

    private double subTotal;
    private double iva;
    private double totalOrden;

    private String Usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedorOrden;

    @OneToMany(mappedBy = "ordenCompra", cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<Detalle_OrdenCompra> detalleOrden;

    public int getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(int idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public String getCodigoOrdenCompra() {
        return codigoOrdenCompra;
    }

    public void setCodigoOrdenCompra(String codigoOrdenCompra) {
        this.codigoOrdenCompra = codigoOrdenCompra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotalOrden() {
        return totalOrden;
    }

    public void setTotalOrden(double totalOrden) {
        this.totalOrden = totalOrden;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public Proveedor getProveedorOrden() {
        return proveedorOrden;
    }

    public void setProveedorOrden(Proveedor proveedorOrden) {
        this.proveedorOrden = proveedorOrden;
    }

    public List<Detalle_OrdenCompra> getDetalleOrden() {
        return detalleOrden;
    }

    public void setDetalleOrden(List<Detalle_OrdenCompra> detalleOrden) {
        this.detalleOrden = detalleOrden;
    }

    @Override
    public String toString() {
        return "Orden_Compra{" + "idOrdenCompra=" + idOrdenCompra + ", codigoOrdenCompra=" + codigoOrdenCompra + ", descripcion=" + descripcion + ", fecha=" + fecha + ", subTotal=" + subTotal + ", iva=" + iva + ", totalOrden=" + totalOrden + ", Usuario=" + Usuario + ", proveedorOrden=" + proveedorOrden + ", detalleOrden=" + detalleOrden + '}';
    }
    
    

}
