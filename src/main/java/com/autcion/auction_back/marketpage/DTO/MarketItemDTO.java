package com.autcion.auction_back.marketpage.DTO;

import lombok.Data;

@Data
public class MarketItemDTO {
    private Long itemId;
    private String title;
    private String description;
    private Long price;
    private String status; // available, transaction, sold_out
}
