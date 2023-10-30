package com.didem.stonescissorspaper.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class GameExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValueCanNotBeNull.class)
    public ResponseEntity<String> saveException(RuntimeException response) {
        log.error(response.getMessage());
        return new ResponseEntity<>(response.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DatabaseRelatedException.class)
    public ResponseEntity<String> unsubscribeException(RuntimeException response) {
        log.error(response.getMessage());
        return new ResponseEntity<>(response.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConversionException.class)
    public ResponseEntity<String> handleConflict(RuntimeException response) {
        log.error(response.getMessage());
        return new ResponseEntity<>(response.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
