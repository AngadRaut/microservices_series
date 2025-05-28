package com.userService.UserService.exception;

import com.userService.UserService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception){
        String message = exception.getMessage();
        HttpStatus status = HttpStatus.NOT_FOUND;
        boolean success = false;
        ApiResponse response = new ApiResponse(message,success,status);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}