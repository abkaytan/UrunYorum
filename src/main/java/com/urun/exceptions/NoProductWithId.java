package com.urun.exceptions;

public class NoProductWithId extends RuntimeException{
    public NoProductWithId(String message) {
        super(message);
    }
}
