package com.labrin.blockbuster.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationErrors(MethodArgumentNotValidException ex) {

        StringBuilder detalle = new StringBuilder();
        for (FieldError campo : ex.getBindingResult().getFieldErrors()){
            detalle.append(campo.getField())
                   .append(": ")
                   .append(campo.getDefaultMessage())
                   .append(", ");
        }

        ApiError error = new ApiError(400, "Error de validacion", detalle.toString());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<ApiError> handleWebClientError(WebClientResponseException ex){
        if (ex.getStatusCode().valude() == 404){
            ApiError error = new ApiError(404, "ID no encontrado en Open Library", ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        ApiError error = new ApiError(502, "Error al consultar Open Library", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(error); 
    }
   
}
