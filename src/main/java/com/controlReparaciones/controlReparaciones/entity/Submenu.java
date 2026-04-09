/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author gramirez25
 */

@Entity
@Table(name = "submenu")
public class Submenu implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty
    @Column(name = "nombre")
    private String submenuNombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    private Integer activo;
    private Integer orden;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(
            name = "submenu_roles",
            joinColumns = @JoinColumn(name = "submenu_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    
    private Set<Rol> roles = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
    
    public Submenu() {
        
    }

    public Submenu(Integer id, String submenuNombre, String descripcion, Integer activo, Integer orden, Menu menu) {
        this.id = id;
        this.submenuNombre = submenuNombre;
        this.descripcion = descripcion;
        this.activo = activo;
        this.orden = orden;
        this.menu = menu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubmenuNombre() {
        return submenuNombre;
    }

    public void setSubmenuNombre(String submenuNombre) {
        this.submenuNombre = submenuNombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    

    
}
