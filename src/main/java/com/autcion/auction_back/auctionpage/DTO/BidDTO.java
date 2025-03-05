package com.autcion.auction_back.auctionpage.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BidDTO {
    private Long bidId;
    private Long itemId;
    private Long bidderId;
    private String bidderNickname;
    private Double bidPrice;
    private LocalDateTime bidTime;
}
