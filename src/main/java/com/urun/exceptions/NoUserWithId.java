package com.urun.exceptions;

public class NoUserWithId extends RuntimeException{
    public NoUserWithId(String message) {
        super(message);
    }
}
