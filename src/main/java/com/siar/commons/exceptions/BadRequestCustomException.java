package com.siar.commons.exceptions;

public class BadRequestCustomException extends RuntimeException{
    public BadRequestCustomException(String message){
        super(message);
    }
    public BadRequestCustomException(String message, Throwable cause){
        super(message, cause);
    }
}
