/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.service;

import com.controlReparaciones.controlReparaciones.entity.Rol;
import com.controlReparaciones.controlReparaciones.util.RolNombre;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author gramirez25
 */
public interface RolService {
    
    public void save(Rol rol);
    
    public Optional<Rol> getByRolNombre(RolNombre name);
    
    public boolean existsByRolNombre(RolNombre name);
    
    /*              LISTAR ROLES*/
    public List<Rol> findAll();
    
}
