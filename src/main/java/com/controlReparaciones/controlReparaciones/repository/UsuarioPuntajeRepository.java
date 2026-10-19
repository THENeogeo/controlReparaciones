/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.repository;

import com.controlReparaciones.controlReparaciones.entity.UsuarioPuntaje;
import org.springframework.data.jpa.repository.JpaRepository;
import  java.util.List;
import java.util.Optional;

/**
 *
 * @author gramirez25
 */

public interface UsuarioPuntajeRepository extends JpaRepository<UsuarioPuntaje, Integer>{
    
    /**
     * Busca el registro de puntaje de un usuario específico.
     * Útil para saber si el usuario ya jugó antes y actualizar su tiempo 
     * en lugar de crear un registro nuevo (Lógica de Upsert).
     * 
     * Nota: Si usaste la relación @OneToOne con la entidad Usuario, 
     * Spring Data entiende automáticamente "Usuario_Id" como el id dentro de esa entidad.
     */
    Optional<UsuarioPuntaje> findByUsuario_Id(Integer usuarioId);

    /**
     * Trae todos los registros de la tabla ordenados por tiempo de menor a mayor.
     * ¡Este es el método mágico para tu Leaderboard! 
     * El que tenga el menor tiempo (en segundos) aparecerá primero.
     */
    List<UsuarioPuntaje> findAllByOrderByTiempoAsc();

    /**
     * OPCIONAL: Si en el futuro tienes miles de usuarios y solo quieres 
     * mostrar el "Top 10" o "Top 20" en el juego para no saturar la red, 
     * puedes usar este método en su lugar:
     */
    List<UsuarioPuntaje> findTop10ByOrderByTiempoAsc();
    
    
}
