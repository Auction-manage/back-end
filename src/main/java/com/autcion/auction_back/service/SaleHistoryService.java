package com.autcion.auction_back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.autcion.auction_back.dao.SaleHistoryMapper;
import com.autcion.auction_back.domain.AuctionDataDto;
import com.autcion.auction_back.domain.MarketDataDto;

@Service
public class SaleHistoryService {

    @Autowired
    private SaleHistoryMapper saleHistoryMapper;

    public List<AuctionDataDto> getAuctionData(String nickname) {

        List<AuctionDataDto> auctionData = saleHistoryMapper.AuctionDataRow(nickname);

        return auctionData;
    }

    public MarketDataDto getMarketData(String nickname) {

        MarketDataDto marketData = saleHistoryMapper.MarketDataRow(nickname);

        return marketData;
    }
}
