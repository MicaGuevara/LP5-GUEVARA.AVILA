package labintec.dev.demo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Representa la entidad Usuario.
 * Esta clase es una entidad JPA que se mapea a la tabla usuario en la base de datos.
 * Se utiliza para almacenar la información básica de un usuario.
 * @author EstebanMica
 */
@Data                   // Lombok: genera getters, setters, equals, hashCode y toString
@NoArgsConstructor      // Lombok: genera un constructor vacío
@RequiredArgsConstructor// Lombok: genera un constructor con los campos marcados como @NonNull (username, contra)
@AllArgsConstructor     // Lombok: genera un constructor con todos los parámetros (id, username, contra)
@Entity                 // JPA: define la clase como entidad persistente
@Table(name="Usuario")  // JPA: especifica el nombre de la tabla en la base de datos
public class Usuario {
    
    /**
     * Identificador único del Usuario.
     * La generación del ID se realiza de forma automática mediante la 
     * estrategia de identidad.
     */
    @Id                                                     // JPA: indica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // JPA: estrategia de generación de ID (usualmente autoincremental)
    @Column(name = "id")                               // JPA: mapea la propiedad "id" en la tabla usuario de la base de datos
    private Long id;
    
    /**
     * Nombre de usuario.
     * Este campo es obligatorio.
     */
    @NonNull                    // Lombok: marca el campo como no nulo, útil al crear instancias
    @Column(name = "username")  // JPA: mapea la propiedad "username" en la tabla usuario de la base de datos
    private String username;
    
    /**
     * 
     * Este campo es obligatorio.
     */
    @NonNull                    // Lombok: marca el campo como no nulo, útil al crear instancias
    @Column(name = "contra")     // JPA: mapea la propiedad "contra" en la tabla usuario de la base de datos
    private String contra;
}