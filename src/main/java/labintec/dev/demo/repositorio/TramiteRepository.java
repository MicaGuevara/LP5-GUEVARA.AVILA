/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package labintec.dev.demo.repositorio;

import java.util.Optional;
import labintec.dev.demo.entity.Tramite;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Micaela
 */
public interface TramiteRepository extends JpaRepository<Tramite, Long> {
    // Método busca un Trámite por su tipo
    // Devuelve un Optional<Tramite> para manejar el caso en que no se encuentre ningún resultado
    Optional<Tramite> findByTipo(String tipo);
}
