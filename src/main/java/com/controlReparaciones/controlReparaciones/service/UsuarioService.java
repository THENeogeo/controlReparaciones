/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.service;

import com.controlReparaciones.controlReparaciones.dto.UsuarioDTO;
import com.controlReparaciones.controlReparaciones.dto.UsuarioGuardarDTO;
import com.controlReparaciones.controlReparaciones.dto.UsuarioPasswordDTO;
import com.controlReparaciones.controlReparaciones.entity.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author gramirez25
 */
public interface UsuarioService {
    
    public List<Usuario> findAll();
    
    public Usuario save(UsuarioGuardarDTO usuario);
    
    public Usuario findOne(Integer id);
    
    public Usuario activo(Integer id, Integer activo);
    
    public void delete(Integer id);
    
    public Optional<Usuario> getByUsername(String username);
    
    public boolean existsById(Integer id);
    
    public Usuario existsByUsername(String username);
    
    public Usuario updatePassword(Integer id, String password);
    
    //-----------------Login---------------------------------------
    public Usuario findByUsuarioSession(String username);
    
    //-----------------Paginacion de Usuarios Nayeli----------------  
    public Page<Usuario> findPage(Pageable pageable);

    //-----------------Actualiza datos de Usuarios Nayeli----------------  
    public Usuario update(Integer id, UsuarioDTO usuario);

    public Usuario actualizaPassword(Integer id, UsuarioPasswordDTO usuario);
    
}
