/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.dto;

import java.io.Serializable;

/**
 *
 * @author gramirez25
 */

public class SubMenuDTO implements Serializable {
    
    private String submenuNombre;
    private String descripcion;

    public SubMenuDTO() {
    }

    public SubMenuDTO(String submenuNombre, String descripcion) {
        this.submenuNombre = submenuNombre;
        this.descripcion = descripcion;
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
    
    
}
