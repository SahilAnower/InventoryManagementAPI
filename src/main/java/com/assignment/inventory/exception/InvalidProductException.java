package com.assignment.inventory.exception;

public class InvalidProductException extends RuntimeException{
    public InvalidProductException(String message) {
        super(message);
    }
}
