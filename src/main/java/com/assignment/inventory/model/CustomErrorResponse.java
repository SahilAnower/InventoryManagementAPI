package com.assignment.inventory.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Data
public class CustomErrorResponse {
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private String errorCode;
    private List<String> stackTrace;

    public CustomErrorResponse() {}

    public CustomErrorResponse(String message, String path, String errorCode, Exception ex) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.path = path;
        this.errorCode = errorCode;
        this.stackTrace = Arrays.stream(ex.getStackTrace())
                .map(StackTraceElement::toString)
                .limit(10) // Limit stack trace for security
                .toList();
    }
}
