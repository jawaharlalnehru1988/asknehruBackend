package com.crud.askenehru.AskNehru.Exceptions;

class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
