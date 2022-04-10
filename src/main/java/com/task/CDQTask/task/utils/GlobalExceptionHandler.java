package com.task.CDQTask.task.utils;

import java.util.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class.getName());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleValidErrors(MethodArgumentNotValidException ex) {
        LOGGER.warning("Catch MethodArgumentNotValidException: " + ex.getAllErrors());
        return ResponseEntity.badRequest().body(ex.getAllErrors());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleTypeMissMatchError(HttpMessageNotReadableException ex) {
        LOGGER.warning("Catch HttpMessageNotReadableException: " + ex.getMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
