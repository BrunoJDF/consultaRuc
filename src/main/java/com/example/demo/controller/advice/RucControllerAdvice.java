package com.example.demo.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RucControllerAdvice {

    private ApiException responseError;

    @ExceptionHandler
    public ResponseEntity<ApiException> handleNotFoundException(NotFoundException ex){
        responseError = constructResponse(HttpStatus.NOT_FOUND.value(), ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseError);
    }

    @ExceptionHandler
    public ResponseEntity<ApiException> handleAlreadyExistException(AlreadyExistException ex){
        responseError = constructResponse(HttpStatus.BAD_REQUEST.value(), ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
    }

    private ApiException constructResponse(int value, Exception ex) {
        return ApiException.builder()
                .statusCode(value)
                .message(ex.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
