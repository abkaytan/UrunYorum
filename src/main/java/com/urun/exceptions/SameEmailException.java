package com.urun.exceptions;

public class SameEmailException extends RuntimeException{
    public SameEmailException(String message) {
        super(message);
    }
}
