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
    public int inquiry_id;
    public int author_id;
    public String title;
    public String content;
    public String created_at;
    public String  response_status;
    public String response;
}
