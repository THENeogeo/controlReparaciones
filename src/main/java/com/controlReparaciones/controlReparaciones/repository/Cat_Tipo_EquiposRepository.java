/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.repository;

import com.controlReparaciones.controlReparaciones.entity.Cat_Tipo_Equipos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
        

/**
 *
 * @author gramirez25
 */

@Repository
public interface Cat_Tipo_EquiposRepository extends JpaRepository<Cat_Tipo_Equipos, Integer>{
    
    // Cambio de estatus 
    @Modifying
    @Transactional
    @Query("""
            UPDATE Cat_Tipo_Equipos c
            SET c.estatus = CASE 
                WHEN c.estatus = 1 THEN 0
                ELSE 1
            END
            WHERE c.idTipoEquipo = :idTipoEquipo""")
    Integer updateEstatusTipoEquipo(@Param("idTipoEquipo") Integer idTipoEquipo );
    
}
