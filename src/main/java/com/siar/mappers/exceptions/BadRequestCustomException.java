package com.siar.mappers.exceptions;

public class BadRequestCustomException extends RuntimeException{
    public BadRequestCustomException(String message){
        super(message);
    }
    public BadRequestCustomException(String message, Throwable cause){
        super(message, cause);
    }
}
