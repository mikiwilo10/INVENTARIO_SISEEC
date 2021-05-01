/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siseec.inventario_siseec.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Javier
 */
@Entity
public class HistoricoAsignarActivo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistorico;
    
    private String estadoAnterior;
    private String estadoNuevo;
    private String fecha;
    private String usuario;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDetalleDesignar")
    private Detalle_AsignarHerramienta herramienta;
    
    
}
