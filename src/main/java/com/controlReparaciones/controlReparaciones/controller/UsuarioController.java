/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.controller;

import com.controlReparaciones.controlReparaciones.entity.Usuario;
import com.controlReparaciones.controlReparaciones.service.RolService;
import com.controlReparaciones.controlReparaciones.service.UsuarioRolService;
import com.controlReparaciones.controlReparaciones.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author gramirez25
 */

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    
    @Autowired // Inyección de dependencias
    UsuarioService usuarioService;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    UsuarioRolService usuarioRolService;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
//    @Autowired
//    RestTemplate restTemplate;
    
    // Busca todos los usuarios activos y no activos
    @GetMapping(value = "/api/listarUsuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        try {
            List<Usuario> result = usuarioService.findAll();
            if (result.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    
    
}
