package com.kondratyev.taxiaggregator.controllers;

import com.kondratyev.taxiaggregator.exceptions.PriceNotFoundException;
import com.kondratyev.taxiaggregator.exceptions.TripNotFoundException;
import com.kondratyev.taxiaggregator.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({PriceNotFoundException.class, TripNotFoundException.class, UserNotFoundException.class})
    protected ResponseEntity<String> handleNotFound(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    protected ResponseEntity<String> handleException(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}