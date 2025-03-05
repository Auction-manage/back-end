package com.autcion.auction_back.marketpage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.autcion.auction_back.marketpage.DAO.MarketItemMapper;
import com.autcion.auction_back.marketpage.DTO.MarketItemDTO;

public class MarketItemTest {

    @Autowired
    private MarketItemMapper marketItemMapper;

    @Test
    public void testSelectAvailableMarketItems() {
        // Given (테스트 데이터 삽입)
        MarketItemDTO item = new MarketItemDTO();
        item.setTitle("Test Item");
        item.setPrice(1000L);
        item.setStatus("available");
        marketItemMapper.insertMarketItem(item);

        // When
        List<MarketItemDTO> result = marketItemMapper.selectAvailableMarketItems();

        // Then
        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertEquals("Test Item", result.get(0).getTitle());
    }

    @Test
    public void testSelectMarketItemDetail() {
        // Given
        MarketItemDTO item = new MarketItemDTO();
        item.setTitle("Detail Item");
        item.setPrice(2000L);
        item.setStatus("available");
        marketItemMapper.insertMarketItem(item);
        Long itemId = item.getItemId();

        // When
        MarketItemDTO result = marketItemMapper.selectMarketItemDetail(itemId);

        // Then
        assertNotNull(result);
        assertEquals("Detail Item", result.getTitle());
    }

    @Test
    public void testInsertMarketItem() {
        // Given
        MarketItemDTO item = new MarketItemDTO();
        item.setTitle("New Item");
        item.setPrice(3000L);
        item.setStatus("available");

        // When
        marketItemMapper.insertMarketItem(item);

        // Then
        MarketItemDTO result = marketItemMapper.selectMarketItemDetail(item.getItemId());
        assertNotNull(result);
        assertEquals("New Item", result.getTitle());
    }

    @Test
    public void testUpdateMarketItem() {
        // Given
        MarketItemDTO item = new MarketItemDTO();
        item.setTitle("Original Item");
        item.setPrice(4000L);
        item.setStatus("available");
        marketItemMapper.insertMarketItem(item);
        Long itemId = item.getItemId();

        item.setTitle("Updated Item");
        item.setPrice(5000L);
        item.setStatus("transaction");

        // When
        marketItemMapper.updateMarketItem(item);

        // Then
        MarketItemDTO result = marketItemMapper.selectMarketItemDetail(itemId);
        assertNotNull(result);
        assertEquals("Updated Item", result.getTitle());
        assertEquals(5000L, result.getPrice());
    }

    @Test
    public void testDeleteMarketItem() {
        // Given
        MarketItemDTO item = new MarketItemDTO();
        item.setTitle("Delete Item");
        item.setPrice(6000L);
        item.setStatus("available");
        marketItemMapper.insertMarketItem(item);
        Long itemId = item.getItemId();

        // When
        marketItemMapper.deleteMarketItem(itemId);

        // Then
        MarketItemDTO result = marketItemMapper.selectMarketItemDetail(itemId);
        assertNull(result);
    }
}