/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.serviceImpl;

import com.controlReparaciones.controlReparaciones.dto.RegistroReparacionDTO;
import com.controlReparaciones.controlReparaciones.dto.RegistroReparacionEditarDTO;
import com.controlReparaciones.controlReparaciones.entity.Cat_Areas;
import com.controlReparaciones.controlReparaciones.entity.Cat_Tipo_Equipos;
import com.controlReparaciones.controlReparaciones.entity.Registro_Reparacion;
import com.controlReparaciones.controlReparaciones.entity.Cat_Marcas;
import com.controlReparaciones.controlReparaciones.entity.Cat_Modelos;
import com.controlReparaciones.controlReparaciones.entity.Cat_Refacciones;
import com.controlReparaciones.controlReparaciones.entity.Cat_Tipo_Refaccion;
import com.controlReparaciones.controlReparaciones.repository.Cat_AreasRepository;
import com.controlReparaciones.controlReparaciones.repository.Cat_MarcasRepository;
import com.controlReparaciones.controlReparaciones.repository.Cat_ModelosRepository;
import com.controlReparaciones.controlReparaciones.repository.Cat_RefaccionesRepository;
import com.controlReparaciones.controlReparaciones.repository.Cat_Tipo_EquiposRepository;
import com.controlReparaciones.controlReparaciones.repository.Cat_Tipo_RefaccionRepository;
import com.controlReparaciones.controlReparaciones.repository.Registro_ReparacionRepository;
import com.controlReparaciones.controlReparaciones.service.RegistroReparacionService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gramirez25
 */

@Service
public class RegistroReparacionServiceImpl implements RegistroReparacionService{
    
    // Se inyecta el repositorio con Autrowired
    @Autowired
    private Registro_ReparacionRepository registro_ReparacionRepository;
    
    @Autowired
    private Cat_Tipo_EquiposRepository cat_Tipo_EquiposRepository;
    
    @Autowired
    private Cat_MarcasRepository  cat_MarcasRepository;
    
    @Autowired
    private Cat_ModelosRepository cat_ModelosRepository;
    
    @Autowired
    private Cat_RefaccionesRepository cat_RefaccionesRepository;
    
    @Autowired
    private Cat_Tipo_RefaccionRepository cat_Tipo_RefaccionRepository;
    
     @Autowired
     private Cat_AreasRepository cat_AreasRepository;
    
    // Busca todos los registros de reparación utilizando la entidad
    @Override
    public List<Registro_Reparacion> findAllRegistroReparacion() {
        return registro_ReparacionRepository.findAll();
    }
    
    // Busca todos los registros de reparación utilizando el DTO
    @Override
    public List<RegistroReparacionDTO> findAllRegistroReparacionDTO() {
        return registro_ReparacionRepository.findAllReparacionesDTO();
    }
    
    // Busca un registro de reparación por ID utilizando el DTO
    @Override
    public RegistroReparacionDTO findOneRegistroReparacion(Integer idRegistroReparacion){
        return registro_ReparacionRepository.findOneRegistroReparacion(idRegistroReparacion);
    }
    
    // Guarda un nuevo registro de reparación utilizando la entidad
    @Override
    public Registro_Reparacion saveRegistroReparacion(Registro_Reparacion registroReparacion) {
        return registro_ReparacionRepository.save(registroReparacion);
    }
    
    // Modifica un registro de reparación ya existente mediante ID y utilizando la entidad
    @Transactional // Se asegura que que se realice toda la transacción y si algo falla, se cancela todo
    @Override
    public Registro_Reparacion updateRegistroReparacion(Integer idRegistroReparacion, Registro_Reparacion registroReparacion) {
        
        // Buscamos si el registro existe en la BD
        Optional<Registro_Reparacion> registroExistente = registro_ReparacionRepository.findById(idRegistroReparacion); // Objeto tipo Optional. Si el registro existe lo trae, si no esixte, regresa vacío
        
        if (registroExistente.isPresent()) {
          
            // Se estrae el registro original completo
            Registro_Reparacion registroOriginal = registroExistente.get();
            
            // Se mantiene la fecha original y se colocal al registro nuevo
            registroReparacion.setFechaRegistro(registroOriginal.getFechaRegistro());
            registroReparacion.setIdReparacion(idRegistroReparacion);
            
            return registro_ReparacionRepository.save(registroReparacion);
        } else {
            // El controlador deberá ver este null y devolver un ResponseEntity con HttpStatus.NOT_FOUND (404).
            return null;
        }
        
    }
    
