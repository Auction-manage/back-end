package com.autcion.auction_back.auctionpage.DTO;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.AllArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionItemDTO {
    private int item_id;
    private int seller_id;
    private String seller_nickname;
    private String title;
    private String description;
    private double start_price;
    private double current_price;
    private String status; // active, inactive
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime end_time;
}
