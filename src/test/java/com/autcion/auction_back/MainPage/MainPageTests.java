package com.autcion.auction_back.MainPage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.autcion.auction_back.MainPage.dao.MainMapper;
import com.autcion.auction_back.MainPage.domain.MarketWishListsDTO;
import com.autcion.auction_back.MainPage.domain.MileageDTO;
import com.autcion.auction_back.MainPage.domain.WishListsDTO;

import java.util.List;

@SpringBootTest
public class MainPageTests {
    
    @Autowired
    private MainMapper mainMapper;

    @Test
    @DisplayName("003 : 관심물품(경매) 저장 테스트")
    public void insertWishListTest() {
        WishListsDTO request = WishListsDTO.builder()
                                    .user_id(1)
                                    .item_id(1)
                                    .build();

        mainMapper.insertWishList(request);
        System.out.println("debug >>> 관심물품(경매) 저장 성공");
    }

    @Test
    @DisplayName("004 : 관심물품(정찰) 저장 테스트")
    public void insertMarketWishListTest() {
        MarketWishListsDTO request = MarketWishListsDTO.builder()
                                    .user_id(1)
                                    .item_id(1)
                                    .build();

        mainMapper.insertMarketWishList(request);
        System.out.println("debug >>> 관심물품(정찰) 저장 성공");
    }

    @Test
    @DisplayName("005 : 관심물품(경매) 삭제 테스트")
    public void deleteWishListTest() {
        mainMapper.deleteWishList(1);
        System.out.println("debug >>> 관심물품(경매) 삭제 성공");
    }

    @Test
    @DisplayName("006 : 관심물품(정찰) 삭제 테스트")
    public void deleteMarketWishListTest() {
        mainMapper.deleteMarketWishList(1);
        System.out.println("debug >>> 관심물품(정찰) 삭제 성공");
    }

    @Test
    @DisplayName("007 : 관심물품(경매) 조회")
    public void selectWishListTest() {
        List<WishListsDTO> result = mainMapper.selectWishList(1);
        for(WishListsDTO wishList : result) {
            System.out.println(wishList);
        }
        System.out.println("debug >>> 관심물품(경매) 조회 성공");
    }

    @Test
    @DisplayName("008 : 관심물품(정찰) 조회")
    public void selectMarketWishListTest() {
        List<MarketWishListsDTO> result = mainMapper.selectMarketWishList(1);
        for(MarketWishListsDTO marketWishList : result) {
            System.out.println(marketWishList);
        }
        System.out.println("debug >>> 관심물품(정찰) 조회 성공");
    }

    @Test
    @DisplayName("011 : 마일리지 적립")
    public void insertMileageTest() {
        MileageDTO request = MileageDTO.builder()
                                    .user_id(1)
                                    .amount(1000)
                                    .build();

        mainMapper.insertMileage(request);
        System.out.println("debug >>> 마일리지 적립 성공");
    }

    @Test
    @DisplayName("012 : 마일리지 조회")
    public void selectMileageTest() {
        int result = mainMapper.selectMileage(1);
        System.out.println(result);
        System.out.println("debug >>> 마일리지 조회 성공");
    }

    @Test
    @DisplayName("013 : 마일리지 사용")
    public void useMileageTest() {
        MileageDTO request = MileageDTO.builder()
                                    .user_id(1)
                                    .amount(-1000)
                                    .build();

        mainMapper.useMileage(request);
        System.out.println("debug >>> 마일리지 사용 성공");
    }

    @Test
    @DisplayName("014 : 마일리지 사용 내역 조회")
    public void selectMileageHistoryTest() {
        List<MileageDTO> result = mainMapper.selectMileageHistory(1);
        for(MileageDTO mileage : result) {
            System.out.println(mileage);
        }   
        System.out.println("debug >>> 마일리지 사용 내역 조회 성공");
    }
}
