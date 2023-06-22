package com.eorl.domain.common.exception;

import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class EORLExceptionHandler {

    //400
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalArgumentExceptionHandle(IllegalArgumentException e) {
        log.error("[exceptionHandle] ex", e);
        return new ErrorResult("BAD_REQUEST", e.getMessage());
    }

    //404
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ErrorResult noSuchElementExceptionHandler(NoSuchElementException e) {
        log.error("[exceptionHandle] ex", e);
        return new ErrorResult("NOT_FOUND", e.getMessage());
    }

    //500
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResult exceptionHandle(Exception e) {
        log.error("[exceptionHandle] ex", e);
        return new ErrorResult("INTERNAL_SERVER_ERROR", e.getMessage());
    }


}
