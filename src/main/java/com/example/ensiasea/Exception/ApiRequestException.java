package com.example.ensiasea.Exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiRequestException extends RuntimeException {
    private String additionalMessage;

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiRequestException(String message, String additionalMessage) {
        super(message);
        this.additionalMessage = additionalMessage;
    }
}
