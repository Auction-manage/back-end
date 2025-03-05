package com.autcion.auction_back.auctionpage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.autcion.auction_back.auctionpage.DAO.BidMapper;
import com.autcion.auction_back.auctionpage.DTO.BidDTO;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BidTest {

    @Autowired
    private BidMapper bidMapper;

    @Test
    public void testInsertBid() {
        // Given
        BidDTO bid = new BidDTO();
        bid.setItemId(1L);
        bid.setBidderId(3L);
        bid.setBidderNickname("test");
        bid.setBidPrice(1500.0);
        bid.setBidTime(LocalDateTime.now());

        // When
        bidMapper.insertBid(bid);

        // Then (추가 검증 로직 필요 시, 데이터베이스에서 조회)
        // 여기서는 삽입만 확인하므로, 실제 DB에서 조회하거나 다른 검증 로직 추가 가능
        assertNotNull(bid.getBidId()); // ID가 자동 생성되었다고 가정
    }
}