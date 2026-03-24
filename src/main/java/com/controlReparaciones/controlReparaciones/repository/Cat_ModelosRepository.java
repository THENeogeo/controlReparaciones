/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.repository;

import com.controlReparaciones.controlReparaciones.entity.Cat_Modelos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gramirez25
 */

@Repository
public interface Cat_ModelosRepository extends JpaRepository<Cat_Modelos, Integer>{
    // Filtra modelos por  marca estatus
    List<Cat_Modelos> findByMarcaIdMarcaAndEstatus(Integer idMarca, Integer estatus);
    
}
