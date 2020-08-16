package com.example.demoinflearnrestapi.exception;

import com.example.demoinflearnrestapi.events.EventWrongValidationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Deprecated
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EventWrongValidationException.class)
    public ResponseEntity handleEventWrongValidationException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse
                = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse
                = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), ex.getBindingResult().toString());

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
