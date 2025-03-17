package com.autcion.auction_back.UsersPage.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InquiryDto {
    private String user_id;
    private String title;
    private String content;
    private String created_at;
    private String response_status;
    private String response;
}
