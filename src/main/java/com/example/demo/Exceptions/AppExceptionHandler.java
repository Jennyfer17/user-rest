package com.example.demo.Exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.model.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        String msg = ex.getLocalizedMessage() != null ? ex.getMessage() : ex.toString();

        ErrorMessage message = new ErrorMessage(new Date(), msg);
        return new ResponseEntity<>(
            message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {
        String msg = "Null pointer exception occurred: " + (ex.getLocalizedMessage() != null ? ex.getMessage() : ex.toString());

        ErrorMessage message = new ErrorMessage(new Date(), msg);
        return new ResponseEntity<>(
            message, new HttpHeaders(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {
        String msg = "User service exception occurred: " + (ex.getLocalizedMessage() != null ? ex.getMessage() : ex.toString());

        ErrorMessage message = new ErrorMessage(new Date(), msg);
        return new ResponseEntity<>(
            message, new HttpHeaders(), HttpStatus.BAD_REQUEST
        );
    }
    
}
