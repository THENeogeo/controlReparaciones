/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.entity;

import com.controlReparaciones.controlReparaciones.util.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author gramirez25
 */

@Entity
@Table(name = "usuarios")
public class Usuario extends DateAudit implements UserDetails { 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String ap_paterno;
    
    @NotEmpty 
    private String ap_materno;
    
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;
    
    @NotEmpty
    private Integer activo;
    
    @NotEmpty
    private Integer trabajador_id;
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER) // Cambiamos ALL por MERGE
    /* ¿Por qué MERGE? CascadeType.MERGE le dice a Hibernate: "Si el usuario es nuevo, guárdalo. Si los roles ya existen, no intentes crearlos de nuevo, 
    solo únelos (merge) usando la tabla intermedia".*/
    @JsonIgnore
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getTrabajador_id() {
        return trabajador_id;
    }

    public void setTrabajador_id(Integer trabajador_id) {
        this.trabajador_id = trabajador_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autoridades = new  HashSet<>();
        this.roles.forEach(usuarioRol -> {
            autoridades.add(new Authority(usuarioRol.getRolName().name()));
        });
        return autoridades;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return this.activo != null && this.activo == 1;
    }
    
}
