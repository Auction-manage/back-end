package com.autcion.auction_back.transaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.autcion.auction_back.transaction.DAO.ConsignmentMapper;
import com.autcion.auction_back.transaction.DTO.ConsignmentDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ConsignmentTest {

    @Autowired
    private ConsignmentMapper consignmentMapper;

    @Test
    public void testInsertConsignment() {
        // Given
        ConsignmentDTO consignment = new ConsignmentDTO();
        consignment.setTransactionId(1L); // Transaction이 이미 있다고 가정
        consignment.setBuyerId(3L);
        consignment.setBuyerNickname("test");
        consignment.setBuyerAddress("test");
        consignment.setProgressStatus("in_progress");

        // When
        consignmentMapper.insertConsignment(consignment);

        // Then (추가 검증 로직 필요 시, 데이터베이스에서 조회)
        // 여기서는 삽입만 확인하므로, 실제 DB에서 조회하거나 다른 검증 로직 추가 가능
        assertNotNull(consignment.getConsignmentId()); // ID가 자동 생성되었다고 가정
    }
}
