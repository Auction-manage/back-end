package com.autcion.auction_back.marketpage.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketItemDTO {
    private int item_id;
    private String title;
    private String description;
    private long price;
    private String status; // available, transaction, sold_out
    private int market_id;
}
