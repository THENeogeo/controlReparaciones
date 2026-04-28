/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.service;

import com.controlReparaciones.controlReparaciones.entity.Submenu_Rol;
import java.util.Optional;

/**
 *
 * @author gramirez25
 */

public interface SubMenuRolService {
    
    public Submenu_Rol save(Submenu_Rol submenu_Rol);
    
    public Submenu_Rol findOne(Integer submenu_id);
    
    public void deleteById(Integer submenu_id);
    
    public Optional<Submenu_Rol> findBySubmenuId(Integer submenu_id);
    
    public Submenu_Rol findBySubMenuRoles(Integer submenu_id);
    
    public  void delete_Rol(Integer submenu_id, Integer rol_id);
    
    public Submenu_Rol findBySubMenuId(Integer submenu_id);
    
}
