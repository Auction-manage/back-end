package com.autcion.auction_back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.dao.SaleHistoryMapper;
import com.autcion.auction_back.domain.AuctionDataDto;
import com.autcion.auction_back.domain.MarketDataDto;

@Service
public class SaleHistoryService {

    @Autowired
    private SaleHistoryMapper saleHistoryMapper;

    public List<AuctionDataDto> getAuctionData(String user_id) {

        List<AuctionDataDto> auctionData = saleHistoryMapper.AuctionDataRow(user_id);

        return auctionData;
    }

    public List<MarketDataDto> getMarketData(String user_id) {

        List<MarketDataDto> marketData = saleHistoryMapper.MarketDataRow(user_id);

        return marketData;
    }
}
