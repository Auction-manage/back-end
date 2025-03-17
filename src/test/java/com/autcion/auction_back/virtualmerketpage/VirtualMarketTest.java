package com.autcion.auction_back.virtualmerketpage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.autcion.auction_back.virtualmarketpage.DAO.VirtualMarketMapper;
import com.autcion.auction_back.virtualmarketpage.DTO.VirtualMarketDTO;

@SpringBootTest
public class VirtualMarketTest {

    @Autowired
    private VirtualMarketMapper virtualMarketMapper;

    private static int createdMarketId;

    @Test
    @DisplayName("가상 마켓 생성")
    public void testCreateVirtualMarket() {
        VirtualMarketDTO newMarket = VirtualMarketDTO.builder()
                .seller_id(3)           // 수정: user_id=3 사용
                .seller_nickname("test") // 해당 유저의 닉네임
                .item_count(0)
                .rating(0.0)
                .store_type(1)
                .build();

        int insertResult = virtualMarketMapper.insertVirtualMarket(newMarket);
        System.out.println("가상 마켓 생성 결과: " + insertResult);

        // 새로 생성된 market_id 저장
        createdMarketId = newMarket.getMarket_id();
        System.out.println("생성된 가상 마켓 ID: " + createdMarketId);
    }

    @Test
    @DisplayName("가상 마켓 조회")
    public void testGetVirtualMarket() {
        VirtualMarketDTO market = virtualMarketMapper.getVirtualMarketById(createdMarketId);
        System.out.println("가상 마켓 조회 결과: " + market);
    }

    @Test
    @DisplayName("가상 마켓 수정")
    public void testUpdateVirtualMarket() {
        VirtualMarketDTO market = virtualMarketMapper.getVirtualMarketById(createdMarketId);
        if (market == null) {
            System.out.println("수정할 가상 마켓이 존재하지 않습니다.");
            return;
        }
        // 수정 내용 설정
        market.setItem_count(99);
        market.setRating(4.9);
        market.setStore_type(2);

        int updateResult = virtualMarketMapper.updateVirtualMarket(market);
        System.out.println("가상 마켓 수정 결과: " + updateResult);

        VirtualMarketDTO updated = virtualMarketMapper.getVirtualMarketById(createdMarketId);
        System.out.println("수정된 가상 마켓: " + updated);
    }

    @Test
    @DisplayName("가상 마켓 삭제")
    public void testDeleteVirtualMarket() {
        int deleteResult = virtualMarketMapper.deleteVirtualMarket(createdMarketId);
        System.out.println("가상 마켓 삭제 결과: " + deleteResult);

        VirtualMarketDTO afterDelete = virtualMarketMapper.getVirtualMarketById(createdMarketId);
        System.out.println("삭제 후 조회(null 예상): " + afterDelete);
    }
}