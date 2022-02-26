package com.example.ensiasea.DTO.Blockchain;

import com.example.ensiasea.Models.Asset;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

import java.io.Serializable;
import java.util.*;

@Data
@JsonInclude(value = Include.NON_NULL)
public class Results implements Serializable {
    private Boolean success;
    private String message;
    private Integer count;
    @JsonUnwrapped
    private List<Asset> data;
}
