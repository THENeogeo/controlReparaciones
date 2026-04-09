/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.serviceImpl;

import com.controlReparaciones.controlReparaciones.entity.Rol;
import com.controlReparaciones.controlReparaciones.repository.RolRepository;
import com.controlReparaciones.controlReparaciones.service.RolService;
import com.controlReparaciones.controlReparaciones.util.RolNombre;
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
public class RolServiceImpl implements RolService{
    
    @Autowired
    RolRepository rolRepository;
    
    @Override
    @Transactional
    public void save(Rol rol) {
        rolRepository.save(rol);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Rol> getByRolNombre(RolNombre name) {
        return rolRepository.findByName(name);
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean existsByRolNombre(RolNombre name) {
        return rolRepository.existsByName(name);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }
    
}
