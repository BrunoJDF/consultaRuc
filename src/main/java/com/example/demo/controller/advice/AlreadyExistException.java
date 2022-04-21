package com.example.demo.controller.advice;

public class AlreadyExistException extends Exception {
    public AlreadyExistException(String message) {
        super(message);
    }
}
