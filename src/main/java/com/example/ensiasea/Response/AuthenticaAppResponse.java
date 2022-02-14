package com.example.ensiasea.Response;

import java.util.ArrayList;
import java.util.List;

import com.example.ensiasea.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(value = Include.NON_NULL)
public class AuthenticaAppResponse extends Response {
    private int count;
    private List<User> data;
    @JsonIgnore
    private User authentica;

    public AuthenticaAppResponse(Boolean success, String messageError, String messageSuccess, int count, List<User> data,
            User authentica) {
        super(success, messageError, messageSuccess);
        this.count = count;
        this.data = data;
        this.authentica = authentica;
        if (this.data == null && this.authentica != null) {
            this.data = new ArrayList<>();
            this.data.add(authentica);
            this.setCount(this.getData().size());
        }
    }

}