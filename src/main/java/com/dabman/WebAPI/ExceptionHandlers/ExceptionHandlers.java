package com.dabman.WebAPI.ExceptionHandlers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Void> handleArithmeticException(){
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatusCode.valueOf(440));
        return responseEntity;
    }
}
