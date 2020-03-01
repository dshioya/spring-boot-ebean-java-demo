package com.example.demo.controller;

import com.example.demo.domain.bean.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

public class BaseController {

    public ResponseEntity badRequest(List<FieldError> errors) {
        Item response = new Item();
        response.put("errors", errors.stream().map(e -> {
            Item item = new Item();
            item.put("name", e.getField());
            item.put("message", e.getDefaultMessage());

            return item;
        }).collect(Collectors.toList()));

        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

}
