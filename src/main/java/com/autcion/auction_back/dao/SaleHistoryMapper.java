package com.autcion.auction_back.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.domain.AuctionDataDto;
import com.autcion.auction_back.domain.AuctionWishListDto;
import com.autcion.auction_back.domain.MarketDataDto;
import com.autcion.auction_back.domain.MarketWishListDto;

@Mapper
public interface SaleHistoryMapper {

    public List<AuctionDataDto> AuctionDataRow(String user_id);

    public List<MarketDataDto> MarketDataRow(String user_id);

    public List<AuctionWishListDto> checkWishListRow(String user_id);

    public List<MarketWishListDto> checkMarketWishListRow(String user_id);
}