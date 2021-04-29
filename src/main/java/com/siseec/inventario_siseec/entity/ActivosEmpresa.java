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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Javier
 */
@Entity
public class ActivosEmpresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActivos;
    
    private String codigoActivos;
    private String nombre;
    private String descripcion;
    private String marca;
    private String modelo;
    private String numeroSerie;
    
    @OneToMany(mappedBy = "activos", cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<InventarioActivos> inventarioActivos;

    public int getIdActivos() {
        return idActivos;
    }

    public void setIdActivos(int idActivos) {
        this.idActivos = idActivos;
    }

    public String getCodigoActivos() {
        return codigoActivos;
    }

    public void setCodigoActivos(String codigoActivos) {
        this.codigoActivos = codigoActivos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public List<InventarioActivos> getInventarioActivos() {
        return inventarioActivos;
    }

    public void setInventarioActivos(List<InventarioActivos> inventarioActivos) {
        this.inventarioActivos = inventarioActivos;
    }
    
    
}
