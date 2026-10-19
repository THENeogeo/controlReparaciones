/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.service;

import com.controlReparaciones.controlReparaciones.entity.UsuarioPuntaje;
import java.util.List;

/**
 *
 * @author gramirez25
 */

public interface UsuarioPuntajeService {
    
    public void registrarTiempoJugador(String username, Integer nuevoTiempoSegundos);
    
    public List<UsuarioPuntaje> obtenerLeaderboard();
    
}
