/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.util;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author gramirez25
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class DateAudit implements Serializable{
    
    @CreatedDate
    @Column(name = "create_at", nullable = false, updatable = false) // updatable=false evita que se sobreescriba por accidente al editar
    private Date createdAt;
    
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
    
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    // --- GATILLOS DE HIBERNATE ---
    
    /* ¿Qué hace @PrePersist?
    Es un "gatillo" (trigger) de Java. Le dice a Hibernate: "¡Oye! Justo un milisegundo antes de que vayas a hacer el INSERT en la base de datos, 
    ejecuta este método". Así, se auto-asigna la fecha actual del servidor de forma invisible y segura, y la base de datos estará feliz. */

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = new Date(); // Se llenan ambas en la creación para evitar el error 'not-null'!
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date(); // Solo actualiza esta cuando modificamos el registro
    }
    
}
