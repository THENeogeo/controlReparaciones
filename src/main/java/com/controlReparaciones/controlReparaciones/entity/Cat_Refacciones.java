/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author gramirez25
 */
@Entity
@Table(name = "catalogo_refacciones")
public class Cat_Refacciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRefaccion;
    
    @Column(name = "refaccion_descripcion", nullable = false)
    private String descripcion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_equipo_id", nullable = false)
    private Cat_Tipo_Equipos tipoEquipo;
    
    private Integer estatus = 1;
}
