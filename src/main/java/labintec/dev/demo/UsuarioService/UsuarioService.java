/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labintec.dev.demo.UsuarioService;

import java.util.List;
import java.util.Optional;
import labintec.dev.demo.entidad.Usuario;
import labintec.dev.demo.excepcion.RecursoDuplicadoException;
import labintec.dev.demo.excepcion.RecursoNoEncontradoException;
import labintec.dev.demo.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author avila
 */

/**
 * Servicio encargado de manejar la lógica de negocio para la entidad Usuario.
 * Este servicio delega las operaciones de acceso a datos a UsuarioRepository.
 * Si un usuario no es encontrado, se lanza una excepción RecursoNoEncontradoException.
 * @author Esteban
 */


@Service
public class UsuarioService {
    
    @Autowired // Inyección automática del repositorio para acceder a la base de datos.
    private UsuarioRepository repositorio;
    
    
    //Recupera la lista de todos los usuarios almacenados.
    public List<Usuario> listarTodos(){
        return repositorio.findAll();
    }
    
    
    // Obtiene un usuario por su ID
    public Usuario obtenerPorID(Long id){
        
        // Busca un usuario por ID en la base de datos, devuelve Optional por si no existe
        Optional<Usuario> opcional = repositorio.findById(id);
        
        if (!opcional.isPresent()){
            throw new RecursoNoEncontradoException("Usuario " + id + " no existe.");
            // Si no se encuentra, lanza una excepción indicando que no existe el recurso
        }
        
        return opcional.get(); // Si existe, devuelve el usuario encontrado
    }
    
    
    // Obtiene un usuario por su username
    public Usuario obtenerPorUsername(String username){
        
         // Busca un usuario por su username, usando método personalizado en el repositorio
        Optional<Usuario> opcional = repositorio.findByUsername(username);
        
        
        if (!opcional.isPresent()){
            throw new RecursoNoEncontradoException("Usuario " + username + " no existe.");
            // Si no existe, lanza excepción
        }
        
        return opcional.get(); // Devuelve el usuario encontrado
    }
    
    
    // Crea un nuevo usuario
    public Usuario crear(Usuario nuevo){
        
        
        Optional<Usuario> opcional = repositorio.findByUsername(nuevo.getUsername());
        
        // Verifica si ya existe un usuario con ese username para evitar duplicados
        
        if(opcional.isPresent()){
            throw new RecursoDuplicadoException("Usuario " + nuevo.getUsername() + " ya existe");
            // Si ya existe, lanza excepción de recurso duplicado
        }
        
        return repositorio.save(nuevo); // Guarda el nuevo usuario en la base de datos y lo devuelve
        
    }
    
    public void eliminarPorID(Long id){
        
        Optional<Usuario> opcional = repositorio.findById(id);
        
        if (opcional.isPresent()){
            repositorio.deleteById(id);
        }
        else{
            throw new RecursoNoEncontradoException("Usuario " + id + " no existe.");
        }
        
    }
    
    public Usuario actualizarUsername(Long id, String nuevoUsername){
        
        Optional<Usuario> opcional = repositorio.findById(id);
        
        if (opcional.isPresent()){
            Usuario usuario = opcional.get();
            
            usuario.setUsername(nuevoUsername);
            
            return repositorio.save(usuario);
        }
        else{
            throw new RecursoNoEncontradoException("Usuario " + id + " no existe.");
        }
        
    }
    
    public Usuario actualizarContra(Long id, String nuevaContra){
        
        Optional<Usuario> opcional = repositorio.findById(id);
        
        if (opcional.isPresent()){
            Usuario usuario = opcional.get();
            
            usuario.setContra(nuevaContra);
            
            return repositorio.save(usuario);
        }
        else{
            throw new RecursoNoEncontradoException("Usuario " + id + " no existe.");
        }
        
    }
    
    public Usuario actualizarUsuario(Long id, String nuevoUsername, String nuevaContra){
        
        Optional<Usuario> opcional = repositorio.findById(id);
        
        if (opcional.isPresent()){
            Usuario usuario = opcional.get();
            
            usuario.setUsername(nuevoUsername);
            usuario.setContra(nuevaContra);
            
            return repositorio.save(usuario);
        }
        else{
            throw new RecursoNoEncontradoException("Usuario " + id + " no existe.");
        }
    }
    
    
}
