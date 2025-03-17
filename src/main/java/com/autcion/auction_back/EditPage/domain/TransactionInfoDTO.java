package com.autcion.auction_back.EditPage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionInfoDTO {
    public int transaction_id;
    public int buyer_id;
    public String buyer_address1;
    public String seller_address2;
    public String buyer_phone;
    public String seller_phone;
    public int seller_id;
    public String tracking_number1;
    public String tracking_number2;
    public String tracking_number3;
    public String tracking_number4;
}
