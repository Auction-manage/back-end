package com.oauth.oauthdemo.domain;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String password;
    private String name;
    private String nickname;
    private String phone;
    private String email;
    private String address;
}
