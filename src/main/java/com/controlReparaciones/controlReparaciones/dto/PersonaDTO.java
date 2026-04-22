/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.dto;

import java.io.Serializable;

/**
 *
 * @author gramirez25
 */
public class PersonaDTO implements Serializable{
    private Integer expedienteDTO;
    private String paternoDTO;
    private String maternoDTO;
    private String nombreDTO;
    private String areaDTO;
    private String puestoDTO;

    public PersonaDTO() {
    }

    public PersonaDTO(Integer expedienteDTO, String paternoDTO, String maternoDTO, String nombreDTO, String areaDTO, String puestoDTO) {
        this.expedienteDTO = expedienteDTO;
        this.paternoDTO = paternoDTO;
        this.maternoDTO = maternoDTO;
        this.nombreDTO = nombreDTO;
        this.areaDTO = areaDTO;
        this.puestoDTO = puestoDTO;
    }

    public Integer getExpedienteDTO() {
        return expedienteDTO;
    }

    public void setExpedienteDTO(Integer expedienteDTO) {
        this.expedienteDTO = expedienteDTO;
    }

    public String getPaternoDTO() {
        return paternoDTO;
    }

    public void setPaternoDTO(String paternoDTO) {
        this.paternoDTO = paternoDTO;
    }

    public String getMaternoDTO() {
        return maternoDTO;
    }

    public void setMaternoDTO(String maternoDTO) {
        this.maternoDTO = maternoDTO;
    }

    public String getNombreDTO() {
        return nombreDTO;
    }

    public void setNombreDTO(String nombreDTO) {
        this.nombreDTO = nombreDTO;
    }

    public String getAreaDTO() {
        return areaDTO;
    }

    public void setAreaDTO(String areaDTO) {
        this.areaDTO = areaDTO;
    }

    public String getPuestoDTO() {
        return puestoDTO;
    }

    public void setPuestoDTO(String puestoDTO) {
        this.puestoDTO = puestoDTO;
    }
    
    
    
}
