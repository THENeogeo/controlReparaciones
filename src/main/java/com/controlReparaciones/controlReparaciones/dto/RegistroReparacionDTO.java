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
public class RegistroReparacionDTO {
    
    private Integer idReparacion;
    private String tipoEquipo;
    private String marca;
    private String modelo;
    private String inventario;
    private String refaccion;
    private String tipoRefaccion;
    private String refacciónInventario;
    private String descripcionReporte;
    private String expediente;
    private String area;
    private LocalDate fechaRegistro;

    public RegistroReparacionDTO() {
    }

    public RegistroReparacionDTO(Integer idReparacion, String tipoEquipo, String marca, String modelo, String inventario, String refaccion, String tipoRefaccion, String refacciónInventario, String descripcionReporte, String expediente, String area, LocalDate fechaRegistro) {
        this.idReparacion = idReparacion;
        this.tipoEquipo = tipoEquipo;
        this.marca = marca;
        this.modelo = modelo;
        this.inventario = inventario;
        this.refaccion = refaccion;
        this.tipoRefaccion = tipoRefaccion;
        this.refacciónInventario = refacciónInventario;
        this.descripcionReporte = descripcionReporte;
        this.expediente = expediente;
        this.area = area;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(Integer idReparacion) {
        this.idReparacion = idReparacion;
    }

    public String getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(String tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getInventario() {
        return inventario;
    }

    public void setInventario(String inventario) {
        this.inventario = inventario;
    }

    public String getRefaccion() {
        return refaccion;
    }

    public void setRefaccion(String refaccion) {
        this.refaccion = refaccion;
    }

    public String getTipoRefaccion() {
        return tipoRefaccion;
    }

    public void setTipoRefaccion(String tipoRefaccion) {
        this.tipoRefaccion = tipoRefaccion;
    }

    public String getRefacciónInventario() {
        return refacciónInventario;
    }

    public void setRefacciónInventario(String refacciónInventario) {
        this.refacciónInventario = refacciónInventario;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
    
}
