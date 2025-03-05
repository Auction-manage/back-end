package com.autcion.auction_back.auctionpage.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.auctionpage.DTO.BidDTO;

@Mapper
public interface BidMapper {
    void insertBid(BidDTO bid);
}
