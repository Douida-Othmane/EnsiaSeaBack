package com.example.ensiasea.Response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.http.ResponseCookie;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(value = Include.NON_NULL)
@AllArgsConstructor
public class LoginResponse {
    private Boolean success;
    @JsonIgnore
    private ResponseCookie cookie;
    private String messageSuccess;
    private String messageError;
}
