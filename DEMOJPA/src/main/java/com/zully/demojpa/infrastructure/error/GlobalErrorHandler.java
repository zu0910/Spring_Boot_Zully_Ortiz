package com.zully.demojpa.infrastructure.error;


import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zully.demojpa.infrastructure.error.model.FieldError;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRunTimeException(RuntimeException e){
        return ResponseEntity.badRequest()
        .body(
            Map.of(
                "error" , e.getMessage(), 
                "statuscode", HttpStatus.BAD_REQUEST.value()
            )
        );
    }
    
    @ExceptionHandler(RolDuplicateException.class)
    public ResponseEntity<?> handleRolDuplicateException(RolDuplicateException e){
        return ResponseEntity.badRequest()
        .body(
            Map.of(
                "error", e.getMessage(),
                "statusCode", e.getStatus().value()
            )
        );
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<?> handlePersonNotFoundException(PersonNotFoundException e){
        return ResponseEntity.status(e.getStatus())
            .body(Map.of("error", e.getMessage(), "statusCode", e.getStatus().value()));
    }

    @ExceptionHandler(RolNotFoundException.class)
    public ResponseEntity<?> handlePersonNotFoundException(RolNotFoundException e){
        return ResponseEntity.status(e.getStatus())
            .body(Map.of("error", e.getMessage(), "statusCode", e.getStatus().value()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleFieldsException(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getFieldErrors().stream()
            .map( field -> new FieldError(field.getField(), field.getDefaultMessage()))
            .toList();
            return ResponseEntity.badRequest().body(fieldErrors);
    }
}
