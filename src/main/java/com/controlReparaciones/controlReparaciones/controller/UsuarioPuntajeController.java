/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.controller;

import com.controlReparaciones.controlReparaciones.dto.LeaderboardDTO;
import com.controlReparaciones.controlReparaciones.dto.PuntajeDTO;
import com.controlReparaciones.controlReparaciones.service.UsuarioPuntajeService;
import com.controlReparaciones.controlReparaciones.entity.UsuarioPuntaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author gramirez25
 */

@RestController
@RequestMapping("/usuario-puntaje")
public class UsuarioPuntajeController {
    
    @Autowired
    private UsuarioPuntajeService puntajeService;
    
    // Guardar el tiempo del jugador al terminar la partida.
    @PostMapping("/registrarPuntajeUsuario") 
    public ResponseEntity<Map<String, String>> registrarPuntaje(@RequestBody PuntajeDTO puntaje) {
        try {
            puntajeService.registrarTiempoJugador(puntaje.getUsername(), puntaje.getTiempoSegundos());
            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "Puntaje procesado correctamente.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Ocurrió un error al guardar el puntaje: " + e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
    
    // Obtener la tabla de posiciones para mostrarla en el juego.
    @GetMapping("/mostrarLeaderboard")
    public ResponseEntity<?> obtenerLeaderboard() {
        try {
            List<UsuarioPuntaje> puntajes = puntajeService.obtenerLeaderboard();
            // Transformamos la entidad de base de datos a un DTO seguro para Angular
            List<LeaderboardDTO> leaderboardSeguro = puntajes.stream().map(p -> {
                LeaderboardDTO dto = new LeaderboardDTO();
                
                // 1. VALIDACIÓN ANTI-NULL PARA EL USUARIO
                if (p.getUsuario() != null && p.getUsuario().getUsername() != null) {
                    dto.setUsername(p.getUsuario().getUsername()); 
                } else {
                    dto.setUsername("Usuario Desconocido");
                }
                dto.setTiempoSegundos(p.getTiempo());
                // 2. VALIDACIÓN ANTI-NULL PARA LA FECHA
                dto.setFecha(p.getFechaRegistro() != null ? p.getFechaRegistro().toString() : "Fecha no disponible");
                return dto;
            }).collect(Collectors.toList());
            return ResponseEntity.ok(leaderboardSeguro);
        } catch (Exception e) {
            // ¡ESTO ES CLAVE! Imprime el error real en la consola de Spring Boot
            e.printStackTrace(); 
            // Devolvemos el mensaje exacto al frontend/Swagger para saber qué falló
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error interno al cargar la tabla: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
    
}
