package com.example.ensiasea.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private Boolean success;
    private String messageError;
    private String messageSuccess;
}
