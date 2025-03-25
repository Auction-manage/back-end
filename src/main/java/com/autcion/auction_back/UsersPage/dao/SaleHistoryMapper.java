package com.autcion.auction_back.UsersPage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.UsersPage.domain.AuctionDataDto;
import com.autcion.auction_back.UsersPage.domain.AuctionWishListDto;
import com.autcion.auction_back.UsersPage.domain.MarketDataDto;
import com.autcion.auction_back.UsersPage.domain.MarketWishListDto;

@Mapper
public interface SaleHistoryMapper {

    public List<AuctionDataDto> AuctionDataRow(Integer user_id);

    public List<MarketDataDto> MarketDataRow(Integer user_id);

    public List<AuctionWishListDto> checkAuctionWishListRow(Integer user_id);

    public List<MarketWishListDto> checkMarketWishListRow(Integer user_id);

    public int deleteAuctionWishlistRow(Integer user_id, String auction_id);

    public int deleteMarketWishlistRow(Integer user_id, String market_id);
}