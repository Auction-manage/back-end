package com.autcion.auction_back.dao;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository
public class ProfileDao {
    private int user_id;
    private String name;
    private String nickname;
    private String login_id;
    private String password;
    private String phone;
    private String email;
    private String address;
    private String created_at;
    private String updated_at;
    private String admin_info;
    private String seller_rank;
    private String buyer_rank;
    private String provider;
    private String provider_login_id;
}
