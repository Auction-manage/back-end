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
public class MileageDTO {
    private int mileage_id;
    private int user_id;
    private int amount;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}