/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.controller;

import com.controlReparaciones.controlReparaciones.dto.PersonaDTO;
import com.controlReparaciones.controlReparaciones.dto.UsuarioDTO;
import com.controlReparaciones.controlReparaciones.dto.UsuarioGuardarDTO;
import com.controlReparaciones.controlReparaciones.dto.UsuarioPasswordDTO;
import com.controlReparaciones.controlReparaciones.entity.Rol;
import com.controlReparaciones.controlReparaciones.entity.Usuario;
import com.controlReparaciones.controlReparaciones.entity.Usuario_Rol;
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
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.core.Authentication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @Autowired
    RestTemplate restTemplate;
    
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
            e.printStackTrace();
            out.error();
            return new ResponseEntity<>(out, out.getCode());
        }
    }
    
    // Buscar usuario por ID
    @GetMapping(value = "/buscarUsuario/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Integer id) {
        try {
            Usuario result = usuarioService.findOne(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Actualizar datos de usuario
    @PostMapping(value = "/actualizarUsuario/{id}")
    public ResponseEntity<OutputEntity<String>> actualizarUsuario(@RequestBody UsuarioDTO usuario, @PathVariable Integer id) {
        OutputEntity<String> out = new OutputEntity<>();
        try {
            usuarioService.update(id, usuario);
            out.success(Response.UPDATE, "Usuario Actualizado");
            return new ResponseEntity<>(out, out.getCode());
        } catch (Exception e) {
            e.printStackTrace();
            out.error();
            return new ResponseEntity<>(out, out.getCode());
        }
    }
    
    // Activar o desactivar usuario
    // 1 Activo - 0 Inactivo
    @PostMapping(value = "/eliminarUsuario/{id}/{activo}")
    public  ResponseEntity<Usuario> eliminarUsuario( /* @RequestBody */  @PathVariable Integer id, @PathVariable Integer activo) {
        try {
            return new ResponseEntity<>(usuarioService.activo(id, activo), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Asignar roles a usuario Buscar ID de Usuario y ID del Catálogo de Roles.
    @PostMapping(value = "asignarRoles")
    public ResponseEntity<Usuario_Rol> asignarRolesUsuario(@RequestBody Usuario_Rol usuario_rol) {
        try {
            return new ResponseEntity<>(usuarioRolService.save(usuario_rol), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Paginación 
    @GetMapping(value = "/paginacion")
    public ResponseEntity<Page<Usuario>> paginacionUsuarios(Pageable pageable) {
        try {
            Page<Usuario> page = usuarioService.findPage(pageable);
            return new ResponseEntity<>(page, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Estado del usuario | activo o inactivo
    @PostMapping(value = "/estadoUsuario/{id}/{estatus}")
    public ResponseEntity<Usuario> cambioEstatusGenero( /* @RequestBody */ @PathVariable Integer id, @PathVariable Integer estatus) {
        try {
            return new ResponseEntity<>(usuarioService.activo(id, estatus), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Modificar Password
    @PostMapping(value = "/actualizarPassword/{id}")
    public ResponseEntity<OutputEntity<String>> actualizarPassword(@RequestBody UsuarioPasswordDTO usuario, @PathVariable Integer id) {
        OutputEntity<String> out = new OutputEntity<>();
        try {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            usuarioService.actualizaPassword(id, usuario);
            out.success(Response.UPDATE, "Contraseña Actualizada");
            return new ResponseEntity<>(out, out.getCode());            
        } catch (Exception e) {
            out.error();
            return new ResponseEntity<>(out, out.getCode());
        }
    }
    
    //****************************************************************  ROLES **************************************************************** 
    // Guardar ROL
    @PostMapping(value = "/guardarUsuarioRol")
    public ResponseEntity<OutputEntity<String>> guardarRolUsuario(@RequestBody Usuario_Rol usuarioRol) {
        OutputEntity<String> out = new OutputEntity<>();
        try {
            usuarioRolService.save(usuarioRol);
            out.success(Response.UPDATE, "Rol Asignado");
            return new ResponseEntity<>(out, out.getCode());
        } catch (Exception e) {
            out.error();
            return new ResponseEntity<>(out, out.getCode());
        }
    }
    
    // Borrar ROL
    @PostMapping(value = "/eliminarRol/{usuario_id}/{rol_id}")
    public ResponseEntity<OutputEntity<Integer>> eliminarRol(@RequestBody @PathVariable("usuario_id") Integer usuario_id, @PathVariable("rol_id") Integer rol_id) {
        OutputEntity<Integer> out = new OutputEntity<>();
        try {
            usuarioRolService.deleted_Rol(usuario_id, rol_id);
            out.success(Response.DELETED, null);
            return ResponseEntity.ok(out);
        } catch (Exception e) {
            out.error();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    // Buscar Usuario Rol
    @GetMapping(value = "/buscarUsuarioRol/{id}")
    public ResponseEntity<OutputEntity<Set>> buscarUsuarioRol(@PathVariable Integer id) {
        OutputEntity<Set> out = new OutputEntity<>();
        try {
            Usuario result = usuarioService.findOne(id);
            out.success(Response.OK, result.getRoles());
            return new ResponseEntity<>(out, out.getCode());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Actualizar contraseña del Usuario
    //**************************************************************** ACTUALIZAR PASSWORD DE LA SESIÓN INICIADA **************************************************************** 
    @PostMapping(value = "/cambiarContraseña/{password}")
    public ResponseEntity<Usuario> updatePassword(Authentication auth, @RequestBody @PathVariable String password) {
        try {
            String Username = auth.getName();
            Usuario usuario = usuarioService.findByUsuarioSession(Username);
            return new ResponseEntity<>(usuarioService.updatePassword(usuario.getId(), passwordEncoder.encode(password)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    //****************************************************************  VERIFICAR PASSWORD DE SESIÓN **************************************************************** 
    @GetMapping(value = "/verificarPassword/{password}")
    public ResponseEntity<OutputEntity<Boolean>> validarPasswordUser(Authentication auth, @RequestBody @PathVariable String password) {
        OutputEntity<Boolean> out = new OutputEntity<>();
        try {
            String Username = auth.getName();
            Usuario usuario = usuarioService.findByUsuarioSession(Username);
            //System.out.println("Contraseña Ingresada Por el USUARIO--> " + Username);
            //System.out.println("Contraseña Ingresada Por el USUARIO " + password);
            //System.out.println("COMPARACIÓN DE CONTRASEÑAS " +passwordEncoder.matches(password, usuario.getPassword()));
            out.success(Response.OK, passwordEncoder.matches(password, usuario.getPassword()));
            return new ResponseEntity<>(out, out.getCode());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    //****************************************************************  BUSCAR TRABAJADOR POR EXPEDIENTE **************************************************************** 
    @GetMapping(value = "/trabajadorPlantillaExpediente/{expediente}")
    public ResponseEntity<PersonaDTO> trabajadorPlantillaExpediente(@PathVariable Integer expediente) {
        // URL del servicio en el servidor remoto con el parámetro "expediente"
        String urlRemota = "http://10.19.1.242:8080/plantilla/personal/buscar/" + expediente;
        
        // Hacer una solicitud GET al servidor remoto y obtener la respuesta
        ResponseEntity<OutputEntity<PersonaDTO>> response = restTemplate.exchange(
                urlRemota, 
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<OutputEntity<PersonaDTO>>() {
                    
                }
        );
        // Obtener el objeto personalDTO desde la respuesta de OutputEntity
        PersonaDTO personaDTO = response.getBody().getData();
        // Devolver la instancia de PersonaDTO
        return new ResponseEntity<>(personaDTO, HttpStatus.OK);
    }
    
}
