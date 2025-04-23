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
    public int market_id;
    public int seller_id;
    public String seller_nickname;
    public LocalDateTime created_at;
    public LocalDateTime updated_at;
    public int item_count;
    public double rating;
    public int store_type;
    public String title;
    public String description;
}
