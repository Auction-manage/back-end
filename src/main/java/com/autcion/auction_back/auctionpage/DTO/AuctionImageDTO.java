package com.autcion.auction_back.auctionpage.DTO;

import lombok.Data;

@Data
public class AuctionImageDTO {
    private Long imageId;
    private Long itemId;
    private String imageUrl;
}