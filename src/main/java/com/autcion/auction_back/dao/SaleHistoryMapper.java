package com.autcion.auction_back.dao;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.autcion.auction_back.domain.AuctionDataDto;
import com.autcion.auction_back.domain.MarketDataDto;

@Mapper
public interface SaleHistoryMapper {

    public List<AuctionDataDto> AuctionDataRow(String nickname);

    public MarketDataDto MarketDataRow(String nickname);
}