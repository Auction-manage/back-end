package com.autcion.auction_back.marketpage.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketImageDTO {
    private long image_id;
    private int item_id;
    private String image_url;
    private String created_at; // could be LocalDateTime
    private String updated_at; // could be LocalDateTime
}