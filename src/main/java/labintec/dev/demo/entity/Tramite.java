/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labintec.dev.demo.entity;

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
 *
 * @author Micaela
 */
@Data // Lombok: genera automáticamente getters, setters, toString                
@NoArgsConstructor  // Lombok: genera un constructor sin argumentos    
@RequiredArgsConstructor // Lombok: genera un constructor con los campos marcados con @NonNull (tipo,estado y descripcion)
@AllArgsConstructor // Lombok: genera un constructor con todos los campos como parámetros
@Entity // Indica que esta clase es una entidad JPA que se mapeará a una tabla de base de datos
@Table(name="Tramite") // Especifica el nombre de la tabla en la base de datos asociada a esta entidad
public class Tramite {
    
    @Id // Marca este campo como la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Especifica que el valor de este campo se generará automáticamente por la base de datos
    @Column(name="id") // Asocia este campo con la columna "id" de la tabla
    private Long id;
    
    @NonNull // Indica que este campo es obligatorio (para Lombok y el constructor requerido)
    @Column(name="tipo") // Mapea este campo con la columna "tipo" de la tabla
    private String tipo;
    
    @NonNull // Indica que este campo es obligatorio (para Lombok y el constructor requerido)
    @Column(name="estado") // Mapea este campo con la columna "estado" de la tabla
    private String estado;
    
    @NonNull // Indica que este campo es obligatorio (para Lombok y el constructor requerido)
    @Column(name="descripcion") // Mapea este campo con la columna "descripcion" de la tabla
    private String descripcion;
    
}
