package com.autcion.auction_back.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MarketDataDto {
    private String market_id;
    private String seller_id;
    private String seller_nickname;
    private String created_at;
    private String updated_at;
    private String item_count;
    private String rating;
    private String store_type;
    
    private String item_id;

    private String title;
    private String description;
    private String price;
    private String status;
}
