/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.repository;

import com.controlReparaciones.controlReparaciones.entity.Cat_Tipo_Refaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gramirez25
 */

@Repository
public interface Cat_Tipo_RefaccionRepository extends JpaRepository<Cat_Tipo_Refaccion, Integer>{
    
}
