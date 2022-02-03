package com.example.ensiasea.DTO;

import lombok.Data;

@Data
public class UserDto {

    private Long userId;
    private String email;
    private String username;
    private String password;
    private String userDescription;
    private String userCode;
    private String userPicture;

}
