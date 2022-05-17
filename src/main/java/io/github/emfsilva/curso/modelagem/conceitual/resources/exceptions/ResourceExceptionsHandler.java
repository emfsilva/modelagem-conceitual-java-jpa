package io.github.emfsilva.curso.modelagem.conceitual.resources.exceptions;

import io.github.emfsilva.curso.modelagem.conceitual.services.exceptions.ObjectNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionsHandler {

    @ExceptionHandler(ObjectNotFountException.class)
    public ResponseEntity<StandarError> objectNotFound(ObjectNotFountException e, HttpServletRequest request) {
        StandarError err = new StandarError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
