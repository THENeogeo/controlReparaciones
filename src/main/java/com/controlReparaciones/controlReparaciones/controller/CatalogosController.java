/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.controller;

import com.controlReparaciones.controlReparaciones.entity.Cat_Areas;
import com.controlReparaciones.controlReparaciones.entity.Cat_Marcas;
import com.controlReparaciones.controlReparaciones.entity.Cat_Modelos;
import com.controlReparaciones.controlReparaciones.entity.Cat_Refacciones;
import com.controlReparaciones.controlReparaciones.entity.Cat_Tipo_Equipos;
import com.controlReparaciones.controlReparaciones.service.CatalogosService;
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
@RequestMapping("/catalogos")
public class CatalogosController {
    
    @Autowired
    private CatalogosService catalogosService;
    
    // Obtener todas las areas listadas
    @GetMapping(value = "/areas/listarAreas")
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
    
    // Obtener marcas filtradas por Tipo de Equipo y Estatus
    @GetMapping(value = "/marcas/listarMarcasPorTipoEquipo/{id}")
    public ResponseEntity<List<Cat_Marcas>> obtenerMarcas(@PathVariable("id") Integer id){
        try {
            List<Cat_Marcas> result = catalogosService.listarMarcasPorTipoEquipo(id);
            if(result.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    // Obtener todas las marcas listadas
    @GetMapping(value = "/marcas/listarTodasLasMarcas")
    public ResponseEntity<List<Cat_Marcas>> findAllMarcas() {
        try {
            List<Cat_Marcas> result = catalogosService.findAllMarcas();
            if(result.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Obtener todos los modelos listados
    @GetMapping(value = "/modelos/listarTodosLosModelos")
    public ResponseEntity<List<Cat_Modelos>> findAllModelos() {
        try {
            List<Cat_Modelos> result = catalogosService.findAllModelos();
            if(result.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Obtener todas las refacciones listadas
    @GetMapping(value = "/refacciones/listarTodasLasRefacciones")
    public ResponseEntity <List<Cat_Refacciones>> findAllRefacciones() {
        try {
            List<Cat_Refacciones> result = catalogosService.findAllRefacciones();
            if (result.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Obtener todos los tipo de equipos
    @GetMapping( value = "equipos/listarTodosLosTiposDeEquipo")
    public ResponseEntity <List<Cat_Tipo_Equipos>> findAllTipoEquipos() {
        try {
            List<Cat_Tipo_Equipos> result = catalogosService.findAllTipoEquipos();
            if (result.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Obtener modelos filtradas por Marca y Estatus
    @GetMapping(value = "/modelos/listarModelosPorMarca/{id}")
    public ResponseEntity<List<Cat_Modelos>> obtenerModelos(@PathVariable("id") Integer id) {
        try {
            List<Cat_Modelos> result = catalogosService.listarModelosPorMarca(id);
            if(result.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Obtener refacciones filtradas por Tipo Equipo y Estatus
    @GetMapping(value = "/refacciones/listarRefaccionesPorTipoEquipo/{id}")
    public ResponseEntity<List<Cat_Refacciones>> obtenerRefacciones(@PathVariable("id") Integer id) {
        try {
            List<Cat_Refacciones> result = catalogosService.listarRefaccionesPorTipoEquipo(id);
            if(result.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
