package com.autcion.auction_back.transaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.autcion.auction_back.transaction.DAO.TransactionMapper;
import com.autcion.auction_back.transaction.DTO.TransactionDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TransactionTest {

    @Autowired
    private TransactionMapper transactionMapper;

    @Test
    public void testInsertTransaction() {
        // Given
        TransactionDTO transaction = new TransactionDTO();
        transaction.setBuyerId(3L);
        transaction.setBuyerNickname("test");
        transaction.setBuyerAddress("test");
        transaction.setBuyerPhone("test");
        transaction.setSellerId(3L);
        transaction.setSellerNickname("test");
        transaction.setSellerAddress("test");
        transaction.setSellerPhone("test");

        // When
        transactionMapper.insertTransaction(transaction);

        // Then (추가 검증 로직 필요 시, 데이터베이스에서 조회)
        // 여기서는 삽입만 확인하므로, 실제 DB에서 조회하거나 다른 검증 로직 추가 가능
        assertNotNull(transaction.getTransactionId()); // ID가 자동 생성되었다고 가정
    }
}
