/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.parametros;

import com.siseec.inventario_siseec.entity.Detalle_OrdenCompra;
import com.siseec.inventario_siseec.entity.Proveedor;
import java.util.List;

/**
 *
 * @author Javier
 */
public class ParametroOrden {
   
    private String codigoOrdenCompra;
    private String descripcion;

    private String fecha;

    private double subTotal;
    private double iva;
    private double totalOrden;

    private String Usuario;

    private String Ruc;
    
    private List<DetalleCompra> listaDetalleCompra;

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

    public String getRuc() {
        return Ruc;
    }

    public void setRuc(String Ruc) {
        this.Ruc = Ruc;
    }

    public List<DetalleCompra> getListaDetalleCompra() {
        return listaDetalleCompra;
    }

    public void setListaDetalleCompra(List<DetalleCompra> listaDetalleCompra) {
        this.listaDetalleCompra = listaDetalleCompra;
    }
    
    
}
