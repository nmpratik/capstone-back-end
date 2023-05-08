package com.pra.ems.exception;

public class DuplicateEventException extends RuntimeException{
    public DuplicateEventException(String msg){
        super(msg);
    }
}
