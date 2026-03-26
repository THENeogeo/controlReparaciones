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
 * @author Geovani
 */
@Entity
@Table(name = "catalogo_marcas")
public class Cat_Marcas implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMarca;
    
    @Column(name = "marca_descripcion", nullable = false)
    private String descripcion;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_equipo_id", nullable = false)
    private Cat_Tipo_Equipos tipoEquipo;
    
    private Integer estatus = 1;

    public Cat_Marcas() {
    }

    public Cat_Marcas(Integer idMarca, String descripcion, Cat_Tipo_Equipos tipoEquipo) {
        this.idMarca = idMarca;
        this.descripcion = descripcion;
        this.tipoEquipo = tipoEquipo;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
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
