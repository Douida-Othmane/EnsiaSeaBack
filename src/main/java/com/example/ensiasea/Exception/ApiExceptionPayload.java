package com.example.ensiasea.Exception;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class ApiExceptionPayload {
    private final Boolean success;
    private final String messageError;
    private final String additionalMessage;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;
}
