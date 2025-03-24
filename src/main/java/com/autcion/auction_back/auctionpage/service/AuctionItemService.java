package com.autcion.auction_back.auctionpage.service;

import java.util.List;

import com.autcion.auction_back.auctionpage.DTO.AuctionImageDTO;
import com.autcion.auction_back.auctionpage.DTO.AuctionItemDTO;
import com.autcion.auction_back.common.BidsDTO;
import com.autcion.auction_back.common.ConsignmentDTO;

public class AuctionItemService {

    public List<AuctionItemDTO> getActiveAuctionItems() {
        // TODO: 구현
        return null;
    }

    public AuctionItemDTO getAuctionItemDetail(int itemId) {
        // TODO: 구현
        return null;
    }

    public AuctionItemDTO insertAuctionItem(AuctionItemDTO itemDTO) {
        // TODO: 구현
        return null;
    }

    public AuctionItemDTO updateAuctionItem(AuctionItemDTO itemDTO) {
        // TODO: 구현
        return null;
    }

    public void deleteAuctionItem(int itemId) {
        // TODO: 구현
    }

    public void placeBid(BidsDTO bidDTO) {
        // TODO: 구현
    }

    public void purchaseAuctionItem(int itemId) {
        // TODO: 구현
    }

    public void registerConsignmentSale(ConsignmentDTO consignmentDTO) {
        // TODO: 구현
    }

    public void applyConsignmentPurchase(ConsignmentDTO consignmentDTO) {
        // TODO: 구현
    }

    public void insertAuctionImage(AuctionImageDTO imageDTO) {
        // TODO: 구현
    }

    public List<AuctionImageDTO> getAuctionImagesByItemId(int itemId) {
        // TODO: 구현
        return null;
    }

    public void updateAuctionImage(AuctionImageDTO imageDTO) {
        // TODO: 구현
    }

    public void deleteAuctionImage(long imageId) {
        // TODO: 구현
    }
}
