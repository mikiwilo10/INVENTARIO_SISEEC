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
public class InventarioActivos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInventarioActivos;
    
    private String codigoInvActivos;
    
    private int stock;
    private int cantidadDisponible;
    private String observacion;
    private String unidad;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idActivos")
    private ActivosEmpresa activos;

    @OneToMany(mappedBy = "inventario", cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<Detalle_AsignarHerramienta> detalleherramientas;
    
    
    
    public int getIdInventarioActivos() {
        return idInventarioActivos;
    }

    public void setIdInventarioActivos(int idInventarioActivos) {
        this.idInventarioActivos = idInventarioActivos;
    }

    public String getCodigoInvActivos() {
        return codigoInvActivos;
    }

    public void setCodigoInvActivos(String codigoInvActivos) {
        this.codigoInvActivos = codigoInvActivos;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public ActivosEmpresa getActivos() {
        return activos;
    }

    public void setActivos(ActivosEmpresa activos) {
        this.activos = activos;
    }

   
}
