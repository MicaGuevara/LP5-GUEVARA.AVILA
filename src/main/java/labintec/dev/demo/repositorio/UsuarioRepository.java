/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package labintec.dev.demo.repositorio;

import java.util.Optional;
import labintec.dev.demo.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad Usuario.
 * Esta interfaz extiende de JpaRepository, lo que le proporciona métodos CRUD
 * básicos, además de la posibilidad de definir consultas personalizadas.
 * @author avila
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByUsername(String username);
}
