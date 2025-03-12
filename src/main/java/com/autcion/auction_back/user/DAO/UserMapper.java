package com.autcion.auction_back.user.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.user.DTO.UserDTO;

@Mapper
public interface UserMapper {

    // 24) 판매자 정보 조회 (판매자 닉네임, 등급만 조회)
    UserDTO getSellerInfo(int userId);
}