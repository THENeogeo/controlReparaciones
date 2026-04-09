/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.serviceImpl;

import com.controlReparaciones.controlReparaciones.entity.Usuario_Rol;
import com.controlReparaciones.controlReparaciones.repository.UsuarioRolRepository;
import com.controlReparaciones.controlReparaciones.service.UsuarioRolService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gramirez25
 */

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {
    
    @Autowired
    private UsuarioRolRepository usuarioRolRepository;
    
    @Override
    @Transactional
    public Usuario_Rol save(Usuario_Rol usuario_rol) {
        return usuarioRolRepository.save(usuario_rol);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario_Rol findOne(Integer usuario_id) {
        return usuarioRolRepository.findById(usuario_id).get();
    }
    
    @Override
    @Transactional
    public void deletedById(Integer id_rol) {
        usuarioRolRepository.deleteById(id_rol);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario_Rol> findByUsuarioId(Integer usuario_id) {
        return usuarioRolRepository.findById(usuario_id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario_Rol findByUsuario_Id(Integer usuario_id) {
        return usuarioRolRepository.findByUsuario_Id(usuario_id);
    }
    
    @Override
    @Transactional
    public void deleted_Rol(Integer usuario_id, Integer rol_id) {
        usuarioRolRepository.deleteRol(usuario_id, rol_id);
    }
    
}
