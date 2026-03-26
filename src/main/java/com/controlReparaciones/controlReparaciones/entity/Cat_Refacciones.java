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
import java.io.Serializable;

/**
 *
 * @author gramirez25
 */
@Entity
@Table(name = "catalogo_refacciones")
public class Cat_Refacciones implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRefaccion;
    
    @Column(name = "refaccion_descripcion", nullable = false)
    private String descripcion;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_equipo_id", nullable = false)
    private Cat_Tipo_Equipos tipoEquipo;
    
    private Integer estatus = 1;

    public Cat_Refacciones() {
    }

    public Cat_Refacciones(Integer idRefaccion, String descripcion, Cat_Tipo_Equipos tipoEquipo) {
        this.idRefaccion = idRefaccion;
        this.descripcion = descripcion;
        this.tipoEquipo = tipoEquipo;
    }

    public Integer getIdRefaccion() {
        return idRefaccion;
    }

    public void setIdRefaccion(Integer idRefaccion) {
        this.idRefaccion = idRefaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cat_Tipo_Equipos getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(Cat_Tipo_Equipos tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }
    
    
}
