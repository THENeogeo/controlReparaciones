/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.serviceImpl;

import com.controlReparaciones.controlReparaciones.entity.Cat_Areas;
import com.controlReparaciones.controlReparaciones.repository.Cat_AreasRepository;
import com.controlReparaciones.controlReparaciones.service.CatalogosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gramirez25
 */

@Service
public class CatalogosServiceImpl implements CatalogosService{
    
    @Autowired
    private Cat_AreasRepository areasRepository;
    
    @Override
    public List<Cat_Areas> findAllAreas() {
        return areasRepository.findAll();
    }
    
}
