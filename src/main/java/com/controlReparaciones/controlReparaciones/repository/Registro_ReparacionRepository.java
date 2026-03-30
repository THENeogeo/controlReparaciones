/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.repository;

import com.controlReparaciones.controlReparaciones.dto.RegistroReparacionDTO;
import com.controlReparaciones.controlReparaciones.entity.Registro_Reparacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gramirez25
 */

@Repository
public interface Registro_ReparacionRepository extends JpaRepository<Registro_Reparacion, Integer>{
    
    @Query("SELECT new com.controlReparaciones.controlReparaciones.dto.RegistroReparacionDTO(" +
           "r.idReparacion, te.descripcion, ma.descripcion, mo.descripcion, " +
           "r.inventario, ref.descripcion, tr.descripcion, r.refaccionInventario, " +
           "r.descripcionReporte, r.expediente, a.descripcion, r.fechaRegistro) " +
           "FROM Registro_Reparacion r " +
           "JOIN r.tipoEquipo te " +
           "JOIN r.marca ma " +
           "JOIN r.modelo mo " +
           "JOIN r.refaccion ref " +
           "JOIN r.tipoRefaccion tr " +
           "JOIN r.area a")
    List<RegistroReparacionDTO> findAllReparacionesDTO();
    
}
