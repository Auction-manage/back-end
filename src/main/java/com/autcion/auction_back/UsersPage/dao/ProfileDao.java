package com.autcion.auction_back.UsersPage.dao;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository
public class ProfileDao {
    private int userId;
    private String name;
    private String nickname;
    private String loginId;
    private String phone;
    private String email;
    private String address;
    private String createdAt;
    private String updatedAt;
    private String adminInfo;
    private int sellerRank;
    private int buyerRank;
    private String provider;
    private String providerLoginId;
}
