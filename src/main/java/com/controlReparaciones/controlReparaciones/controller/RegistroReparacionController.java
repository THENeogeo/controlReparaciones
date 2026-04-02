/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.controller;

import com.controlReparaciones.controlReparaciones.dto.RegistroReparacionDTO;
import com.controlReparaciones.controlReparaciones.entity.Registro_Reparacion;
import com.controlReparaciones.controlReparaciones.service.RegistroReparacionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
//    @GetMapping("/listarRegistrosDeReparacion")
//    public ResponseEntity<List<Registro_Reparacion>> findAllRegistroReparacion() {
//        try {
//            List<Registro_Reparacion> result = registroReparacionService.findAllRegistroReparacion();
//            if (result.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        
//    }
    
    @GetMapping("/listarRegistrosDeReparacionConDescripcion") // Get: para obtener/consultar
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
    
    @GetMapping("/buscarRegistroReparacion/{idRegistroReparacion}")
    public ResponseEntity<RegistroReparacionDTO> findOneRegistroReparacion(@PathVariable Integer idRegistroReparacion) {
        try {
            RegistroReparacionDTO result = registroReparacionService.findOneRegistroReparacion(idRegistroReparacion);
            if (result == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/guardarRegistroReparacion") // Post: para envíar/guardar
    public ResponseEntity<Registro_Reparacion> saveRegistroReparacion(@RequestBody Registro_Reparacion registroReparacion) {
        try {
            Registro_Reparacion nuevoRegistro = registroReparacionService.saveRegistroReparacion(registroReparacion);
            return new ResponseEntity<>(nuevoRegistro, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/editarRegistroReparacion/{idRegistroReparacion}")
    @Transactional
    public ResponseEntity<Registro_Reparacion> updateRegistroReparacion(@PathVariable Integer idRegistroReparacion, @RequestBody Registro_Reparacion registroReparacion) {
        try {
            Registro_Reparacion registroActualizado = registroReparacionService.updateRegistroReparacion(idRegistroReparacion, registroReparacion);
            if (registroActualizado == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(registroActualizado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/listarRegistroReparacionPorFechas/{fechaInicio}/{fechaFin}")
    @Transactional
    public ResponseEntity<List<RegistroReparacionDTO>> findAllReparacionesByDateDTO(@PathVariable LocalDate fechaInicioDate, @PathVariable LocalDate fechaFin) {
        try {
            List<RegistroReparacionDTO> result = registroReparacionService.findAllReparacionesByDateDTO(fechaInicioDate, fechaFin); 
            if (result == null || result.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
