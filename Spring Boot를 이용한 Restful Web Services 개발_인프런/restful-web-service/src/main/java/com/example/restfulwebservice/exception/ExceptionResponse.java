package com.example.restfulwebservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private Date date;
    private String message;
    private String detail;
}
