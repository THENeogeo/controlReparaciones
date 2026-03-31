/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.serviceImpl;

import com.controlReparaciones.controlReparaciones.dto.RegistroReparacionDTO;
import com.controlReparaciones.controlReparaciones.entity.Registro_Reparacion;
import com.controlReparaciones.controlReparaciones.repository.Registro_ReparacionRepository;
import com.controlReparaciones.controlReparaciones.service.RegistroReparacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gramirez25
 */

@Service
public class RegistroReparacionServiceImpl implements RegistroReparacionService{
    
    @Autowired
    private Registro_ReparacionRepository registro_ReparacionRepository;
    
    @Override
    public List<Registro_Reparacion> findAllRegistroReparacion() {
        return registro_ReparacionRepository.findAll();
    }
    
    @Override
    public List<RegistroReparacionDTO> findAllRegistroReparacionDTO() {
        return registro_ReparacionRepository.findAllReparacionesDTO();
    }
    
    @Override
    public RegistroReparacionDTO findOneRegistroReparacion(Integer idRegistroReparacion){
        return registro_ReparacionRepository.findOneRegistroReparacion(idRegistroReparacion);
    }
    
    @Override
    public Registro_Reparacion saveRegistroReparacion(Registro_Reparacion registroReparacion) {
        return registro_ReparacionRepository.save(registroReparacion);
    }
    
    @Override
    public Registro_Reparacion updateRegistroReparacion(Integer idRegistroReparacion, Registro_Reparacion registroReparacion){
        return null;
    }
}
