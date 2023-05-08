package com.pra.ems.exception;

public class InvalidTicketException extends RuntimeException{
    public InvalidTicketException(String msg){
        super(msg);
    }
}
