package com.autcion.auction_back.auctionpage.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.auctionpage.DTO.AuctionImageDTO;

@Mapper
public interface AuctionImageMapper {
    void saveAuctionImage(AuctionImageDTO image);

    AuctionImageDTO getAuctionImage(Long itemId);

    void deleteAuctionImage(Long imageId);
    
    void updateAuctionImage(AuctionImageDTO image);
}