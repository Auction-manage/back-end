package com.autcion.auction_back.auctionpage.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuctionItemDTO {
    private Long itemId;
    private Long sellerId;
    private String sellerNickname;
    private String title;
    private String description;
    private Double startPrice;
    private Double currentPrice;
    private LocalDateTime endTime;
    private String status; // active, inactive
}
