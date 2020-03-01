package com.example.demo.exception;

public class NotExistException extends RuntimeException {

    public NotExistException() {}

    public NotExistException(String message) {
        super(message);
    }
}
