package com.autcion.auction_back.marketpage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.autcion.auction_back.marketpage.DAO.MarketImageMapper;
import com.autcion.auction_back.marketpage.DTO.MarketImageDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MarketImageTest {

    @Autowired
    private MarketImageMapper marketImageMapper;

    @Test
    public void testSaveMarketImage() {
        // Given
        MarketImageDTO image = new MarketImageDTO();
        image.setItemId(1L);
        image.setImageUrl("dummy_image_url");

        // When
        marketImageMapper.saveMarketImage(image);

        // Then
        MarketImageDTO result = marketImageMapper.getMarketImage(1L);
        assertNotNull(result);
        assertEquals("dummy_image_url", result.getImageUrl());
    }

    @Test
    public void testGetMarketImage() {
        // Given
        MarketImageDTO image = new MarketImageDTO();
        image.setItemId(1L);
        image.setImageUrl("dummy_image_url");
        marketImageMapper.saveMarketImage(image);

        // When
        MarketImageDTO result = marketImageMapper.getMarketImage(1L);

        // Then
        assertNotNull(result);
        assertEquals("dummy_image_url", result.getImageUrl());
    }

    @Test
    public void testDeleteMarketImage() {
        // Given
        MarketImageDTO image = new MarketImageDTO();
        image.setItemId(1L);
        image.setImageUrl("dummy_image_url");
        marketImageMapper.saveMarketImage(image);
        Long imageId = image.getImageId();

        // When
        marketImageMapper.deleteMarketImage(imageId);

        // Then
        MarketImageDTO result = marketImageMapper.getMarketImage(1L);
        assertNull(result);
    }

    @Test
    public void testUpdateMarketImage() {
        // Given
        MarketImageDTO image = new MarketImageDTO();
        image.setItemId(1L);
        image.setImageUrl("dummy_image_url");
        marketImageMapper.saveMarketImage(image);
        Long imageId = image.getImageId();

        image.setImageUrl("updated_dummy_image_url");

        // When
        marketImageMapper.updateMarketImage(image);

        // Then
        MarketImageDTO result = marketImageMapper.getMarketImage(1L);
        assertNotNull(result);
        assertEquals("updated_dummy_image_url", result.getImageUrl());
    }
}