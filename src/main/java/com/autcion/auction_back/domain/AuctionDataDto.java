package com.autcion.auction_back.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuctionDataDto {
    private String item_id;
    private String seller_id;
    private String seller_nickname;
    private String title;
    private String description;
    private String start_price;
    private String current_price;
    private String end_time;
    private String status;
    private String created_at;
    private String updated_at;
}