    // Modifica un registro de reparación mediante su ID y utilizando DTO
    @Transactional
    @Override
    public void modificarRegistroReparacion(Integer idRegistroReparacion, RegistroReparacionEditarDTO dto){
        // Obtener el registro existente
        Registro_Reparacion registro = registro_ReparacionRepository.findById(idRegistroReparacion)
                .orElseThrow(() -> new RuntimeException("No existe la reparación con ID: " + idRegistroReparacion  ));
        // Obtener el tipo de equipo
        Cat_Tipo_Equipos equipoEntidad = cat_Tipo_EquiposRepository.findById(dto.getIdTipoEquipo())
                 .orElseThrow(() -> new RuntimeException("No existe el tipo equipo con ID: " + dto.getIdTipoEquipo() ));
        // Obtener la marca
        Cat_Marcas marcaEntidad = cat_MarcasRepository.findById(dto.getIdMarca())
                 .orElseThrow(() -> new RuntimeException("No existe la marca con ID: " + dto.getIdMarca() ));
        // Obtener el modelo
        Cat_Modelos modeloEntidad = cat_ModelosRepository.findById(dto.getIdModelo())
                 .orElseThrow(() -> new RuntimeException("No existe el modelo con ID: " + dto.getIdModelo() ));
        // Obtener inventario
        String inventario = dto.getInventario();
        // Obtener refacción
        Cat_Refacciones refaccionEntidad = cat_RefaccionesRepository.findById(dto.getIdRefaccion())
                 .orElseThrow(() -> new RuntimeException("No existe la refacción con ID: " + dto.getIdRefaccion() ));
        // Obtener tipo refaccion
        Cat_Tipo_Refaccion tipoRefaccionEntidad =  cat_Tipo_RefaccionRepository.findById(dto.getIdTipoRefaccion())
                 .orElseThrow(() -> new RuntimeException("No existe el tipo refacción con ID: " + dto.getIdTipoRefaccion()));
        // Obtener inventario de refacción
        String inventarioRefaccion = dto.getRefaccionInventario();
        // Obtener descripción del reporte
        String descripcionReporte = dto.getDescripcionReporte();
        // Obtener expediente
        String expediente = dto.getExpediente();
        // Obtener área
        Cat_Areas areaEntidad = cat_AreasRepository.findById(dto.getIdArea())
                 .orElseThrow(() -> new RuntimeException("No existe el área con ID: " + dto.getIdArea()));
        // Obtener fecha
        LocalDate fecha = dto.getFechaRegistro();
        
        // Actualizar valores con ID
        registro.setTipoEquipo(equipoEntidad);
        registro.setMarca(marcaEntidad);
        registro.setModelo(modeloEntidad);
        registro.setRefaccion(refaccionEntidad);
        registro.setTipoRefaccion(tipoRefaccionEntidad);
        registro.setArea(areaEntidad);
        
        // Actualizar valores String
        registro.setInventario(inventario);
        registro.setRefaccionInventario(inventarioRefaccion);
        registro.setDescripcionReporte(descripcionReporte);
        registro.setExpediente(expediente);
        registro.setFechaRegistro(fecha);
        
       registro_ReparacionRepository.save(registro);
        
    }
    
    // Encuentra un registro de reparación para editar
    @Override
    public RegistroReparacionEditarDTO findOneRegistroReparacionEditar(Integer idRegistroReparacion){
        return registro_ReparacionRepository.findOneRegistroReparacionEditar(idRegistroReparacion);
        
    }
    
    // Busca todos los registros de reparación dentro de un rango de fechas utilizando DTO
    @Override
    public List<RegistroReparacionDTO> findAllReparacionesByDateDTO(LocalDate fechaInicio, LocalDate fechaFin){
        return registro_ReparacionRepository.findAllReparacionesByDateDTO(fechaInicio, fechaFin);
    }
    
    // Elimina un registro de reparación mediante ID
    @Override
    public void eliminarRegistroReparacion(Integer idReparacion){
        registro_ReparacionRepository.deleteById(idReparacion);
    }
    
}
