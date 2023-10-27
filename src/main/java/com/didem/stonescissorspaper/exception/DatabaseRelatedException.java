package com.didem.stonescissorspaper.exception;

public class DatabaseRelatedException extends RuntimeException{
    public DatabaseRelatedException() {
        super("During database action an error occurred");
    }
}
