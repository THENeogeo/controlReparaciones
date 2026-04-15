/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.controller;

import com.controlReparaciones.controlReparaciones.dto.UsuarioGuardarDTO;
import com.controlReparaciones.controlReparaciones.entity.Rol;
import com.controlReparaciones.controlReparaciones.entity.Usuario;
import com.controlReparaciones.controlReparaciones.service.RolService;
import com.controlReparaciones.controlReparaciones.service.UsuarioRolService;
import com.controlReparaciones.controlReparaciones.service.UsuarioService;
import com.controlReparaciones.controlReparaciones.util.Response;
import com.controlReparaciones.controlReparaciones.util.RolNombre;
import controlReparaciones.controlReparaciones.exception.Exceptions;
import controlReparaciones.controlReparaciones.exception.OutputEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @GetMapping(value = "/listarUsuarios")
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
    
    // Guardar datos básicos del Usuario con rol básico
    // Role User id 1
    @PostMapping(value = "/guardarUsuario")
    public ResponseEntity<OutputEntity<String>> guardarUsuarios(@RequestBody UsuarioGuardarDTO usuario) {
        OutputEntity<String> out = new OutputEntity<>();
        try {
            if (usuarioService.existsByUsername(usuario.getUsername()) != null) {
                throw new Exceptions(Response.USERNAMEEXISTE.getKey(), Response.USERNAMEEXISTE.getCode());
            }
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
            Set<Rol> roles = new HashSet<>();
            roles.add(rolUser);
            usuario.setRoles(roles);
            usuarioService.save(usuario);
            
            out.success(Response.CREATED, "Usuario Guardado");
            return new ResponseEntity<>(out, out.getCode());
            
        } catch (Exceptions e) {
            out.failed(Response.USERNAMEEXISTE, null);
            return new ResponseEntity<>(out, out.getCode());
        } catch (Exception e) {
            out.error();
            return new ResponseEntity<>(out, out.getCode());
        }
    }
    
    
    
}
