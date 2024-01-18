package com.kopyshov.renderservice.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResponse handleMethodArgumentNotValid(ConstraintViolationException e) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),e.getMessage());
    }

    @ResponseStatus
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleAllException(Exception e) {
        return new ErrorResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(),e.getMessage());
    }

}
