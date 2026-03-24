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
@Table(name = "catalogo_modelos")
public class Cat_Modelos {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idModelo;
    
    @Column(name = "modelo_descripcion", nullable = false) // nullable = false -> No permite datos nulos
    private String descripcion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id", nullable = false)
    private Cat_Marcas marca;
    
    private Integer estatus = 1;
    
}
