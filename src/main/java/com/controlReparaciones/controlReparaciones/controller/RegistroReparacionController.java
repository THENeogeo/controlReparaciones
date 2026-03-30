/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.controller;

import com.controlReparaciones.controlReparaciones.dto.RegistroReparacionDTO;
import com.controlReparaciones.controlReparaciones.entity.Registro_Reparacion;
import com.controlReparaciones.controlReparaciones.service.RegistroReparacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gramirez25
 */

@RestController
@RequestMapping("/api/registro-reparacion")
public class RegistroReparacionController {
    
    @Autowired
    private RegistroReparacionService registroReparacionService;
    
    @GetMapping("/listarRegistrosDeReparacion")
    public ResponseEntity<List<Registro_Reparacion>> findAllRegistroReparacion() {
        try {
            List<Registro_Reparacion> result = registroReparacionService.findAllRegistroReparacion();
            if (result.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    @GetMapping("/listarRegistrosDeReparacionConDescripcion")
    public ResponseEntity<List<RegistroReparacionDTO>> findAllRegistroReparacionDTO() {
        try {
            List<RegistroReparacionDTO> result = registroReparacionService.findAllRegistroReparacionDTO();
            if (result.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
