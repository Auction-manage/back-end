package com.autcion.auction_back.user.DTO;

import lombok.Data;

@Data
public class SellerInfoDTO {
    private Long userId;
    private String nickname;
    private String name;
    private String phone;
    private String email;
    private String address;
    private Integer sellerRank;
}