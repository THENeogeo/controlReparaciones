/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.service;

import com.controlReparaciones.controlReparaciones.entity.Cat_Areas;
import com.controlReparaciones.controlReparaciones.entity.Cat_Marcas;
import com.controlReparaciones.controlReparaciones.entity.Cat_Modelos;
import com.controlReparaciones.controlReparaciones.entity.Cat_Refacciones;
import com.controlReparaciones.controlReparaciones.entity.Cat_Tipo_Equipos;
import com.controlReparaciones.controlReparaciones.entity.Cat_Tipo_Refaccion;
import java.util.List;

/**
 *
 * @author gramirez25
 */
public interface CatalogosService {
    
    public List<Cat_Areas> findAllAreas();
    
    public List<Cat_Marcas> findAllMarcas();
    
    public List<Cat_Modelos> findAllModelos();
    
    public List<Cat_Refacciones> findAllRefacciones();
    
    public List<Cat_Tipo_Refaccion> findAllTipoRefaccion();
    
    public List<Cat_Tipo_Equipos> findAllTipoEquipos();
    
    // Filtrar por tipo 
    public List<Cat_Marcas> listarMarcasPorTipoEquipo(Integer idTipoEquipo);
    
    public List<Cat_Modelos> listarModelosPorMarca(Integer idMarca);
    
    public List<Cat_Refacciones> listarRefaccionesPorTipoEquipo(Integer idTipoEquipo);
    
    // Cambiar estatus de valores en los catálogos
    public Integer updateEstatusTipoEquipo(Integer idTipoEquipo);
    
    public Integer updateEstatusMarca(Integer idMarca);
    
    public Integer updateEstatusModelo(Integer idModelo);
    
    public Integer updateEstatusRefaccion(Integer idRefaccion);
    
    // Métodos para agregar valores a los catálogos
    public Cat_Tipo_Equipos agregarTipoEquipo(String tipoEquipo);
    
    public Cat_Marcas agregarMarca(String marca, Integer tipoEquipoId);
    
    public Cat_Modelos agregarModelo(String modelo, Integer marcaId);
    
    public Cat_Refacciones agregarRefaccion(String refaccion, Integer tipoEquipoId);
    
    // Editar registros de catálogos
    public Cat_Tipo_Equipos editarTipoEquipo(Integer tipoEquipoId, String tipoEquipo);
    
    public Cat_Marcas editarMarca(Integer marcaId, String marca);
    
    public Cat_Modelos editarModelo(Integer modeloId, String modelo);
    
    public Cat_Refacciones editarRefaccion(Integer refaccionId, String refaccion);
            
    
}
