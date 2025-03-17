package com.autcion.auction_back.virtualmarketpage.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VirtualMarketDTO {
    private int market_id;
    private int seller_id;
    private String seller_nickname;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private int item_count;
    private double rating;
    private int store_type;
}
