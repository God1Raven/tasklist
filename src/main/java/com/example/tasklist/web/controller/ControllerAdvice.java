package com.example.tasklist.web.controller;

import com.example.tasklist.domain.exeption.AccessDeniedException;
import com.example.tasklist.domain.exeption.Exceptionbody;
import com.example.tasklist.domain.exeption.ResourceMappingException;
import com.example.tasklist.domain.exeption.ResourceNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Exceptionbody handleResourceNotFound(ResourceNotFoundException e){
        return new Exceptionbody(e.getMessage());
    }

    @ExceptionHandler(ResourceMappingException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Exceptionbody handleResourceMapping(ResourceMappingException e){
        return new Exceptionbody(e.getMessage());
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Exceptionbody handleIllegalState(IllegalStateException e){
        return new Exceptionbody(e.getMessage());
    }

    @ExceptionHandler({AccessDeniedException.class, org.springframework.security.access.AccessDeniedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Exceptionbody handleAccessDenied(){
        return new Exceptionbody("Access. Denied");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Exceptionbody handleMethodArgumentNotValid(MethodArgumentNotValidException e){
        Exceptionbody exceptionbody = new Exceptionbody("Validation failed");
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        exceptionbody.setErrors(errors.stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)));
        return exceptionbody;
    }
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Exceptionbody handleConstraintViolation(ConstraintViolationException e){
        Exceptionbody exceptionbody = new Exceptionbody("Validation failed");
        exceptionbody.setErrors(e.getConstraintViolations().stream()
                .collect(Collectors.toMap(
                        violation -> violation.getPropertyPath().toString(),
                        violation -> violation.getPropertyPath().toString()
                )));
        return exceptionbody;
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Exceptionbody handleAuthentication(AuthenticationException e){
        return new Exceptionbody("Authentication failed");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Exceptionbody handleException(Exception e){
        return new Exceptionbody("Internal Error");
    }


}
