/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.serviceImpl;

import com.controlReparaciones.controlReparaciones.entity.Cat_Areas;
import com.controlReparaciones.controlReparaciones.entity.Cat_Marcas;
import com.controlReparaciones.controlReparaciones.entity.Cat_Modelos;
import com.controlReparaciones.controlReparaciones.entity.Cat_Refacciones;
import com.controlReparaciones.controlReparaciones.entity.Cat_Tipo_Refaccion;
import com.controlReparaciones.controlReparaciones.repository.Cat_AreasRepository;
import com.controlReparaciones.controlReparaciones.repository.Cat_MarcasRepository;
import com.controlReparaciones.controlReparaciones.repository.Cat_ModelosRepository;
import com.controlReparaciones.controlReparaciones.repository.Cat_RefaccionesRepository;
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
    public List<Cat_Marcas> listarPorTipoEquipo(Integer idTipoEquipo) {
        return marcasRepository.findByTipoEquipoIdTipoEquipoAndEstatus(idTipoEquipo, 1);
    }
    
    @Override
    public List<Cat_Modelos> listarPorMarca(Integer idMarca) {
        return modelosRepository.findByMarcaIdMarcaAndEstatus(idMarca, 1);
    }
}
