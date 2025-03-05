package com.autcion.auction_back.marketpage.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.marketpage.DTO.MarketImageDTO;

@Mapper
public interface MarketImageMapper {
    void saveMarketImage(MarketImageDTO image);

    MarketImageDTO getMarketImage(Long itemId);

    void deleteMarketImage(Long imageId);
    
    void updateMarketImage(MarketImageDTO image);
}