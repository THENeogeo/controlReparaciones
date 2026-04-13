/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.config;

import java.lang.annotation.*;

/**
 *
 * @author gramirez25
 */

@Target({ElementType.PARAMETER, ElementType.METHOD}) // La posición de destino de la anotación, METHOD se puede anoptar a nivel de método
@Retention(RetentionPolicy.RUNTIME) // En qué etapa se ejecuta la anotación
@Documented // Generar documentación
public @interface SystemControllerLog {
    
    String operation() default"";
    
    String type();
    
}
