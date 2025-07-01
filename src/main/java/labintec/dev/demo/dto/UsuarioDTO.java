/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labintec.dev.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author avila
 */

@Data                   // Lombok: genera getters, setters, equals, hashCode y toString
@NoArgsConstructor      // Lombok: genera un constructor vacío
@AllArgsConstructor     // Lombok: genera un constructor con todos los parámetros (id, username, contra)
public class UsuarioDTO {
    
    private Long id;
    
    @NotBlank
    private String username;
    
    @NotBlank
    private String contra;
    
}
