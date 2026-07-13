/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.repository;

import com.controlReparaciones.controlReparaciones.dto.RegistroReparacionDTO;
import com.controlReparaciones.controlReparaciones.dto.RegistroReparacionEditarDTO;
import com.controlReparaciones.controlReparaciones.entity.Registro_Reparacion;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gramirez25
 */

@Repository
public interface Registro_ReparacionRepository extends JpaRepository<Registro_Reparacion, Integer>{
    
    // Encuentra todos los registros de reparación existentes en la base
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
    
    // Encuentra un registro de reparación por su id
    @Query("SELECT new com.controlReparaciones.controlReparaciones.dto.RegistroReparacionDTO(" +
           "r.idReparacion, te.descripcion, ma.descripcion, mo.descripcion, " +
           "r.inventario, ref.descripcion, tr.descripcion, r.refaccionInventario, " +
           "r.descripcionReporte, r.expediente, a.descripcion, r.fechaRegistro) " +
           "FROM Registro_Reparacion r " +
           "LEFT JOIN r.tipoEquipo te " +
           "LEFT JOIN r.marca ma " +
           "LEFT JOIN r.modelo mo " +
           "LEFT JOIN r.refaccion ref " +
           "LEFT JOIN r.tipoRefaccion tr " +
           "LEFT JOIN r.area a " +
           "WHERE r.idReparacion = :idRegistroReparacion")
    RegistroReparacionDTO findOneRegistroReparacion(@Param("idRegistroReparacion") Integer idRegistroReparacion);
    
    // Encuentra todos los registros dentro de un rango de fechas
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
           "JOIN r.area a " +
           "WHERE fechaRegistro BETWEEN :fechaInicio AND :fechaFin")
    List<RegistroReparacionDTO> findAllReparacionesByDateDTO(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFinal);
    
    @Query("SELECT new com.controlReparaciones.controlReparaciones.dto.RegistroReparacionEditarDTO(" +
           "r.idReparacion, " +
           "te.idTipoEquipo, " +
           "ma.idMarca, " +
           "mo.idModelo, " +
           "r.inventario, " +
           "ref.idRefaccion, " +
           "tr.idTipoRefaccion, " +
           "r.refaccionInventario, " +
           "r.descripcionReporte, " +
           "r.expediente, " +
           "a.idArea, " +
           "r.fechaRegistro) " +
           "FROM Registro_Reparacion r " +
           "JOIN r.tipoEquipo te " +
           "JOIN r.marca ma " +
           "JOIN r.modelo mo " +
           "JOIN r.refaccion ref " +
           "JOIN r.tipoRefaccion tr " +
           "JOIN r.area a " +
           "WHERE r.idReparacion = :idRegistroReparacion")
    RegistroReparacionEditarDTO findOneRegistroReparacionEditar(@Param("idRegistroReparacion") Integer idRegistroReparacion);    
    
}
