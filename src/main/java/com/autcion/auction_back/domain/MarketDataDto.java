package com.autcion.auction_back.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MarketDataDto {
    private String item_id;
    private String title;
    private String description;
    private String price;
    private String status;
}
