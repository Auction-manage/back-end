package com.autcion.auction_back.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsignmentDTO {
    private int consignment_id;
    private int transaction_id;
    private int buyer_id;
    private String buyer_nickname;
    private String buyer_address;
    private String progress_status; // in_progress, completed, canceled
}