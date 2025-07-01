/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labintec.dev.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import lombok.NoArgsConstructor;

/**
 *
 * @author Micaela
 */
@Data // Lombok: genera automáticamente los métodos getters, setters, toString 
@NoArgsConstructor // Lombok: genera un constructor sin argumentos
@AllArgsConstructor // Lombok: genera un constructor con todos los campos como parámetros
public class TramiteDTO {
    // Campo que representa el identificador del trámite
    private Long id;
    // Anotación de validación: el campo no debe estar en blanco
    @NotBlank
    private String tipo;
    // Anotación de validación: el campo no debe estar en blanco
    @NotBlank
    private String estado;
    // Anotación de validación: el campo no debe estar en blanco
    @NotBlank
    private String descripcion;
}
