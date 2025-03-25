package com.autcion.auction_back.UsersPage.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InquiryDto {
    private String inquiryId;
    private String userId;
    private String title;
    private String content;
    private String createdAt;
    private String responseStatus;
    private String response;
}
