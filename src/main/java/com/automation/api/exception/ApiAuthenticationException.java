package com.automation.api.exception;

public class ApiAuthenticationException extends RuntimeException{

    public ApiAuthenticationException(String message) { super(message); }

    public ApiAuthenticationException( String message, Throwable cause) { super(message, cause); }
}
