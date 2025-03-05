package com.autcion.auction_back.auctionpage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.autcion.auction_back.auctionpage.DAO.AuctionItemMapper;
import com.autcion.auction_back.auctionpage.DTO.AuctionItemDTO;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AuctionItemTest {

    @Autowired
    private AuctionItemMapper auctionItemMapper;

    @Test
    public void testSelectAvailableAuctionItems() {
        // Given
        AuctionItemDTO item = new AuctionItemDTO();
        item.setSellerId(3L);
        item.setSellerNickname("test");
        item.setTitle("Test Auction Item");
        item.setDescription("Description");
        item.setStartPrice(1000.0);
        item.setCurrentPrice(1000.0);
        item.setEndTime(LocalDateTime.now().plusDays(1));
        item.setStatus("active");
        auctionItemMapper.insertAuctionItem(item);

        // When
        List<AuctionItemDTO> result = auctionItemMapper.selectAvailableAuctionItems();

        // Then
        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertEquals("Test Auction Item", result.get(0).getTitle());
    }

    @Test
    public void testSelectAuctionItemDetail() {
        // Given
        AuctionItemDTO item = new AuctionItemDTO();
        item.setSellerId(3L);
        item.setSellerNickname("test");
        item.setTitle("Detail Auction Item");
        item.setDescription("Description");
        item.setStartPrice(2000.0);
        item.setCurrentPrice(2000.0);
        item.setEndTime(LocalDateTime.now().plusDays(1));
        item.setStatus("active");
        auctionItemMapper.insertAuctionItem(item);
        Long itemId = item.getItemId();

        // When
        AuctionItemDTO result = auctionItemMapper.selectAuctionItemDetail(itemId);

        // Then
        assertNotNull(result);
        assertEquals("Detail Auction Item", result.getTitle());
    }

    @Test
    public void testInsertAuctionItem() {
        // Given
        AuctionItemDTO item = new AuctionItemDTO();
        item.setSellerId(3L);
        item.setSellerNickname("test");
        item.setTitle("New Auction Item");
        item.setDescription("Description");
        item.setStartPrice(3000.0);
        item.setCurrentPrice(3000.0);
        item.setEndTime(LocalDateTime.now().plusDays(1));
        item.setStatus("active");

        // When
        auctionItemMapper.insertAuctionItem(item);

        // Then
        AuctionItemDTO result = auctionItemMapper.selectAuctionItemDetail(item.getItemId());
        assertNotNull(result);
        assertEquals("New Auction Item", result.getTitle());
    }

    @Test
    public void testUpdateAuctionItem() {
        // Given
        AuctionItemDTO item = new AuctionItemDTO();
        item.setSellerId(3L);
        item.setSellerNickname("test");
        item.setTitle("Original Auction Item");
        item.setDescription("Description");
        item.setStartPrice(4000.0);
        item.setCurrentPrice(4000.0);
        item.setEndTime(LocalDateTime.now().plusDays(1));
        item.setStatus("active");
        auctionItemMapper.insertAuctionItem(item);
        Long itemId = item.getItemId();

        item.setTitle("Updated Auction Item");
        item.setDescription("Updated Description");
        item.setStartPrice(5000.0);
        item.setCurrentPrice(5000.0);
        item.setEndTime(LocalDateTime.now().plusDays(2));
        item.setStatus("active");

        // When
        auctionItemMapper.updateAuctionItem(item);

        // Then
        AuctionItemDTO result = auctionItemMapper.selectAuctionItemDetail(itemId);
        assertNotNull(result);
        assertEquals("Updated Auction Item", result.getTitle());
    }

    @Test
    public void testDeleteAuctionItem() {
        // Given
        AuctionItemDTO item = new AuctionItemDTO();
        item.setSellerId(3L);
        item.setSellerNickname("test");
        item.setTitle("Delete Auction Item");
        item.setDescription("Description");
        item.setStartPrice(6000.0);
        item.setCurrentPrice(6000.0);
        item.setEndTime(LocalDateTime.now().plusDays(1));
        item.setStatus("active");
        auctionItemMapper.insertAuctionItem(item);
        Long itemId = item.getItemId();

        // When
        auctionItemMapper.deleteAuctionItem(itemId);

        // Then
        AuctionItemDTO result = auctionItemMapper.selectAuctionItemDetail(itemId);
        assertNull(result);
    }
}