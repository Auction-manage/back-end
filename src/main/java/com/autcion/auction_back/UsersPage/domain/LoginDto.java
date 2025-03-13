package com.autcion.auction_back.UsersPage.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDto {
    private String loginId;
    private String password;
}