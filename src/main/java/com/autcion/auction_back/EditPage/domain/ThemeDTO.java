package com.autcion.auction_back.EditPage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThemeDTO {
    public int theme_id;
    public String theme_name;
    public String theme_info;
    public String logoURL;
}
