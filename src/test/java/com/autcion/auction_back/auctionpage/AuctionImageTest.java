package com.autcion.auction_back.auctionpage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.autcion.auction_back.auctionpage.DAO.AuctionImageMapper;
import com.autcion.auction_back.auctionpage.DTO.AuctionImageDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AuctionImageTest {

    @Autowired
    private AuctionImageMapper auctionImageMapper;

    @Test
    public void testSaveAuctionImage() {
        // Given
        AuctionImageDTO image = new AuctionImageDTO();
        image.setItemId(1L);
        image.setImageUrl("dummy_image_url");

        // When
        auctionImageMapper.saveAuctionImage(image);

        // Then
        AuctionImageDTO result = auctionImageMapper.getAuctionImage(1L);
        assertNotNull(result);
        assertEquals("dummy_image_url", result.getImageUrl());
    }

    @Test
    public void testGetAuctionImage() {
        // Given
        AuctionImageDTO image = new AuctionImageDTO();
        image.setItemId(1L);
        image.setImageUrl("dummy_image_url");
        auctionImageMapper.saveAuctionImage(image);

        // When
        AuctionImageDTO result = auctionImageMapper.getAuctionImage(1L);

        // Then
        assertNotNull(result);
        assertEquals("dummy_image_url", result.getImageUrl());
    }

    @Test
    public void testDeleteAuctionImage() {
        // Given
        AuctionImageDTO image = new AuctionImageDTO();
        image.setItemId(1L);
        image.setImageUrl("dummy_image_url");
        auctionImageMapper.saveAuctionImage(image);
        Long imageId = image.getImageId();

        // When
        auctionImageMapper.deleteAuctionImage(imageId);

        // Then
        AuctionImageDTO result = auctionImageMapper.getAuctionImage(1L);
        assertNull(result);
    }

    @Test
    public void testUpdateAuctionImage() {
        // Given
        AuctionImageDTO image = new AuctionImageDTO();
        image.setItemId(1L);
        image.setImageUrl("dummy_image_url");
        auctionImageMapper.saveAuctionImage(image);
        Long imageId = image.getImageId();

        image.setImageUrl("updated_dummy_image_url");

        // When
        auctionImageMapper.updateAuctionImage(image);

        // Then
        AuctionImageDTO result = auctionImageMapper.getAuctionImage(1L);
        assertNotNull(result);
        assertEquals("updated_dummy_image_url", result.getImageUrl());
    }
}