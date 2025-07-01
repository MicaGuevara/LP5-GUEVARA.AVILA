/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labintec.dev.demo.controlador;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import labintec.dev.demo.TramiteService.TramiteService;
import labintec.dev.demo.dto.TramiteDTO;
import labintec.dev.demo.dto.TramiteMapper;
import labintec.dev.demo.entity.Tramite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Micaela
 */
// Indica que esta clase es un controlador REST, y que sus métodos devuelven datos directamente (en formato JSON por defecto)
@RestController 
// Define la URL base para todas las rutas de este controlador: http://localhost:8080/api/v1/tramites
@RequestMapping("api/v1/tramites") 
public class TramiteController {
    
    @Autowired // Inyección automática del servicio que contiene la lógica de negocio                   
    private TramiteService servicio;
    
    @GetMapping  // Maneja las peticiones GET a la URL base ("/api/v1/tramites")
    @ResponseStatus(HttpStatus.OK) // Devuelve código 200 si es exitoso
    public List<TramiteDTO> listarTramite(){
        List<Tramite> tramites = servicio.listarTodos(); // Obtiene la lista de trámites desde el servicio
        List<TramiteDTO> dtos = new ArrayList(); // Transforma cada Tramite en TramiteDTO
        
        for (Tramite tramite : tramites)
            dtos.add(TramiteMapper.toDTO(tramite));
        return dtos;
    }
    
    @GetMapping("/{id}") // Maneja las peticiones GET a "/api/v1/tramites/{id}"
    @ResponseStatus(HttpStatus.OK) // Código 200 si la operación fue exitosa
    public TramiteDTO obtenerPorId(@PathVariable Long id) {
        Tramite tramite = servicio.obtenerPorId(id);
        return TramiteMapper.toDTO(tramite); 
    }
    
    @GetMapping("/tipo/{tipo}") // Maneja las peticiones GET a "/api/v1/tramites/tipo/{tipo}"
    @ResponseStatus(HttpStatus.OK) 
    public TramiteDTO obtenerPorTipo(@PathVariable String tipo){
        Tramite tramite = servicio.obtenerPorTipo(tipo); // Busca el trámite por tipo en el servicio
        return TramiteMapper.toDTO(tramite); // Devuelve el resultado como DTO
    }
    
    @PostMapping // Maneja las peticiones POST a "/api/v1/tramites"
    @ResponseStatus(HttpStatus.CREATED) // Código 201: recurso creado
    public TramiteDTO crearUsuario(@Valid @RequestBody TramiteDTO dto){
        Tramite nuevo = servicio.crear(TramiteMapper.toEntity(dto)); // Convierte el DTO a entidad y la guarda usando el servicio
        return TramiteMapper.toDTO(nuevo); // Devuelve el trámite guardado como DTO
    }
    
   @DeleteMapping("/{id}") // Maneja las peticiones DELETE a "/api/v1/tramites/{id}"
   @ResponseStatus(HttpStatus.NO_CONTENT) // 204: sin contenido en la respuesta
   public void eliminarPorId(@PathVariable Long id) {
        servicio.eliminarPorId(id);
   }
    
   @PutMapping("/{id}") // Maneja las peticiones PUT a "/api/v1/tramites/{id}"
   @ResponseStatus(HttpStatus.OK) 
    public TramiteDTO actualizarEstado(@PathVariable Long id,@Valid @RequestBody TramiteDTO dto){
      // Actualiza solo el campo 'estado' del trámite identificado por 'id'
      Tramite actualizado = servicio.actualizarEstado(id, dto.getEstado());
      // Devuelve el trámite actualizado como DTO
      return TramiteMapper.toDTO(actualizado);
    }
    
    }
