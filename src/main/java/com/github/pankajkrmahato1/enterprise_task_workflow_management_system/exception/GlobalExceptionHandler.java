package com.github.pankajkrmahato1.enterprise_task_workflow_management_system.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(
            ResourceAlreadyExistsException.class
    )

    public ResponseEntity<ApiErrorResponse>

    handleAlreadyExists(

            ResourceAlreadyExistsException exception){

        ApiErrorResponse response=

                new ApiErrorResponse(

                        LocalDateTime.now(),

                        HttpStatus.CONFLICT.value(),

                        exception.getMessage()

                );

        return ResponseEntity
                .status(
                        HttpStatus.CONFLICT
                )
                .body(response);

    }

    @ExceptionHandler(
            ResourceNotFoundException.class
    )

    public ResponseEntity<ApiErrorResponse>

    handleNotFound(

            ResourceNotFoundException exception){

        ApiErrorResponse response=

                new ApiErrorResponse(

                        LocalDateTime.now(),

                        HttpStatus.NOT_FOUND.value(),

                        exception.getMessage()

                );

        return ResponseEntity
                .status(
                        HttpStatus.NOT_FOUND
                )
                .body(response);

    }

    @ExceptionHandler(
            MethodArgumentNotValidException.class
    )

    public ResponseEntity<ApiErrorResponse>

    handleValidation(

            MethodArgumentNotValidException exception){

        String message=

                exception

                        .getBindingResult()

                        .getFieldError()

                        .getDefaultMessage();

        ApiErrorResponse response=

                new ApiErrorResponse(

                        LocalDateTime.now(),

                        HttpStatus.BAD_REQUEST.value(),

                        message

                );

        return ResponseEntity
                .badRequest()
                .body(response);

    }

}