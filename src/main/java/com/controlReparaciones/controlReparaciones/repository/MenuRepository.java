/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.repository;

import com.controlReparaciones.controlReparaciones.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gramirez25
 */

@Repository
public interface MenuRepository extends  JpaRepository<Menu, Integer>{
    
    @Query(value = "SELECT * FROM menu m WHERE m.nombre = :nombre", nativeQuery = true)
    Menu existsByNombre(@Param("nombre") String nombre);
    
}
