package com.autcion.auction_back.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.autcion.auction_back.user.DAO.SellerInfoMapper;
import com.autcion.auction_back.user.DTO.SellerInfoDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SellerInfoTest {

    @Autowired
    private SellerInfoMapper sellerInfoMapper;

    @Test
    public void testGetSellerInfo() {
        // Given (유저 데이터는 이미 DB에 존재한다고 가정, user_id=3)
        SellerInfoDTO expected = new SellerInfoDTO();
        expected.setUserId(3L);
        expected.setNickname("test");
        expected.setName("test");
        expected.setPhone("test");
        expected.setEmail("test@test.com");
        expected.setAddress("test");
        expected.setSellerRank(null);

        // When
        SellerInfoDTO result = sellerInfoMapper.getSellerInfo(3L);

        // Then
        assertNotNull(result);
        assertEquals("test", result.getNickname());
        assertEquals("test@test.com", result.getEmail());
    }
}