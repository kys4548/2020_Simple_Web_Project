package com.example.demoinflearnrestapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class ExceptionResponse {
    private LocalDateTime localDateTime;
    private String message;
    private String detail;
}
