package com.autcion.auction_back.UsersPage.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MileageDto {
    private int userId;
    private String amount;
    private String createdAt;
    private String updatedAt;
    private String totalMileage;
}
