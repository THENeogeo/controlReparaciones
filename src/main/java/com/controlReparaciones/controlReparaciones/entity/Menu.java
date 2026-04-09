/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gramirez25
 */

@Entity
@Table (name = "menu")
public class Menu implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty
    @Column(name = "nombre")
    private String menuNombre;
    private String descripcion;
    
    @JsonIgnore
    @OneToMany(mappedBy = "menu")
    private List<Submenu> submenu;
    private String icono;
    private Integer orden;
    
    public List<Submenu> getSubmenu() {
        return submenu;
    }
    
    public void setSubmenu(List<Submenu> submenu) {
        this.submenu = submenu;
    }
    
    public Menu() {
        super();
    }

    public Menu(String menuNombre, String descripcion, List<Submenu> submenu, String icono, Integer orden) {
        this.menuNombre = menuNombre;
        this.descripcion = descripcion;
        this.submenu = submenu;
        this.icono = icono;
        this.orden = orden;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuNombre() {
        return menuNombre;
    }

    public void setMenuNombre(String menuNombre) {
        this.menuNombre = menuNombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    
    
    
}
