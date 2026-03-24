/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.repository;

import com.controlReparaciones.controlReparaciones.entity.Cat_Refacciones;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gramirez25
 */

@Repository
public interface Cat_RefaccionesRepository extends JpaRepository<Cat_Refacciones, Integer>{   
    // Filtra marcas por el id de tipo de equipo y el estatus
    List<Cat_Refacciones> findByTipoEquipoIdTipoEquipoAndEstatus(Integer idTipoEquipo, Integer estatus);
    
}
