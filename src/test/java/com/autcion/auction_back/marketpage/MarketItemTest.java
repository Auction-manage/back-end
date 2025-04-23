package com.autcion.auction_back.marketpage;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.autcion.auction_back.marketpage.DAO.MarketItemMapper;
import com.autcion.auction_back.marketpage.DTO.MarketImageDTO;
import com.autcion.auction_back.marketpage.DTO.MarketItemDTO;

@SpringBootTest
public class MarketItemTest {

    @Autowired
    private MarketItemMapper marketItemMapper;

    @Test
    @DisplayName("물품(정찰) 구매 가능 리스트 조회")
    public void testGetAvailableMarketItems() {
        // List<MarketItemDTO> items = marketItemMapper.getAvailableItems();
        // items.forEach(i -> System.out.println("Available Market Item: " + i));
    }

    @Test
    @DisplayName("물품(정찰) 상세 정보 조회")
    public void testGetMarketItemDetail() {
        int itemId = 1; // example
        MarketItemDTO item = marketItemMapper.getMarketItemDetail(itemId);
        System.out.println("Market Item Detail: " + item);
    }

    @Test
    @DisplayName("물품(정찰) 등록")
    public void testInsertMarketItem() {
        MarketItemDTO newItem = MarketItemDTO.builder()
                .title("Test Market Item")
                .description("Test Description")
                .price(10000L)
                .status("available")
                .build();
        // int result = marketItemMapper.insertMarketItem(newItem);
        // System.out.println("Insert Market Item Result: " + result);
    }

    @Test
    @DisplayName("물품(정찰) 상세 정보 수정")
    public void testUpdateMarketItem() {
        MarketItemDTO updateItem = MarketItemDTO.builder()
                .item_id(1) // example
                .title("Updated Title")
                .description("Updated Description")
                .price(20000L)
                .build();
        int result = marketItemMapper.updateMarketItem(updateItem);
        System.out.println("Update Market Item Result: " + result);
    }

    @Test
    @DisplayName("물품(정찰) 삭제")
    public void testDeleteMarketItem() {
        int itemId = 1; // example
        int result = marketItemMapper.deleteMarketItem(itemId);
        System.out.println("Delete Market Item Result: " + result);
    }

    @Test
    @DisplayName("물품(정찰) 구매")
    public void testPurchaseMarketItem() {
        int itemId = 2; // example
        int result = marketItemMapper.purchaseMarketItem(itemId);
        System.out.println("Purchase Market Item (status -> sold_out) Result: " + result);
    }

    @Test
    @DisplayName("물품(정찰) 이미지 저장")
    public void testInsertMarketImage() {
        MarketImageDTO imageDTO = MarketImageDTO.builder()
                .item_id(2)
                .image_url("http://example.com/test_market_image.jpg")
                .build();
        int result = marketItemMapper.insertMarketImage(imageDTO);
        System.out.println("Insert Market Image Result: " + result);
    }

    @Test
    @DisplayName("물품(정찰) 이미지 조회")
    public void testGetMarketImagesByItemId() {
        int itemId = 2;
        List<MarketImageDTO> images = marketItemMapper.getMarketImagesByItemId(itemId);
        images.forEach(img -> System.out.println("Market Image: " + img));
    }

    @Test
    @DisplayName("물품(정찰) 이미지 수정")
    public void testUpdateMarketImage() {
        MarketImageDTO imageDTO = MarketImageDTO.builder()
                .image_id(1) // example
                .image_url("http://example.com/updated_market_image.jpg")
                .build();
        int result = marketItemMapper.updateMarketImage(imageDTO);
        System.out.println("Update Market Image Result: " + result);
    }

    @Test
    @DisplayName("물품(정찰) 이미지 삭제")
    public void testDeleteMarketImage() {
        long imageId = 1; // example
        int result = marketItemMapper.deleteMarketImage(imageId);
        System.out.println("Delete Market Image Result: " + result);
    }
    
}
