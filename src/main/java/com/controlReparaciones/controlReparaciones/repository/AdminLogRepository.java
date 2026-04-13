/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.repository;

import com.controlReparaciones.controlReparaciones.dto.AdminLogDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.controlReparaciones.controlReparaciones.entity.AdminLog;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author gramirez25
 */

@Repository
public interface AdminLogRepository extends JpaRepository<AdminLog, Integer>{  // Long
    
    @Query(value = "SELECT * FROM admin_log al WHERE date(al.operate_date) BETWEEN :desde AND :hasta", nativeQuery = true)
    List<AdminLog> findAllB(@Param("desde") Date desde, @Param("hasta") Date hasta);

    //List<AdminLog> findAllB(Date desde, Date hasta);
    //Selecciona una operación en especifico realizada por un usuario en cierto periodo de fechas
    @Query("SELECT new com.controlReparaciones.controlReparaciones.dto.AdminLogDTO( " +
       "LogAdministrador.result_params, " +
       "RolesDescripcion.name, " +
       "LogAdministrador.user_name) " +
       "FROM AdminLog LogAdministrador " +
       "JOIN Usuario_Rol RelacionUsuarioRoles ON LogAdministrador.user_id = RelacionUsuarioRoles.usuario_id " +
       "JOIN Rol RolesDescripcion ON RelacionUsuarioRoles.rol_id = RolesDescripcion.id " +
       "WHERE LogAdministrador.operation = :operacion " +
       "AND LogAdministrador.createdAt >= :fechaInicio " +
       "AND LogAdministrador.createdAt <= :fechaFin")
    List<AdminLogDTO> searchOperationByDate(@Param("operacion") String operacion,
            @Param("fechaInicio") Date fechaInicio,
            @Param("fechaFin") Date fechaFin);
    
}
