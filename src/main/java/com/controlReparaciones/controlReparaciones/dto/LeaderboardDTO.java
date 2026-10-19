/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.dto;

/**
 *
 * @author gramirez25
 */
public class LeaderboardDTO {
    
    private String username;
    private Integer tiempoSegundos;
    private String fecha;

    public LeaderboardDTO() {
    }

    public LeaderboardDTO(String username, Integer tiempoSegundos, String fecha) {
        this.username = username;
        this.tiempoSegundos = tiempoSegundos;
        this.fecha = fecha;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
