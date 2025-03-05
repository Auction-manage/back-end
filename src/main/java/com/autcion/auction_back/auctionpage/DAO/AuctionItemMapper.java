package com.autcion.auction_back.auctionpage.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.auctionpage.DTO.AuctionItemDTO;

import java.util.List;

@Mapper
public interface AuctionItemMapper {
    List<AuctionItemDTO> selectAvailableAuctionItems();

    AuctionItemDTO selectAuctionItemDetail(Long itemId);

    void insertAuctionItem(AuctionItemDTO item);

    void updateAuctionItem(AuctionItemDTO item);
    
    void deleteAuctionItem(Long itemId);
}
