/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.serviceImpl;

import com.controlReparaciones.controlReparaciones.entity.Cat_Areas;
import com.controlReparaciones.controlReparaciones.entity.Cat_Marcas;
import com.controlReparaciones.controlReparaciones.entity.Cat_Modelos;
import com.controlReparaciones.controlReparaciones.entity.Cat_Refacciones;
import com.controlReparaciones.controlReparaciones.entity.Cat_Tipo_Equipos;
import com.controlReparaciones.controlReparaciones.entity.Cat_Tipo_Refaccion;
import com.controlReparaciones.controlReparaciones.repository.Cat_AreasRepository;
import com.controlReparaciones.controlReparaciones.repository.Cat_MarcasRepository;
import com.controlReparaciones.controlReparaciones.repository.Cat_ModelosRepository;
import com.controlReparaciones.controlReparaciones.repository.Cat_RefaccionesRepository;
import com.controlReparaciones.controlReparaciones.repository.Cat_Tipo_EquiposRepository;
import com.controlReparaciones.controlReparaciones.repository.Cat_Tipo_RefaccionRepository;
import com.controlReparaciones.controlReparaciones.service.CatalogosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gramirez25
 */

@Service
public class CatalogosServiceImpl implements CatalogosService{
    
    @Autowired
    private Cat_AreasRepository areasRepository;
    
    @Autowired
    private Cat_MarcasRepository marcasRepository;
    
    @Autowired
    private Cat_ModelosRepository modelosRepository;
    
    @Autowired
    private Cat_RefaccionesRepository refaccionesRepository;
    
    @Autowired
    private Cat_Tipo_RefaccionRepository tipoRefaccionRepository;
    
    @Autowired 
    private Cat_Tipo_EquiposRepository tipoEquiposRepository;
    
    @Override
    public List<Cat_Areas> findAllAreas() {
        return areasRepository.findAll();
    }
    
    @Override
    public List<Cat_Marcas> findAllMarcas() {
        return marcasRepository.findAll();
    }
    
    @Override
    public List<Cat_Modelos> findAllModelos() {
        return modelosRepository.findAll();
    }
    
    @Override
    public List<Cat_Refacciones> findAllRefacciones() {
        return refaccionesRepository.findAll();
    }
    
    @Override
    public List<Cat_Tipo_Refaccion> findAllTipoRefaccion() {
        return tipoRefaccionRepository.findAll();
    }
    
    @Override
    public List<Cat_Tipo_Equipos> findAllTipoEquipos() {
        return tipoEquiposRepository.findAll();
    }
    
    @Override
    public List<Cat_Marcas> listarMarcasPorTipoEquipo(Integer idTipoEquipo) {
        return marcasRepository.findByTipoEquipoIdTipoEquipoAndEstatus(idTipoEquipo, 1);
    }
    
    @Override
    public List<Cat_Modelos> listarModelosPorMarca(Integer idMarca) {
        return modelosRepository.findByMarcaIdMarcaAndEstatus(idMarca, 1);
    }
    
    @Override
    public List<Cat_Refacciones> listarRefaccionesPorTipoEquipo(Integer idTipoEquipo) {
        return refaccionesRepository.findByTipoEquipoIdTipoEquipoAndEstatus(idTipoEquipo, 1);
    }
    
    // Cambiar estatus en catálogos
    @Override
    public Integer updateEstatusTipoEquipo(Integer idTipoEquipo) {
        return tipoEquiposRepository.updateEstatusTipoEquipo(idTipoEquipo);
    }
    
    @Override
    public Integer updateEstatusMarca(Integer idMarca){
        return marcasRepository.updateEstatusMarca(idMarca);
    }
    
    @Override
    public Integer updateEstatusModelo(Integer idModelo) {
        return modelosRepository.updateEstatusModelo(idModelo);
    }
    
    @Override
    public Integer updateEstatusRefaccion(Integer idRefaccion) {
        return refaccionesRepository.updateEstatusRefaccion(idRefaccion);
    }
    
    // Agregar a catálogos
    @Override
    public Cat_Tipo_Equipos agregarTipoEquipo(String descripcionTipoEquipo) {
        Cat_Tipo_Equipos equipo = new Cat_Tipo_Equipos();
        equipo.setDescripcion(descripcionTipoEquipo);
        equipo.setEstatus(1);
        
        return tipoEquiposRepository.save(equipo);
    }
    
    @Override
    public Cat_Marcas agregarMarca(String descripcionMarca, Integer tipoEquipoId) {
        Cat_Tipo_Equipos tipoEquipo = tipoEquiposRepository.getReferenceById(tipoEquipoId);
        Cat_Marcas marca = new Cat_Marcas();

        marca.setDescripcion(descripcionMarca);
        marca.setTipoEquipo(tipoEquipo);
        marca.setEstatus(1);

        return marcasRepository.save(marca);
    }
    
    @Override
    public Cat_Modelos agregarModelo(String descripcionModelo, Integer marcaId) {
        Cat_Marcas marca = marcasRepository.getReferenceById(marcaId);
        Cat_Modelos modelo = new Cat_Modelos();
        
        modelo.setDescripcion(descripcionModelo);
        modelo.setMarca(marca);
        modelo.setEstatus(1);
        
        return modelosRepository.save(modelo);
    }
    
    @Override
    public Cat_Refacciones agregarRefaccion(String descripcionRefaccion, Integer tipoEquipoId) {
        Cat_Tipo_Equipos tipoEquipo = tipoEquiposRepository.getReferenceById(tipoEquipoId);
        Cat_Refacciones refaccion = new Cat_Refacciones();
        
        refaccion.setDescripcion(descripcionRefaccion);
        refaccion.setTipoEquipo(tipoEquipo);
        refaccion.setEstatus(1);
        
        return refaccionesRepository.save(refaccion);
    }
    
    // Edición de los registros de catálogos
    @Override
    public Cat_Tipo_Equipos editarTipoEquipo(Integer tipoEquipoId, String tipoEquipo) {
        Cat_Tipo_Equipos equipo = tipoEquiposRepository.findById(tipoEquipoId)
                .orElseThrow(() -> new RuntimeException(
                        "No existe el tipo de equipo con ID: " + tipoEquipoId
                ));
        
        equipo.setDescripcion(tipoEquipo);

        return tipoEquiposRepository.save(equipo);
    }
    
    @Override
    public Cat_Marcas editarMarca(Integer marcaId, String marca) {
        Cat_Marcas catMarca = marcasRepository.findById(marcaId)
                .orElseThrow(() -> new RuntimeException(
                        "No existe la marca con ID: " + marcaId
                ));

        catMarca.setDescripcion(marca);

        return marcasRepository.save(catMarca);
    }
    
    @Override
    public Cat_Modelos editarModelo(Integer modeloId, String modelo) {
        Cat_Modelos catModelo = modelosRepository .findById(modeloId)
                .orElseThrow(() -> new RuntimeException(
                        "No existe el modelo con ID: " + modeloId
                ));

        catModelo.setDescripcion(modelo);

        return modelosRepository.save(catModelo);
    }
    
    @Override
    public Cat_Refacciones editarRefaccion( Integer refaccionId, String refaccion) {
        Cat_Refacciones catRefaccion = refaccionesRepository.findById(refaccionId)
                .orElseThrow(() -> new RuntimeException(
                        "No existe la refacción con ID: " + refaccionId
                ));

        catRefaccion.setDescripcion(refaccion);

        return refaccionesRepository.save(catRefaccion);
    }
    
}
