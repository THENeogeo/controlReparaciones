/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.dto;

import java.time.LocalDate;

/**
 *
 * @author gramirez25
 */
public class RegistroReparacionEditarDTO {
    private Integer idReparacion;
    private Integer idTipoEquipo;
    private Integer idMarca;
    private Integer idModelo;
    private String inventario;
    private Integer idRefaccion;
    private Integer idTipoRefaccion;
    private String refaccionInventario;
    private String descripcionReporte;
    private String expediente;
    private Integer idArea;
    private LocalDate fechaRegistro;

    public RegistroReparacionEditarDTO() {
    }

    public RegistroReparacionEditarDTO(Integer idReparacion, Integer idTipoEquipo, Integer idMarca, Integer idModelo, String inventario, Integer idRefaccion, Integer idTipoRefaccion, String refaccionInventario, String descripcionReporte, String expediente, Integer idArea, LocalDate fechaRegistro) {
        this.idReparacion = idReparacion;
        this.idTipoEquipo = idTipoEquipo;
        this.idMarca = idMarca;
        this.idModelo = idModelo;
        this.inventario = inventario;
        this.idRefaccion = idRefaccion;
        this.idTipoRefaccion = idTipoRefaccion;
        this.refaccionInventario = refaccionInventario;
        this.descripcionReporte = descripcionReporte;
        this.expediente = expediente;
        this.idArea = idArea;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdTipoEquipo() {
        return idTipoEquipo;
    }

    public void setIdTipoEquipo(Integer idTipoEquipo) {
        this.idTipoEquipo = idTipoEquipo;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public String getInventario() {
        return inventario;
    }

    public void setInventario(String inventario) {
        this.inventario = inventario;
    }

    public Integer getIdRefaccion() {
        return idRefaccion;
    }

    public void setIdRefaccion(Integer idRefaccion) {
        this.idRefaccion = idRefaccion;
    }

    public Integer getIdTipoRefaccion() {
        return idTipoRefaccion;
    }

    public void setIdTipoRefaccion(Integer idTipoRefaccion) {
        this.idTipoRefaccion = idTipoRefaccion;
    }

    public String getRefaccionInventario() {
        return refaccionInventario;
    }

    public void setRefaccionInventario(String refaccionInventario) {
        this.refaccionInventario = refaccionInventario;
    }

    public String getDescripcionReporte() {
        return descripcionReporte;
    }

    public void setDescripcionReporte(String descripcionReporte) {
        this.descripcionReporte = descripcionReporte;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(Integer idReparacion) {
        this.idReparacion = idReparacion;
    }
    
    
    
    
    
}
