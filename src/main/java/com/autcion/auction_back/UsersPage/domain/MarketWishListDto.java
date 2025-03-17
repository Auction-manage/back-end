package com.autcion.auction_back.UsersPage.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MarketWishListDto {
    private String user_id;
    private String item_id;
    private String created_at;

    private String title;
    private String description;
    private String price;
    private String status;
    
    private String seller_id;
    private String seller_nickname;
    private String item_count;
    private String rating;
    private String store_type;
}
