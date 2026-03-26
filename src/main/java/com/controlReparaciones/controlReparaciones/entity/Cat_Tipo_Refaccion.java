/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Geovani
 */
@Entity
@Table(name = "catalogo_tipo_refaccion")
public class Cat_Tipo_Refaccion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoRefaccion;
    
    @Column(name = "tipo_refaccion_descripcion", nullable = false)
    private String descripcion;
    
    private Integer estatus = 1;

    public Cat_Tipo_Refaccion() {
    }

    public Cat_Tipo_Refaccion(Integer idTipoRefaccion, String descripcion) {
        this.idTipoRefaccion = idTipoRefaccion;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoRefaccion() {
        return idTipoRefaccion;
    }

    public void setIdTipoRefaccion(Integer idTipoRefaccion) {
        this.idTipoRefaccion = idTipoRefaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }
    
    
    
}
