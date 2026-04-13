/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.serviceImpl;

import com.controlReparaciones.controlReparaciones.dto.AdminLogDTO;
import com.controlReparaciones.controlReparaciones.repository.AdminLogRepository;
import com.controlReparaciones.controlReparaciones.service.AdminLogService;
import com.controlReparaciones.controlReparaciones.entity.AdminLog;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gramirez25
 */

@Service
public class AdminLogServiceImpl implements AdminLogService{
    
    @Autowired
    AdminLogRepository adminLogRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<AdminLog> findAllB(Date desde, Date hasta) {
        return adminLogRepository.findAllB(desde, hasta);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<AdminLogDTO> searchOperationByDate(String operacion, Date fechaInicio, Date fechaFin) {
        return adminLogRepository.searchOperationByDate(operacion, fechaInicio, fechaFin);
    }
    
}
