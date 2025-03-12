package com.autcion.auction_back.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.autcion.auction_back.user.DAO.UserMapper;
import com.autcion.auction_back.user.DTO.UserDTO;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @DisplayName("판매자 정보 조회 (판매자 닉네임, 등급만 조회)")
    public void testGetSellerInfo() {
        int userId = 11; // example
        UserDTO seller = userMapper.getSellerInfo(userId);
        System.out.println("Seller Info: " + seller);
    }
}