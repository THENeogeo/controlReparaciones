/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.controller;

import com.controlReparaciones.controlReparaciones.entity.Cat_Areas;
import com.controlReparaciones.controlReparaciones.entity.Cat_Marcas;
import com.controlReparaciones.controlReparaciones.service.CatalogosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gramirez25
 */

@RestController
@RequestMapping("/api/catalogos")
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen (solo para desarrollo) <-
public class CatalogosController {
    
    @Autowired
    private CatalogosService catalogosService;
    
    @GetMapping(value = "/listarAreas")
    public ResponseEntity<Cat_Areas> findAllAreas(){
        try {
            List<Cat_Areas> result = catalogosService.findAllAreas();
            if(result.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Obtener marcas filtradas por Tipo de Equipo
//    @GetMapping(value = "/marcas/tipo-equipo/{id}")
//    public ResponseEntity<Cat_Marcas> listarPorTipoEquipo(){
//        
//    }
}
