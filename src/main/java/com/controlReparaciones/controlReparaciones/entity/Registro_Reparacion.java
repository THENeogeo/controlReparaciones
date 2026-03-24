/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;

/**
 *
 * @author gramirez25
 */

@Entity
@Table(name = "registro_reparacion")
public class Registro_Reparacion {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idReparacion;
    
    @ManyToOne(fetch = FetchType.LAZY) // Solo se trae el objeto principal. La relación se carga hasta que realmente la usas.
    @JoinColumn(name = "tipo_equipo_id")
    private Cat_Tipo_Equipos tipoEquipo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id", nullable = false)
    private Cat_Marcas marca;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modelo_id", nullable = false)
    private Cat_Modelos modelo;
    
    private String inventario; // 16 caracteres 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refaccion_id", nullable = false)
    private Cat_Refacciones refaccion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_refaccion_id", nullable = false)
    private Cat_Tipo_Refaccion tipoRefaccion;
    
    private String refaccionInventario;
    private String descripcionReporte; 
    private String expediente;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id", nullable = false)
    private Cat_Areas area;
    
    private Date fechaRegistro;
    
}
