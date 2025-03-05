package com.autcion.auction_back.transaction.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.transaction.DTO.ConsignmentDTO;

@Mapper
public interface ConsignmentMapper {
    void insertConsignment(ConsignmentDTO consignment);
}
