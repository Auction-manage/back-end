package com.autcion.auction_back.user.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.user.DTO.SellerInfoDTO;

@Mapper
public interface SellerInfoMapper {
    SellerInfoDTO getSellerInfo(Long userId);
}