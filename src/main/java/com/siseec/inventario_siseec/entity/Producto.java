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
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    private String codigoProducto;
    private String descripcion;
    private String fechaIngreso;
    private double precioCompra;
    private double precioVenta;
    private long numeroSerie;
    private String tipoUnidad;
    private int estado;
    private int Stock;
    private String observacionProducto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoProducto")
    private Tipo_Producto tipoProducto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMarca")
    private Marca marcaProducto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategoria")
    private Categoria categoriaProducto;

    @OneToMany(mappedBy = "producto", cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<Detalle_OrdenCompra> detalleOrden;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripción(String descripción) {
        this.descripcion = descripción;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public long getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(long numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Tipo_Producto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(Tipo_Producto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Marca getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(Marca marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Categoria getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(Categoria categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public String getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(String tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getObservacionProducto() {
        return observacionProducto;
    }

    public void setObservacionProducto(String observacionProducto) {
        this.observacionProducto = observacionProducto;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto
                + ", codigoProducto=" + codigoProducto + ", "
                + "descripcion=" + descripcion
                + ", fechaIngreso=" + fechaIngreso
                + ", precioCompra=" + precioCompra
                + ", precioVenta="
                + precioVenta + ", numeroSerie=" + numeroSerie
                + ", tipoProducto=" + tipoProducto
                + ", marcaProducto=" + marcaProducto
                + ", proveedor=" + proveedor + ", categoriaProducto="
                + categoriaProducto + ", tipoUnidad=" + tipoUnidad
                + ", estado=" + estado
                + ", Stock=" + Stock
                + ", observacionProducto=" + observacionProducto + '}';
    }

}
