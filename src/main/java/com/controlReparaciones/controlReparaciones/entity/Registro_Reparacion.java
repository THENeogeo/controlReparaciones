/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author gramirez25
 */

@Entity
@Table(name = "registro_reparacion")
public class Registro_Reparacion implements Serializable{
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idReparacion;
    
    @ManyToOne(fetch = FetchType.EAGER) // Solo se trae el objeto principal. La relación se carga hasta que realmente la usas.
    @JoinColumn(name = "tipo_equipo_id")
    private Cat_Tipo_Equipos tipoEquipo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_id", nullable = false)
    private Cat_Marcas marca;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modelo_id", nullable = false)
    private Cat_Modelos modelo;
    
    private String inventario; // 16 caracteres 
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "refaccion_id", nullable = false)
    private Cat_Refacciones refaccion;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_refaccion_id", nullable = false)
    private Cat_Tipo_Refaccion tipoRefaccion;
    
    private String refaccionInventario;
    private String descripcionReporte; 
    private String expediente;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "area_id", nullable = false)
    private Cat_Areas area;
    
    private Date fechaRegistro;

    public Registro_Reparacion() {
    }

    public Registro_Reparacion(Integer idReparacion, Cat_Tipo_Equipos tipoEquipo, Cat_Marcas marca, Cat_Modelos modelo, String inventario, Cat_Refacciones refaccion, Cat_Tipo_Refaccion tipoRefaccion, String refaccionInventario, String descripcionReporte, String expediente, Cat_Areas area, Date fechaRegistro) {
        this.idReparacion = idReparacion;
        this.tipoEquipo = tipoEquipo;
        this.marca = marca;
        this.modelo = modelo;
        this.inventario = inventario;
        this.refaccion = refaccion;
        this.tipoRefaccion = tipoRefaccion;
        this.refaccionInventario = refaccionInventario;
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

    public Cat_Tipo_Equipos getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(Cat_Tipo_Equipos tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public Cat_Marcas getMarca() {
        return marca;
    }

    public void setMarca(Cat_Marcas marca) {
        this.marca = marca;
    }

    public Cat_Modelos getModelo() {
        return modelo;
    }

    public void setModelo(Cat_Modelos modelo) {
        this.modelo = modelo;
    }

    public String getInventario() {
        return inventario;
    }

    public void setInventario(String inventario) {
        this.inventario = inventario;
    }

    public Cat_Refacciones getRefaccion() {
        return refaccion;
    }

    public void setRefaccion(Cat_Refacciones refaccion) {
        this.refaccion = refaccion;
    }

    public Cat_Tipo_Refaccion getTipoRefaccion() {
        return tipoRefaccion;
    }

    public void setTipoRefaccion(Cat_Tipo_Refaccion tipoRefaccion) {
        this.tipoRefaccion = tipoRefaccion;
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

    public Cat_Areas getArea() {
        return area;
    }

    public void setArea(Cat_Areas area) {
        this.area = area;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
    
}
