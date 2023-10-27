package com.didem.stonescissorspaper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GameExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValueCanNotBeNull.class)
    public ResponseEntity<String> saveException(RuntimeException response) {
        return new ResponseEntity<>(response.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DatabaseRelatedException.class)
    public ResponseEntity<String> unsubscribeException(RuntimeException response) {
        return new ResponseEntity<>(response.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConversationException.class)
    public ResponseEntity<String> handleConflict(RuntimeException response) {
        return new ResponseEntity<>(response.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
