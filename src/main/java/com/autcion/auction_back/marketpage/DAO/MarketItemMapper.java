package com.autcion.auction_back.marketpage.DAO;

import org.apache.ibatis.annotations.Mapper;
import com.autcion.auction_back.marketpage.DTO.MarketItemDTO;

import java.util.List;

@Mapper
public interface MarketItemMapper {
    
    List<MarketItemDTO> selectAvailableMarketItems();

    MarketItemDTO selectMarketItemDetail(Long itemId);

    void insertMarketItem(MarketItemDTO item);

    void updateMarketItem(MarketItemDTO item);

    void deleteMarketItem(Long itemId);
}
