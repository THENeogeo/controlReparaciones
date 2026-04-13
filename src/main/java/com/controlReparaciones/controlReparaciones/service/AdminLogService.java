/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.service;

import com.controlReparaciones.controlReparaciones.dto.AdminLogDTO;
import java.util.List;
import com.controlReparaciones.controlReparaciones.entity.AdminLog;
import java.util.Date;

/**
 *
 * @author gramirez25
 */
public interface AdminLogService {
    
    /*LISTAR Movimientos del Usuario*/
    public List<AdminLog> findAllB(Date desde, Date hasta);

    public List<AdminLogDTO> searchOperationByDate(String operacion, Date fechaInicio, Date fechaFin);
    
}
