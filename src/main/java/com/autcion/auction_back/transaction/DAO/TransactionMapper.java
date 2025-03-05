package com.autcion.auction_back.transaction.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.transaction.DTO.TransactionDTO;

@Mapper
public interface TransactionMapper {
    void insertTransaction(TransactionDTO transaction);
}