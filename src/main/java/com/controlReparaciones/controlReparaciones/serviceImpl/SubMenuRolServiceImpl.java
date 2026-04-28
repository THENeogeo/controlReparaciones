/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.serviceImpl;

import com.controlReparaciones.controlReparaciones.entity.Submenu_Rol;
import com.controlReparaciones.controlReparaciones.repository.SubMenuRolRepository;
import com.controlReparaciones.controlReparaciones.service.SubMenuRolService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gramirez25
 */

@Service
public class SubMenuRolServiceImpl implements SubMenuRolService {
    
    @Autowired
    private SubMenuRolRepository subMenuRolRepository;
    
    @Override
    @Transactional
    public Submenu_Rol save(Submenu_Rol submenu_rol) {
         return subMenuRolRepository.save(submenu_rol);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Submenu_Rol findOne(Integer submenu_id) {
        return subMenuRolRepository.findById(submenu_id).get();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Submenu_Rol> findBySubmenuId(Integer submenu_id) {
        return subMenuRolRepository.findById(submenu_id);
    }
    
    @Override
    @Transactional
    public void deleteById(Integer id_rol) {
        throw new UnsupportedOperationException("Not supported yet"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    @Transactional(readOnly = true)
    public Submenu_Rol findBySubMenuRoles(Integer submenu_id) {
        throw new UnsupportedOperationException("Noy supported yet"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    @Transactional
    public  void delete_Rol(Integer submenu_id, Integer rol_id) {
        subMenuRolRepository.deleteRol(submenu_id, rol_id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Submenu_Rol findBySubMenuId(Integer submenu_id) {
        return subMenuRolRepository.findById(submenu_id).get();
    }

    
}
