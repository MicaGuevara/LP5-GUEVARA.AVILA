/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labintec.dev.demo.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Micaela
 */
// Indica que cuando se lance esta excepción, se debe devolver el código HTTP 404 (NOT FOUND)
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNoEncontradoException extends RuntimeException{
    // Constructor que recibe un mensaje y lo pasa a la clase padre RuntimeException
    public RecursoNoEncontradoException(String message) {
        super(message); // Asigna el mensaje a la excepción para mostrarlo al cliente o al log
    }
   
}
