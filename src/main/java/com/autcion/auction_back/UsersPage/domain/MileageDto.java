package com.autcion.auction_back.UsersPage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MileageDto {
    private int userId;
    private String amount;
    private String createdAt;
    private String updatedAt;
    private String totalMileage;
}
