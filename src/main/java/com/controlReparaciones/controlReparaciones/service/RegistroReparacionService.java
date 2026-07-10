/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.service;

import com.controlReparaciones.controlReparaciones.dto.RegistroReparacionDTO;
import com.controlReparaciones.controlReparaciones.dto.RegistroReparacionEditarDTO;
import com.controlReparaciones.controlReparaciones.entity.Registro_Reparacion;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author gramirez25
 */
public interface RegistroReparacionService {
    
    public List<Registro_Reparacion> findAllRegistroReparacion();
    
    public List<RegistroReparacionDTO> findAllRegistroReparacionDTO();
    
    public RegistroReparacionDTO findOneRegistroReparacion(Integer idRegistroReparacion);
    
    public Registro_Reparacion saveRegistroReparacion(Registro_Reparacion registroReparacion);
    
    public Registro_Reparacion updateRegistroReparacion(Integer idRegistroReparacion, Registro_Reparacion registroReparacion);
    
    public void modificarRegistroReparacion(Integer idRegistroReparacion, RegistroReparacionEditarDTO dto);
    
    public RegistroReparacionEditarDTO findOneRegistroReparacionEditar(Integer idRegistroReparacion);
    
    public List<RegistroReparacionDTO> findAllReparacionesByDateDTO(LocalDate fechaInicio, LocalDate fechaFin);
    
    public void eliminarRegistroReparacion(Integer idReparacion);
}
