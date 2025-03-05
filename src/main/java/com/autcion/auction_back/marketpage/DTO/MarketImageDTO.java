package com.autcion.auction_back.marketpage.DTO;

import lombok.Data;

@Data
public class MarketImageDTO {
    private Long imageId;
    private Long itemId;
    private String imageUrl;
}