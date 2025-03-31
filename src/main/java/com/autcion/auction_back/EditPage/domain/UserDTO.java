package com.autcion.auction_back.EditPage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    public int user_id;
    public String name;
    public String nickname;
    public int seller_rank;
    public int buyer_rank;
    public String phone;
    public String created_at;
    public String email;
}
