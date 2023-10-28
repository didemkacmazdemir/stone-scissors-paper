package com.didem.stonescissorspaper.exception;

public class ValueCanNotBeNull extends RuntimeException{
    public ValueCanNotBeNull(String value) {
        super("Value can not be null " + value);
    }
}
