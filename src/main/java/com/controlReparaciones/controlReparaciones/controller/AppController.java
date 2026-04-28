/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.controller;

import com.controlReparaciones.controlReparaciones.entity.Usuario;
import com.controlReparaciones.controlReparaciones.entity.Menu;
import com.controlReparaciones.controlReparaciones.entity.Rol;
import com.controlReparaciones.controlReparaciones.entity.Submenu_Rol;
import com.controlReparaciones.controlReparaciones.service.MenuService;
import com.controlReparaciones.controlReparaciones.service.UsuarioService;
import java.util.function.Function;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.security.core.Authentication;

/**
 *
 * @author gramirez25
 */

@RestController
@SessionAttributes({"usuario"})
public class AppController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    MenuService menuService;
    
    @ModelAttribute("usuario")
    public Usuario usuario() {
        return new Usuario();
    }
    
    @GetMapping(value = "/sesion")
    public ResponseEntity backB(Authentication auth, HttpSession session) {
        try {
            String Username = auth.getName();
            Usuario usuario = usuarioService.findByUsuarioSession(Username);
            List datos = new ArrayList<>();
            datos.add(usuario.getId());
            datos.add(usuario.getNombre());
            datos.add(usuario.getAp_paterno());
            return new ResponseEntity(datos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(value = "/menu")
    public ResponseEntity<Menu> listarMenu(Authentication auth, HttpSession session) {
        try {
            String Username = auth.getName();
            Usuario usuario = usuarioService.findByUsuarioSession(Username);
            List<Submenu_Rol> submenu_Rol = new ArrayList<>();
            for (Rol rol : usuario.getRoles()) {
                submenu_Rol.addAll(menuService.findBySubMenuRoles(rol.getId()));
            }
            List<Submenu_Rol> Menu = submenu_Rol.stream().filter(distincByKey(p -> p.getSubmenu_id())).collect(Collectors.toList());
            return new ResponseEntity(Menu, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    public static <T> Predicate<T> distincByKey (Function<? super T, ?> keyExtrator){
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtrator.apply(t), Boolean.TRUE) == null;
        
    }
    
    @GetMapping(value = "/prueba")
    public ResponseEntity<Submenu_Rol> pruebas() {
        try {
            // List<Submenu_Rol> submenu_Rol = menuService.findBySubMenuRoles(2);
            return new ResponseEntity(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(value = "/sesionRoles")
    public ResponseEntity sessionRoles(Authentication auth, HttpSession session) {
        try {
            String Username = auth.getName();
            Usuario usuario = usuarioService.findByUsuarioSession(Username);
            List datos = new ArrayList<>();
            
            datos.add(usuario.getRoles());
            System.out.println("roles " + usuario.getRoles().size());
            return new ResponseEntity(datos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
