package com.hexagonal.library.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class MissingDataExceptions extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        HashMap<String, Object> errors= new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error->{
                    errors.put(error.getField(), error.getDefaultMessage());
                }
        );

        HashMap<String, Object> response = new HashMap<>();
        response.put("error", errors);

        return ResponseEntity.badRequest().body(response);
    }
}
