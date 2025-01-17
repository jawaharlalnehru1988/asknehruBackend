package com.crud.askenehru.AskNehru.Exceptions;

public class ValidationException extends RuntimeException {
    public ValidationException(String msg){
        super(msg);
    }
}
