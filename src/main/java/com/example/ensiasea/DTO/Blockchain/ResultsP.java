package com.example.ensiasea.DTO.Blockchain;

import com.example.ensiasea.Models.Asset;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Data;

@Data
public class ResultsP {
    private Boolean success;
    private String message;
    @JsonUnwrapped
    private Asset data;
}
