package com.autcion.auction_back.EditPage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyerRankDTO {
    public int buyer_rank_id;
    public String buyer_rank_name;
    public float buy_benefits;
}
