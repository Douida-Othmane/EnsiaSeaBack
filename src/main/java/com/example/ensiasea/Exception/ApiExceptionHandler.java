package com.example.ensiasea.Exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = { ApiRequestException.class })
    public ResponseEntity<ApiExceptionPayload> handleApiRequestException(ApiRequestException exception) {

        ApiExceptionPayload exceptionPayload = new ApiExceptionPayload(false, exception.getMessage(),
                exception.getAdditionalMessage(),
                HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(exceptionPayload, HttpStatus.BAD_REQUEST);
    }
}
