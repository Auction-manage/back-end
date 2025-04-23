package com.autcion.auction_back.UsersPage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDto {
    private int userId;
    private String loginId;
    private String password;
    private String name;
    private String nickname;
    private String phone;
    private String email;
    private String address;
}
