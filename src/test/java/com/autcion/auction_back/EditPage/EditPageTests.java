package com.autcion.auction_back.EditPage;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.autcion.auction_back.EditPage.dao.EditMapper;
import com.autcion.auction_back.EditPage.domain.InquiriesDTO;
import com.autcion.auction_back.EditPage.domain.TransactionInfoDTO;

@SpringBootTest
public class EditPageTests {

    @Autowired
    private EditMapper editMapper;

    @Test
    @DisplayName("001 : 문의사항 입력")
    public void insertInquiry() {
        InquiriesDTO request = InquiriesDTO.builder()
                                    .author_id(1)
                                    .title("질문이요")
                                    .content("질문좀 할게요 메롱")
                                    .response_status("pending")
                                    .response(null)
                                    .build();
        editMapper.insertInquiry(request);
        System.out.println("debug >>> 문의사항 입력 성공");
    }

    @Test
    @DisplayName("002 : 문의사항 답변")
    public void updateInquiry() {
        InquiriesDTO request = InquiriesDTO.builder()
                                    .author_id(1)
                                    .title("질문이요")
                                    .content("질문좀 할게요 메롱")
                                    .response_status("answered")
                                    .response("답변이요")
                                    .build();
        editMapper.updateInquiry(request);
        System.out.println("debug >>> 문의사항 답변 완료");
    }

    @Test
    @DisplayName("003 : 문의사항 조회(사용자)")
    public void selectInquiryByUser() {
        List<InquiriesDTO> result = editMapper.selectInquiryByUser(1);
        for(InquiriesDTO inquiries : result) {
            System.out.println(inquiries);
        }
        System.out.println("debug >>> 문의사항 조회(사용자) 성공");
    }

    @Test
    @DisplayName("004 : 문의사항 조회(관리자)")
    public void selectInquiryByAdmin() {
        List<InquiriesDTO> result = editMapper.selectInquiryByAdmin();
        for(InquiriesDTO inquiries : result) {
            System.out.println(inquiries);
        }
        System.out.println("debug >>> 문의사항 조회(사용자) 성공");
    }

    @Test
    @DisplayName("005 : 거래정보 조회")
    public void selectTransaction() {
        List<TransactionInfoDTO> result = editMapper.selectTransaction();
        for(TransactionInfoDTO transaction : result) {
            System.out.println(transaction);
        }
        System.out.println("debug >>> 거래정보 조회 성공");
    }

    @Test
    @DisplayName("006 : 거래정보 변경")
    public void updateTransaction() {
        TransactionInfoDTO result = TransactionInfoDTO.builder()
                                        .transaction_id(1)
                                        .buyer_id(1)
                                        .buyer_address1("전주")
                                        .seller_address2("광주")
                                        .buyer_phone("010-1234-5678")
                                        .seller_phone("010-9876-5432")
                                        .seller_id(2)
                                        .tracking_number1("111111")
                                        .tracking_number2("222222")
                                        .tracking_number3("333333")
                                        .tracking_number4("444444")
                                        .build();
        editMapper.updateTransaction(result);
        System.out.println("debug >>> 거래정보 변경 성공");
    }
    
}
