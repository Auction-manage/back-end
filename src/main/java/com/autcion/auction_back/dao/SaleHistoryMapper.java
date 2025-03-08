package com.autcion.auction_back.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.domain.AuctionDataDto;
import com.autcion.auction_back.domain.MarketDataDto;

@Mapper
public interface SaleHistoryMapper {

    public List<AuctionDataDto> AuctionDataRow(String user_id);

    public MarketDataDto MarketDataRow(Integer user_id);
}