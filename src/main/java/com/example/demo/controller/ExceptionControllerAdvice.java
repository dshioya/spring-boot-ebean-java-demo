package com.example.demo.controller;

import com.example.demo.exception.NotExistException;
import com.example.demo.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler({NotExistException.class})
    public ResponseEntity handle(NotExistException e) {
        Response response = new Response();
        response.put("errorMessage", e.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }
}
