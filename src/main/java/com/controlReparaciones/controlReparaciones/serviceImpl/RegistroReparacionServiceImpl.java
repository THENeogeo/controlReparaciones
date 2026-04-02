/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.serviceImpl;

import com.controlReparaciones.controlReparaciones.dto.RegistroReparacionDTO;
import com.controlReparaciones.controlReparaciones.entity.Registro_Reparacion;
import com.controlReparaciones.controlReparaciones.repository.Registro_ReparacionRepository;
import com.controlReparaciones.controlReparaciones.service.RegistroReparacionService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
    @Transactional // Se asegura que que se realice toda la transacción y si algo falla, se cancela todo
    @Override
    public Registro_Reparacion updateRegistroReparacion(Integer idRegistroReparacion, Registro_Reparacion registroReparacion) {
        
        // Buscamos si el registro existe en la BD
        Optional<Registro_Reparacion> registroExistente = registro_ReparacionRepository.findById(idRegistroReparacion); // Objeto tipo Optional. Si el registro existe lo trae, si no esixte, regresa vacío
        
        if (registroExistente.isPresent()) {
            
            // Se estrae el registro original completo
            Registro_Reparacion registroOriginal = registroExistente.get();
            
            // Se mantiene la fecha original y se colocal al registro nuevo
            registroReparacion.setFechaRegistro(registroOriginal.getFechaRegistro());
            registroReparacion.setIdReparacion(idRegistroReparacion);
            
            return registro_ReparacionRepository.save(registroReparacion);
        } else {
            
            // El controlador deberá ver este null y devolver un ResponseEntity con HttpStatus.NOT_FOUND (404).
            return null;
        }
        
    }
    
    @Override
    public List<RegistroReparacionDTO> findAllReparacionesByDateDTO(LocalDate fechaInicio, LocalDate fechaFin){
        return registro_ReparacionRepository.findAllReparacionesByDateDTO(fechaInicio, fechaFin);
    }
    
}
