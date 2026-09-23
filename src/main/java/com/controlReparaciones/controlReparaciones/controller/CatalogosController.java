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
import com.controlReparaciones.controlReparaciones.entity.Cat_Tipo_Refaccion;
import com.controlReparaciones.controlReparaciones.service.CatalogosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping( value = "/equipos/listarTodosLosTiposDeEquipo")
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
    
    // Obtener los tipos de refacción.
    @GetMapping(value = "/refacciones/listarTipoRefaccion")
    public ResponseEntity<List<Cat_Tipo_Refaccion>> listarTiposRefaccion() {
        try {
            List<Cat_Tipo_Refaccion> result = catalogosService.findAllTipoRefaccion();
            if(result.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
       
    }
    
    //Cambia el estatus de los tipos de equipo
    @GetMapping(value = "/equipos/cambiarEstatus/{idTipoEquipo}") 
    public ResponseEntity<Integer> cambiarEstatusTipoEquipo(@PathVariable("idTipoEquipo") Integer idTipoEquipo) {
        try {
            Integer result = catalogosService.updateEstatusTipoEquipo(idTipoEquipo);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
    
    // Cambia el estatus de las marcas
    @GetMapping(value ="/marcas/cambiarEstatus/{idMarca}")
    public ResponseEntity<Integer> cambiarEstatusMarca(@PathVariable("idMarca") Integer idMarca) {
        try {
            Integer result = catalogosService.updateEstatusMarca(idMarca);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    // Cambia el estatus de los modelos
    @GetMapping(value = "/modelos/cambiarEstatus/{idModelo}")
    public ResponseEntity<Integer> cambiarEstatusModelo(@PathVariable("idModelo") Integer idModelo) {
        try {
            Integer result = catalogosService.updateEstatusModelo(idModelo);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Cambia el estatus de las refacciones
    @GetMapping(value = "/refacciones/cambiarEstatus/{idRefaccion}")
    public ResponseEntity<Integer> cambiarEstatusRefaccion(@PathVariable("idRefaccion") Integer idRefaccion) {
        try {
            Integer result = catalogosService.updateEstatusRefaccion(idRefaccion);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Agregar tipo de equipo al catálogo
    @PostMapping(value = "/equipos/agregarEquipo")
    public ResponseEntity<String> agregarEquipo(@RequestBody Cat_Tipo_Equipos tipoEquipo) {
        try {
            catalogosService.agregarTipoEquipo(tipoEquipo.getDescripcion());
            return ResponseEntity.ok("Tipo de equipo agregado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar el tipo de equipo.");
        }
    }
    
    // Agregar marca al catálogo
    @PostMapping(value = "/marcas/agregarMarca")
    public ResponseEntity<String> agregarMarca(@RequestBody Cat_Marcas marca, @RequestParam Integer tipoEquipoId) {
        try {
            catalogosService.agregarMarca(marca.getDescripcion(), tipoEquipoId);
            return ResponseEntity.ok("Marca agregada correctamente");
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar la marca.");
        }
    }
    
    // Agregar modelo al catálogo
    @PostMapping(value = "/modelos/agregarModelo")
    public ResponseEntity<String> agregarModelo(@RequestBody Cat_Modelos modelo, @RequestParam Integer marcaId) {
        try {
            catalogosService.agregarModelo(modelo.getDescripcion(), marcaId);
            return ResponseEntity.ok("Modelo agregado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar el modelo.");
        }
    }
    
    // Agregar refacciones al catálogo
    @PostMapping(value = "refacciones/agregarRefaccion")
    public ResponseEntity <String> agregarRefaccion(@RequestBody Cat_Refacciones refaccion, @RequestParam Integer tipoEquipoId) {
        try {
            catalogosService.agregarRefaccion(refaccion.getDescripcion(), tipoEquipoId);
            return ResponseEntity.ok("Refacción agregada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar la refacción.");
        }
    }
    
    // -- Segmento de edición de las descripciones para cada catálogo --
    
    // Editar tipo de equipo
    @PutMapping("/equipos/editarEquipo")
    public ResponseEntity<String> editarTipoEquipo(@RequestParam Integer tipoEquipoId, @RequestParam String tipoEquipo) {
        try {
            catalogosService.editarTipoEquipo(tipoEquipoId, tipoEquipo);
            return ResponseEntity.ok("Tipo de equipo actualizado correctamente." );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el tipo de equipo.");
        }
    }


    // Editar marca
    @PutMapping("/marcas/editarMarca")
    public ResponseEntity<String> editarMarca(@RequestParam Integer marcaId, @RequestParam String marca) {
        try {
            catalogosService.editarMarca(marcaId, marca);
            return ResponseEntity.ok("Marca actualizada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la marca.");
        }
    }


    // Editar modelo
    @PutMapping("/modelos/editarModelo")
    public ResponseEntity<String> editarModelo(@RequestParam Integer modeloId, @RequestParam String modelo) {
        try {
            catalogosService.editarModelo(modeloId, modelo);
            return ResponseEntity.ok("Modelo actualizado correctamente." );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el modelo.");
        }
    }


    // Editar refacción
    @PutMapping("/refacciones/editarRefaccion")
    public ResponseEntity<String> editarRefaccion(@RequestParam Integer refaccionId, @RequestParam String refaccion) {
        try {
            catalogosService.editarRefaccion(refaccionId, refaccion);
            return ResponseEntity.ok("Refacción actualizada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) .body("Error al actualizar la refacción.");
        }
    }
    
}
