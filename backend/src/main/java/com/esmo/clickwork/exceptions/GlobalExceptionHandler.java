package com.esmo.clickwork.exceptions;

import com.esmo.clickwork.dtos.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND, new Date(), ex.getMessage(), null));
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<ApiResponse> handleResourceAlreadyExistException(ResourceAlreadyExistException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(HttpStatus.CONFLICT, new Date(), ex.getMessage(), null));
    }
}
