package com.pra.ems.exception;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
