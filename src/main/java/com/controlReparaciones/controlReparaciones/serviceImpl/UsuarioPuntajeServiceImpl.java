/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.serviceImpl;

import com.controlReparaciones.controlReparaciones.entity.UsuarioPuntaje;
import com.controlReparaciones.controlReparaciones.entity.Usuario;
import com.controlReparaciones.controlReparaciones.repository.UsuarioPuntajeRepository;
import com.controlReparaciones.controlReparaciones.repository.UsuarioRepository;
import com.controlReparaciones.controlReparaciones.service.UsuarioPuntajeService;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gramirez25
 */

@Service
public class UsuarioPuntajeServiceImpl implements UsuarioPuntajeService {
    
    @Autowired
    private UsuarioPuntajeRepository puntajeRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    /**
     * Guarda o actualiza el tiempo del usuario.
     * Solo se actualiza si el nuevo tiempo es mejor (menor cantidad de segundos).
     */
    @Transactional
    public void registrarTiempoJugador(String username, Integer nuevoTiempoSegundos) {
        
        // Buscamos la entidad Usuario completa a partir del texto de username
        Usuario usuario = usuarioRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Error: Usuario no encontrado en la base de datos."));
        
        // Buscamos si el usuario ya tiene un récord previo
        Optional<UsuarioPuntaje> puntajeExistente = puntajeRepository.findByUsuario_Id(usuario.getId());

        if (puntajeExistente.isPresent()) {
            UsuarioPuntaje puntaje = puntajeExistente.get();
            
            // Lógica de competencia: Solo sobrescribimos si el nuevo tiempo es MÁS RÁPIDO (menor)
            if (nuevoTiempoSegundos < puntaje.getTiempo()) {
                puntaje.setTiempo(nuevoTiempoSegundos);
                puntaje.setFechaRegistro(LocalDateTime.now()); // <-- FECHA MANUAL
                puntajeRepository.save(puntaje);
            } // Si el tiempo es mayor o igual, no hacemos nada. ¡Se queda con su mejor récord!
        } else {
            UsuarioPuntaje nuevoRecord = new UsuarioPuntaje();
            nuevoRecord.setUsuario(usuario);
            nuevoRecord.setTiempo(nuevoTiempoSegundos);
            nuevoRecord.setFechaRegistro(LocalDateTime.now()); // <-- FECHA MANUAL
            
            puntajeRepository.save(nuevoRecord);
        }
    }
    
    /**
     * Obtiene la tabla de posiciones ordenada de menor a mayor tiempo.
     */
    @Transactional(readOnly = true)
    public List<UsuarioPuntaje> obtenerLeaderboard() {
        // Retornamos todos los puntajes, el que tenga menos segundos saldrá en la posición [0]
        return puntajeRepository.findAllByOrderByTiempoAsc();
    }
    
}
