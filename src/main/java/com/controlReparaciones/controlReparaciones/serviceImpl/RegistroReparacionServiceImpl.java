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
    private Registro_ReparacionRepository Registro_ReparacionRepository;
    
    @Override
    public List<Registro_Reparacion> findAllRegistroReparacion() {
        return Registro_ReparacionRepository.findAll();
    }
    
    @Override
    public List<RegistroReparacionDTO> findAllRegistroReparacionDTO() {
        return Registro_ReparacionRepository.findAllReparacionesDTO();
    }
    
}
