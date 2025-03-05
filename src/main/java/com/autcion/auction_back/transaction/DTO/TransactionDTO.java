package com.autcion.auction_back.transaction.DTO;

import lombok.Data;

@Data
public class TransactionDTO {
    private Long transactionId;
    private Long buyerId;
    private String buyerNickname;
    private String buyerAddress;
    private String buyerPhone;
    private Long sellerId;
    private String sellerNickname;
    private String sellerAddress;
    private String sellerPhone;
    private String trackingNumber1;
    private String trackingNumber2;
    private String trackingNumber3;
    private String trackingNumber4;
}