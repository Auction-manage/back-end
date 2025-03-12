package com.autcion.auction_back.MainPage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WishListsDTO {
    private int wishlist_id;
    private int user_id;
    private int item_id;
    private LocalDateTime created_at;
}

