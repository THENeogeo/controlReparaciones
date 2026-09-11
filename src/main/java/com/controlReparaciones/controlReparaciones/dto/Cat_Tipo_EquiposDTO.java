/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.dto;

/**
 *
 * @author gramirez25
 */
public class Cat_Tipo_EquiposDTO {
    
    private Integer idTipoEquipo;
    private String tipoEquipoDescripcion;
    private Integer estatus;

    public Cat_Tipo_EquiposDTO() {
    }

    public Cat_Tipo_EquiposDTO(Integer idTipoEquipo, String tipoEquipoDescripcion, Integer estatus) {
        this.idTipoEquipo = idTipoEquipo;
        this.tipoEquipoDescripcion = tipoEquipoDescripcion;
        this.estatus = estatus;
    }

    public Integer getIdTipoEquipo() {
        return idTipoEquipo;
    }

    public void setIdTipoEquipo(Integer idTipoEquipo) {
        this.idTipoEquipo = idTipoEquipo;
    }

    public String getTipoEquipoDescripcion() {
        return tipoEquipoDescripcion;
    }

    public void setTipoEquipoDescripcion(String tipoEquipoDescripcion) {
        this.tipoEquipoDescripcion = tipoEquipoDescripcion;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }
    
    
    
}
