package com.kopyshov.renderservice.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private int statusCode;
    private String status;

    public ErrorResponse(int statusCode, String status, String message) {
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
    }
}
