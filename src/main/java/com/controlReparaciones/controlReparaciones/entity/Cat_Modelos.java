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
@Table(name = "catalogo_modelos")
public class Cat_Modelos implements Serializable{
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idModelo;
    
    @Column(name = "modelo_descripcion", nullable = false) // nullable = false -> No permite datos nulos
    private String descripcion;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_id", nullable = false)
    private Cat_Marcas marca;
    
    private Integer estatus = 1;

    public Cat_Modelos() {
    }

    public Cat_Modelos(Integer idModelo, String descripcion, Cat_Marcas marca) {
        this.idModelo = idModelo;
        this.descripcion = descripcion;
        this.marca = marca;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cat_Marcas getMarca() {
        return marca;
    }

    public void setMarca(Cat_Marcas marca) {
        this.marca = marca;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }
    
    
    
}
