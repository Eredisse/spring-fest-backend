package com.dev.springfestbackend.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException e) {
        List<String> error = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            error.add(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List<ObjectError>> handleBindException(BindException ex) {
        return new ResponseEntity(ex.getAllErrors(),HttpStatus.BAD_REQUEST);
    }

}
