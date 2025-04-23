package com.autcion.auction_back.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BidsDTO {
    private int item_id;
    private int bidder_id;
    private String bidder_nickname;
    private double bid_price;
    private String bid_time; // could be LocalDateTime
}