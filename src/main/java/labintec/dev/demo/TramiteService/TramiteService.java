/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labintec.dev.demo.TramiteService;

import java.util.List;
import java.util.Optional;
import labintec.dev.demo.entity.Tramite;
import labintec.dev.demo.excepcion.RecursoNoEncontradoException;
import labintec.dev.demo.repositorio.TramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Micaela
 */
@Service // Indica que esta clase es un componente de servicio de Spring (lógica de negocio)
public class TramiteService {
    @Autowired // Inyección automática del repositorio que maneja la persistencia de la entidad Tramite
    private TramiteRepository repositorio;
    
    // Método para obtener todos los trámites registrados en la base de datos
    public List<Tramite> listarTodos() {
        return repositorio.findAll();
    }
    
    // Método para obtener un trámite por su ID
    public Tramite obtenerPorId(Long id) {
        Optional<Tramite> opcional = repositorio.findById(id);
        
        if (!opcional.isPresent())
            throw new RecursoNoEncontradoException("TRAMITE " + id + " NO EXISTE.");
        return opcional.get();
    }
    
    // Método para obtener un trámite por su tipo
    public Tramite obtenerPorTipo(String tipo){
        Optional<Tramite> opcional = repositorio.findByTipo(tipo);
        
        if (!opcional.isPresent()){
            throw new RecursoNoEncontradoException("TRAMITE" + tipo + " NO EXISTE");
        }else{
        return opcional.get();
        }
    }
    
    // Método para obtener un trámite por su tipo
    public Tramite crear(Tramite nuevo){
        return repositorio.save(nuevo);
        
    }
    
    // Método para eliminar un trámite por su ID
    public void eliminarPorId(Long id){
        Optional<Tramite> opcional = repositorio.findById(id);
        
        if (opcional.isPresent()){
            repositorio.deleteById(id);
        }
        else{
            throw new RecursoNoEncontradoException("TRAMITE" + id + " NO EXISTE");
        }
        
    }
    
    // Método para actualizar el estado de un trámite existente
    public Tramite actualizarEstado(Long id, String estado){
        Optional<Tramite> opcional= repositorio.findById(id);

        if (opcional.isPresent()){
            Tramite tramite = opcional.get();
            tramite.setEstado(estado);
            return repositorio.save(tramite);
        }else{
            throw new RecursoNoEncontradoException("TRAMITE" + id + " NO EXISTE");
        }
    }
    
}
