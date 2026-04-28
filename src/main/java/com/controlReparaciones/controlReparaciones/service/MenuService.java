/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.service;

import com.controlReparaciones.controlReparaciones.dto.MenuDTO;
import com.controlReparaciones.controlReparaciones.entity.Menu;
import com.controlReparaciones.controlReparaciones.entity.Submenu_Rol;
import java.util.List;

/**
 *
 * @author gramirez25
 */

public interface MenuService {
    
    public List<Menu> findAllMenu();
    
    public List<Submenu_Rol> findBySubMenuRoles(Integer rol_id);
    
    public Menu findOne(Integer id);
    
    public Menu actualizarMenu(Integer id, MenuDTO gMenu);
    
    public Menu save(Menu menu);
    
    public Menu existsByNombre(String nombre);
    
}
