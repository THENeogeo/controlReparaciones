/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.service;

import com.controlReparaciones.controlReparaciones.entity.Cat_Areas;
import com.controlReparaciones.controlReparaciones.entity.Cat_Marcas;
import com.controlReparaciones.controlReparaciones.entity.Cat_Modelos;
import java.util.List;

/**
 *
 * @author gramirez25
 */
public interface CatalogosService {
    
    List<Cat_Areas> findAllAreas();
    
    List<Cat_Marcas> findAllMarcas();
    
    List<Cat_Marcas> listarPorTipoEquipo(Integer idTipoEquipo);
    
    List<Cat_Modelos> listarPorMarca(Integer idMarca);
    
}
