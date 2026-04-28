/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.serviceImpl;

import com.controlReparaciones.controlReparaciones.dto.SubMenuDTO;
import com.controlReparaciones.controlReparaciones.repository.SubMenuRepository;
import com.controlReparaciones.controlReparaciones.service.SubMenuService;
import com.controlReparaciones.controlReparaciones.entity.Submenu;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gramirez25
 */

@Service
public class SubMenuServiceImpl implements SubMenuService {
    
    @Autowired
    private SubMenuRepository subMenuRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Submenu> findAllSubMenu(Integer menu_id) {
        return subMenuRepository.findAllSubMenu(menu_id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Submenu> findAll(Integer menu_id) {
        return subMenuRepository.findAll(menu_id);
    }

    @Override
    @Transactional(readOnly = true)
    public Submenu findOne(Integer id) {
        return subMenuRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Submenu activo(Integer id, Integer activo) {
        Submenu submenu = subMenuRepository.findById(id).get();
        submenu.setActivo(activo);
        return subMenuRepository.save(submenu);
    }

    @Override
    @Transactional
    public Submenu actualizarSubmenu(Integer id, SubMenuDTO Submenu) {
        Submenu smenur = subMenuRepository.findById(id).get();
        Submenu smenus = smenur;
        smenus.setSubmenuNombre(Submenu.getSubmenuNombre());
        smenus.setDescripcion(Submenu.getDescripcion());
        return subMenuRepository.save(smenus);
    }

    @Override
    @Transactional
    public Submenu save(Submenu menu) {
        return subMenuRepository.save(menu);
    }

    @Override
    @Transactional(readOnly = true)
    public Submenu existsByNombre(String nombre) {
        return subMenuRepository.existsByNombre(nombre);
    }
    
}
