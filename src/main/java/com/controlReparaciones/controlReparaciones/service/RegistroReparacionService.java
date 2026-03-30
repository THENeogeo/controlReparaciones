/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.service;

import com.controlReparaciones.controlReparaciones.dto.RegistroReparacionDTO;
import com.controlReparaciones.controlReparaciones.entity.Registro_Reparacion;
import java.util.List;

/**
 *
 * @author gramirez25
 */
public interface RegistroReparacionService {
    
    public List<Registro_Reparacion> findAllRegistroReparacion();
    
    public List<RegistroReparacionDTO> findAllRegistroReparacionDTO();
    
    
    
    
}
