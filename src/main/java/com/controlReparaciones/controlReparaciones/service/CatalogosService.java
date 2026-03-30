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
    
}
