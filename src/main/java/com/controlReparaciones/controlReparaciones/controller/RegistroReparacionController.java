/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.controller;

import com.controlReparaciones.controlReparaciones.dto.RegistroReparacionDTO;
import com.controlReparaciones.controlReparaciones.dto.RegistroReparacionEditarDTO;
import com.controlReparaciones.controlReparaciones.entity.Registro_Reparacion;
import com.controlReparaciones.controlReparaciones.service.RegistroReparacionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gramirez25
 */

@RestController
@RequestMapping("/registro-reparacion")
public class RegistroReparacionController {
    
    @Autowired
    private RegistroReparacionService registroReparacionService;
    
    @GetMapping("/listarRegistrosDeReparacionEntidad")
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
    
    @GetMapping("/listarRegistrosDeReparacionDTO") // Get: para obtener/consultar
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
    
    @GetMapping("/obtenerRegistroReparacionPorId/{idRegistroReparacion}")
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
    
    @PutMapping("/editarRegistroReparacion/{idRegistroReparacion}")
    public ResponseEntity<?> modificarRegistroReparacion(@PathVariable Integer idRegistroReparacion, @RequestBody RegistroReparacionEditarDTO dto) {
        try {
            registroReparacionService.modificarRegistroReparacion(idRegistroReparacion, dto);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/obtenerRegistroReparacionParaEditar/{idRegistroReparacion}")
    public ResponseEntity<RegistroReparacionEditarDTO> obtenerRegistroReparacionEditar( @PathVariable Integer idRegistroReparacion) {
        try {
            RegistroReparacionEditarDTO result = registroReparacionService.findOneRegistroReparacionEditar(idRegistroReparacion);
            if (result == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/listarRegistroReparacionPorFechas")
    public ResponseEntity<List<RegistroReparacionDTO>> findAllReparacionesByDateDTO(@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin) {
        try {
            List<RegistroReparacionDTO> result = registroReparacionService.findAllReparacionesByDateDTO(fechaInicio, fechaFin); 
            if (result == null || result.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("eliminarRegistroReparacion/{idReparacion}")
    public ResponseEntity<?> eliminarRegistroReparacion(@PathVariable Integer idReparacion){
        try {
            registroReparacionService.eliminarRegistroReparacion(idReparacion);
            return ResponseEntity.ok().body("Registro eliminado correctamente.");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
