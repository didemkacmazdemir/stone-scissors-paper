package com.didem.stonescissorspaper.exception;

public class ConversationException extends RuntimeException{

    public ConversationException(String value) {
        super("String to enum conversation error with value: " + value);
    }

}
