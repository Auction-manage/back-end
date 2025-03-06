package com.autcion.auction_back.EditPage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InquiriesDTO {
    private int inquiry_id;
    private int user_id;
    private String title;
    private String content;
    private String response_status;
    private String response;
    private String created_at;
}
