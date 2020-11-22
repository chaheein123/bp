package com.example.ian.baypeoples.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApplicationErrors> handlerUserNotFoundException(UserNotFoundException ex) {
        ApplicationErrors errors = new ApplicationErrors(ex.getMessage(), "404");
        return new ResponseEntity<ApplicationErrors>(errors, HttpStatus.NOT_FOUND);
    }
}
