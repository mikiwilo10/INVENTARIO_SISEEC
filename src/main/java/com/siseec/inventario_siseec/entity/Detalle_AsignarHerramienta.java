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
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author Javier
 */
@Entity
public class Detalle_AsignarHerramienta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleDesignar;
    
    private String codigoDetalleDesignar;
    
    @PositiveOrZero 
    private int cantidad;
    
    private String observacion;
    private String bodeguero;
    private String estado;
    private String fechaDesignar;
    private String fechaRetorno;
   
    private String usuario;
    
   // private Asignar_Herramienta designar;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idActivos")
    private ActivosEmpresa asignacionactivos;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idInventarioActivos")
    private InventarioActivos inventario;
    
    

    public int getIdDetalleDesignar() {
        return idDetalleDesignar;
    }

    public void setIdDetalleDesignar(int idDetalleDesignar) {
        this.idDetalleDesignar = idDetalleDesignar;
    }

    public String getCodigoDetalleDesignar() {
        return codigoDetalleDesignar;
    }

    public void setCodigoDetalleDesignar(String codigoDetalleDesignar) {
        this.codigoDetalleDesignar = codigoDetalleDesignar;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getBodeguero() {
        return bodeguero;
    }

    public void setBodeguero(String bodeguero) {
        this.bodeguero = bodeguero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaDesignar() {
        return fechaDesignar;
    }

    public void setFechaDesignar(String fechaDesignar) {
        this.fechaDesignar = fechaDesignar;
    }

    public String getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(String fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public ActivosEmpresa getAsignacionactivos() {
        return asignacionactivos;
    }

    public void setAsignacionactivos(ActivosEmpresa asignacionactivos) {
        this.asignacionactivos = asignacionactivos;
    }

    public InventarioActivos getInventario() {
        return inventario;
    }

    public void setInventario(InventarioActivos inventario) {
        this.inventario = inventario;
    }

  

    
    
    
}
