package com.web.store_auth_api.store_auth_api.exception;

public class TokenCreationOrValidationException extends RuntimeException{

    public TokenCreationOrValidationException(String message, Throwable cause){
        super(message, cause);
    }
}
