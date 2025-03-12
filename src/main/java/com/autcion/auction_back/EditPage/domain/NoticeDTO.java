package com.autcion.auction_back.EditPage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {
    public int notice_id;
    public String notice_title;
    public String notice_info;
    public String created_at;
    public String updated_at;
}
