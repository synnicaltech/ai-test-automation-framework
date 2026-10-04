package com.automation.api.exception;

public class ApiInfrastructureException extends RuntimeException {

    public ApiInfrastructureException(String message) {
        super(message);
    }

    public ApiInfrastructureException(String message, Throwable cause) {
        super(message, cause);
    }
}
