package com.didem.stonescissorspaper.exception;

public class ConversionException extends RuntimeException{

    public ConversionException(String value) {
        super("String to enum conversation error with value: " + value);
    }

}
