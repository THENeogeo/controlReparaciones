/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.controller;

import com.controlReparaciones.controlReparaciones.dto.AdminLogDTO;
import com.controlReparaciones.controlReparaciones.service.AdminLogService;
import com.controlReparaciones.controlReparaciones.entity.AdminLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gramirez25
 */

@RestController
@RequestMapping("adminLog")
public class AdminLogController {
    
    @Autowired 
    AdminLogService adminLogService;
    
    // Buscar los log usuarios
    @GetMapping(value = "/listarMovimientos/{desde}/{hasta}")
    public ResponseEntity<List<AdminLog>> listarMovimientos(@PathVariable String desde, @PathVariable String hasta) throws ParseException {
        
        Date fechaInicio = new SimpleDateFormat("yyyy-MM-dd").parse(desde);
        Date fechaFin = new SimpleDateFormat("yyyy-MM-dd").parse(hasta);
        
        try {
            List<AdminLog> result = adminLogService.findAllB(fechaInicio, fechaFin);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    @GetMapping(value = "/buscarOperacionPorFecha/{operacion}/{desde}/{hasta}")
    public ResponseEntity<List<AdminLogDTO>> searchOperationByDate(@PathVariable String operacion, @PathVariable String desde, @PathVariable String hasta) throws ParseException {
        
        Date fechaInicio = new SimpleDateFormat("yyyy-MM-dd").parse(desde);
        Date fechaFin = new SimpleDateFormat("yyyy-MM-dd").parse(hasta);
        
        try {
            List<AdminLogDTO> result = adminLogService.searchOperationByDate(operacion, fechaInicio, fechaFin);
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
