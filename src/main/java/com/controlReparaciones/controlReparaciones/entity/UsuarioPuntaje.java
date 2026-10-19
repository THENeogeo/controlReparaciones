/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author gramirez25
 */

@Entity
@Table(name = "usuarios_puntaje")
public class UsuarioPuntaje implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_puntaje")
    private Integer idPuntaje;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false, unique = true)
    private Usuario usuario;
    
    @Column(name = "tiempo", nullable = false)
    private Integer tiempo;
    
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    public UsuarioPuntaje() {
    }

    public UsuarioPuntaje(Integer idPuntaje, Usuario usuario, Integer tiempo, LocalDateTime fechaRegistro) {
        this.idPuntaje = idPuntaje;
        this.usuario = usuario;
        this.tiempo = tiempo;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdPuntaje() {
        return idPuntaje;
    }

    public void setIdPuntaje(Integer idPuntaje) {
        this.idPuntaje = idPuntaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    
    
    
}
