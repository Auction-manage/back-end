package com.autcion.auction_back.EditPage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.EditPage.domain.InquiriesDTO;
import com.autcion.auction_back.EditPage.domain.TransactionInfoDTO;

@Mapper
public interface EditMapper {

    public void insertInquiry(InquiriesDTO inquiriesDTO);

    public void updateInquiry(InquiriesDTO inquiriesDTO);

    public List<InquiriesDTO> selectInquiryByUser(int user_id);

    public List<InquiriesDTO> selectInquiryByAdmin();

    public List<TransactionInfoDTO> selectTransaction();

    public void updateTransaction(TransactionInfoDTO transactionInfoDTO);
    
}