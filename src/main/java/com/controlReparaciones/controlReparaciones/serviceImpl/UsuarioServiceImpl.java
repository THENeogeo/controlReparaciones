/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.serviceImpl;

import com.controlReparaciones.controlReparaciones.dto.UsuarioDTO;
import com.controlReparaciones.controlReparaciones.dto.UsuarioGuardarDTO;
import com.controlReparaciones.controlReparaciones.dto.UsuarioPasswordDTO;
import com.controlReparaciones.controlReparaciones.entity.Usuario;
import com.controlReparaciones.controlReparaciones.repository.UsuarioRepository;
import com.controlReparaciones.controlReparaciones.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gramirez25
 */

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired 
    private UsuarioRepository usuarioRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    } 
    
    @Override
    @Transactional
    public Usuario save(UsuarioGuardarDTO usuario) {
        
        Usuario user = new Usuario();
        
        user.setNombre(usuario.getNombre());
        user.setAp_paterno(usuario.getAp_paterno());
        user.setAp_materno(usuario.getAp_materno());
        user.setUsername(usuario.getUsername());
        user.setPassword(usuario.getPassword());
        user.setActivo(1);
        user.setTrabajador_id(usuario.getTrabajador_id());
        user.setRoles(usuario.getRoles());
        
        return usuarioRepository.save(user);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario findOne(Integer id) {
        return usuarioRepository.findById(id).get();
    }
    
    @Override
    @Transactional
    public Usuario update(Integer id, UsuarioDTO usuario) {
        
        Usuario user = this.usuarioRepository.findById(id).get();
        Usuario usuarios = user;
        usuarios.setNombre(usuario.getNombre());
        usuarios.setAp_paterno(usuario.getAp_paterno());
        usuarios.setAp_materno(usuario.getAp_materno());
        usuarios.setUsername(usuario.getUsername());
        
        return usuarioRepository.save(usuarios);
    }
    
    @Override
    @Transactional
    public Usuario activo(Integer id, Integer activo) {
        
        Usuario user = usuarioRepository.findById(id).get();
        user.setActivo(activo);
        
        return usuarioRepository.save(user);
    }
    
    @Override
    @Transactional
    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> getByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Integer id) {
        return usuarioRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario existsByUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }

    @Override
    @Transactional
    public Usuario updatePassword(Integer id, String password) {
        Usuario user = this.usuarioRepository.findById(id).get();
        Usuario usuarios = user;
        usuarios.setPassword(password);
        return usuarioRepository.save(usuarios);

    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByUsuarioSession(String username) {
        return usuarioRepository.findByUsuarioSession(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> findPage(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Usuario actualizaPassword(Integer id, UsuarioPasswordDTO usuario) {
        Usuario user = this.usuarioRepository.findById(id).get();
        Usuario usuarios = user;
        usuarios.setPassword(usuario.getPassword());
        return usuarioRepository.save(usuarios);
    }
    
}
