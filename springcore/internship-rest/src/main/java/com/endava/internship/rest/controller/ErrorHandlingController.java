package com.endava.internship.rest.controller;

import com.endava.internship.rest.exception.ValidationException;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@ControllerAdvice
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ErrorHandlingController implements ErrorController {

    @RequestMapping(path = "/error")
    public HttpEntity<Resource<String>> handleError() {
        return new ResponseEntity<>(new Resource<>("Resource not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public HttpEntity<Resource<String>> handleNullPointerException(NullPointerException npe) {
        return new ResponseEntity<>(new Resource<>(npe.getStackTrace().toString()), INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidationException.class)
    public HttpEntity<Resource<String>> handleValidationException(ValidationException e) {
        return new ResponseEntity<>(new Resource<>(e.getMessage()), BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public HttpEntity<Resource<String>> handleAnyException(Exception e) {
        return new ResponseEntity<>(new Resource<>(e.getMessage()), BAD_REQUEST);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}