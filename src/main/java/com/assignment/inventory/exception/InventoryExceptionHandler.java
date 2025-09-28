package com.assignment.inventory.exception;

import com.assignment.inventory.model.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class InventoryExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(
            new CustomErrorResponse(
                    ex.getMessage(),
                    request.getDescription(false),
                    "PRODUCT_NOT_FOUND",
                    ex
            ), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(InvalidProductException.class)
    public ResponseEntity<CustomErrorResponse> handleInvalidProductException(InvalidProductException ex, WebRequest request) {
        return new ResponseEntity<>(
                new CustomErrorResponse(
                        ex.getMessage(),
                        request.getDescription(false),
                        "INVALID_PRODUCT",
                        ex
                ), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handleGlobalException(Exception ex, WebRequest webRequest) {
        return new ResponseEntity<>(
                new CustomErrorResponse(
                        "Unexpected error: " + ex.getMessage(),
                        webRequest.getDescription(false),
                        "INTERNAL_SERVER_ERROR",
                        ex
                ), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
