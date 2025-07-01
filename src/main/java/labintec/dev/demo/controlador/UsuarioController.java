/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labintec.dev.demo.controlador;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import labintec.dev.demo.UsuarioService.UsuarioService;
import labintec.dev.demo.dto.UsuarioDTO;
import labintec.dev.demo.dto.UsuarioMapper;
import labintec.dev.demo.entidad.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para el recurso Usuario.
 * Expone endpoints para consultar usuarios desde la API.
 * Internamente hace uso del servicio UsuarioService para acceder a los datos
 * y utiliza UsuarioMapper para transformar entidades en DTOs.
 * @author avila
 */


@RestController                     // Spring: marca la clase como un controlador REST
@RequestMapping("api/v1/usuarios")  // Spring: prefijo para todas las rutas de este controlador
public class UsuarioController {
    
    
    @Autowired                      // Spring: inyección automática del servicio de usuarios
    private UsuarioService servicio;

    /**
     * Retorna una lista con todos los usuarios disponibles en formato DTO.
     * @return lista de UsuarioDTO con todos los usuarios encontrados.
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)  // Código 200 si la operación fue exitosa
    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = servicio.listarTodos();
        List<UsuarioDTO> dtos = new ArrayList();
        // Se transforma cada entidad Usuario en su representación DTO
        for (Usuario usuario : usuarios)
            dtos.add(UsuarioMapper.toDTO(usuario));
        return dtos;
    }

    /**
     * Devuelve los datos de un usuario específico según su identificador.
     * @param id identificador único del usuario a recuperar
     * (obtenido del path mediante @PathVariable}.
     * @return UsuarioDTO correspondiente al usuario encontrado.
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // Código 200 si la operación fue exitosa
    public UsuarioDTO obtenerPorId(@PathVariable Long id) {
        Usuario usuario = servicio.obtenerPorID(id);
        return UsuarioMapper.toDTO(usuario); 
    }
    
    @GetMapping("/username/{username}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO obtenerPorUsername(@PathVariable String username){
        Usuario usuario = servicio.obtenerPorUsername(username);
        
        return UsuarioMapper.toDTO(usuario);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO crearUsuario(@Valid @RequestBody UsuarioDTO dto){
        Usuario nuevo = servicio.crear(UsuarioMapper.toEntity(dto));
        
        return UsuarioMapper.toDTO(nuevo);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarPorID(@PathVariable Long id){
        Usuario usuario = servicio.obtenerPorID(id);
        
        servicio.eliminarPorID(id);
    }
    
    
    // 1. Actualizar username y contraseña juntos (PUT)
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
        
        Usuario actualizado = servicio.actualizarUsuario(id, dto.getUsername(), dto.getContra());
        
        return UsuarioMapper.toDTO(actualizado);
    }

    // 2. Actualizar solo username (PATCH)
    @PatchMapping("/{id}/username")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO actualizarUsername(@PathVariable Long id, @RequestBody Map<String, String> body) {
        
        String nuevoUsername = body.get("username");
        
        Usuario actualizado = servicio.actualizarUsername(id, nuevoUsername);
        
        return UsuarioMapper.toDTO(actualizado);
    }

    // 3. Actualizar solo contraseña (PATCH)
    @PatchMapping("/{id}/contra")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO actualizarContra(@PathVariable Long id, @RequestBody Map<String, String> body) {
        
        String nuevaContra = body.get("contra");
        
        Usuario actualizado = servicio.actualizarContra(id, nuevaContra);
        
        return UsuarioMapper.toDTO(actualizado);
    }
    
}
