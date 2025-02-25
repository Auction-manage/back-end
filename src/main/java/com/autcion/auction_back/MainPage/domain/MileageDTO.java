package com.autcion.auction_back.MainPage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MileageDTO {
    public int mileage_id;
    public int user_id;
    public int amount;
    public String created_at;
}