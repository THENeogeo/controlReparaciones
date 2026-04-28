/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.serviceImpl;

import com.controlReparaciones.controlReparaciones.dto.MenuDTO;
import com.controlReparaciones.controlReparaciones.entity.Menu;
import com.controlReparaciones.controlReparaciones.entity.Submenu_Rol;
import com.controlReparaciones.controlReparaciones.repository.MenuRepository;
import com.controlReparaciones.controlReparaciones.repository.SubMenuRolRepository;
import com.controlReparaciones.controlReparaciones.service.MenuService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gramirez25
 */

@Service
public class MenuServiceImpl implements MenuService{
    
    @Autowired
    private MenuRepository menuRepository;
    
    @Autowired
    private SubMenuRolRepository subMenuRolRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    @Transactional(readOnly = true)
    public List<Menu> findAllMenu() {
        return menuRepository.findAll().stream().map(menu -> modelMapper.map(menu, Menu.class)).collect(Collectors.toList());
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Submenu_Rol> findBySubMenuRoles(Integer rol_id) {
        return subMenuRolRepository.findBySubMenuRoles(rol_id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public  Menu findOne(Integer id) {
        return menuRepository.findById(id).get();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Menu actualizarMenu(Integer id, MenuDTO menu) {
        Menu menur = menuRepository.findById(id).get();
        Menu menus = menur;
        menus.setMenuNombre(menu.getMenuNombre());
        menus.setDescripcion(menu.getDescripcion());
        menus.setOrden(menu.getOrden());
        return menuRepository.save(menus);
    }
    
    @Override
    @Transactional
    public Menu save(Menu menu) {
        Menu menus = new Menu();
        menus.setMenuNombre(menu.getMenuNombre());
        menus.setDescripcion(menu.getDescripcion());
        menus.setOrden(menu.getOrden());
        return menuRepository.save(menus);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Menu existsByNombre(String nombre) {
        return menuRepository.existsByNombre(nombre);
    }
    
}
