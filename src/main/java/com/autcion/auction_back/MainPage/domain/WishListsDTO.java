package com.autcion.auction_back.MainPage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WishListsDTO {
    public int wishlist_id;
    public int user_id;
    public int item_id;
    public String created_at;
}

