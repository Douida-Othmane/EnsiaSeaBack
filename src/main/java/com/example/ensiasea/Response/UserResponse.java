package com.example.ensiasea.Response;

import java.util.ArrayList;
import java.util.List;

import com.example.ensiasea.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class UserResponse {
    private Boolean success;
    private String messageError;
    private String messageSuccess;
    private int count;
    private List<User> data;
    @JsonIgnore
    private User user;

    public UserResponse(Boolean success, String messageError, String messageSuccess, int count, List<User> data,
            User user) {
        this.success = success;
        this.messageError = messageError;
        this.messageSuccess = messageSuccess;
        this.count = count;
        this.data = data;
        this.user = user;
        if (this.data == null && this.user != null) {
            this.data = new ArrayList<>();
            this.data.add(user);
            this.setCount(this.getData().size());
        }
    }

}
