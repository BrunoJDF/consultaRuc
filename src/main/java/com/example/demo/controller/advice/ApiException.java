package com.example.demo.controller.advice;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiException {
    private int statusCode;
    private String message;
    private LocalDateTime timeStamp;
}
