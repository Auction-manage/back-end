package com.autcion.auction_back.auctionpage.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuctionItemDTO {
    private int item_id;
    private int seller_id;
    private String seller_nickname;
    private String title;
    private String description;
    private double start_price;
    private double current_price;
    private String status; // active, inactive
    private String created_at; // could be LocalDateTime
    private String updated_at; // could be LocalDateTime
    private String end_time;   // could be LocalDateTime
}
