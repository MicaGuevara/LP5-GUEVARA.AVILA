/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labintec.dev.demo.dto;

import labintec.dev.demo.entidad.Usuario;

/**
 *
 * @author avila
 */
/**
 * Clase utilitaria encargada de transformar objetos entre Usuario y UsuarioDTO.
 * Este mapeo es útil para desacoplar la representación externa (DTO) de la
 * estructura interna de persistencia (Entidad), y permite aplicar validaciones
 * o formatos específicos según cada capa de la aplicación.
 * 
 * Esta clase no debe instanciarse.
 * @author Esteban
 */


public class UsuarioMapper {
    
    //CONVIERTE UNA ENTIDAD USUARIO A USUARIO DTO
    public static UsuarioDTO toDTO(Usuario usuario){
        
        if (usuario == null){
            return null; // retorna null si el usuario es null o no existe
        }
        
        UsuarioDTO dto = new UsuarioDTO();  
        dto.setId(usuario.getId());             // toma el id de la entidad y lo asigna al DTO
        dto.setUsername(usuario.getUsername()); // toma el username de la entidad y lo asigna al DTO
        dto.setContra(usuario.getContra());     // toma la contraseña de la entidad y la asigna al DTO
        
        return dto; //El usuarioDTO
    }
    
    //CONVIERTE UN USUARIO DTO A USUARIO
    public static Usuario toUsuario(UsuarioDTO usuariodto){
        
        if (usuariodto == null){
            return null;
        }
        
        Usuario usuario = new Usuario();
        usuario.setId(usuariodto.getId());              // Copia el id del DTO a la entidad usando el getter y setter
        usuario.setUsername(usuariodto.getUsername());  // Copia el username del DTO a la entidad usando el getter y setter
        usuario.setContra(usuariodto.getContra());      // Copia la contraseña (contra) del DTO a la entidad usando el getter y setter
        
        return usuario;
    }
    
    
    public static Usuario toEntity(UsuarioDTO usuariodto){ //convierte un objeto UsuarioDTO en un objeto Usuario (la entidad que se mapea a la base de datos).
        
        Usuario entity = new Usuario();
        entity.setId(usuariodto.getId());               // toma el id del DTO y lo asigna a la entidad
        entity.setUsername(usuariodto.getUsername());   // toma el username del DTO y lo asigna a la entidad
        entity.setContra(usuariodto.getContra());       // toma la contraseña del DTO y la asigna a la entidad
        
        return entity;
    }
}
