package com.autcion.auction_back.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterDto {
    private String loginId;
    private String password;
    private String name;
    private String nickname;
    private String phone;
    private String email;
    private String address;
}
