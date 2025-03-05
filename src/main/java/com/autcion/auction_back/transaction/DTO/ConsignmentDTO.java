package com.autcion.auction_back.transaction.DTO;

import lombok.Data;

@Data
public class ConsignmentDTO {
    private Long consignmentId;
    private Long transactionId;
    private Long buyerId;
    private String buyerNickname;
    private String buyerAddress;
    private String progressStatus; // in_progress, completed, canceled
}