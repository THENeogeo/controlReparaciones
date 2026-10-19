/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.dto;

/**
 *
 * @author gramirez25
 */
public class PuntajeDTO {
    
    private String username;
    private Integer tiempoSegundos;

    public PuntajeDTO() {
    }

    public PuntajeDTO(String username, Integer tiempoSegundos) {
        this.username = username;
        this.tiempoSegundos = tiempoSegundos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTiempoSegundos() {
        return tiempoSegundos;
    }

    public void setTiempoSegundos(Integer tiempoSegundos) {
        this.tiempoSegundos = tiempoSegundos;
    }

    
    
    
    
}
