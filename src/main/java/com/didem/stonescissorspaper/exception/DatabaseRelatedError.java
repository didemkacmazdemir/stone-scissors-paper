package com.didem.stonescissorspaper.exception;

public class DatabaseRelatedError extends RuntimeException{
    public DatabaseRelatedError() {
        super("During database action an error occurred");
    }
}
