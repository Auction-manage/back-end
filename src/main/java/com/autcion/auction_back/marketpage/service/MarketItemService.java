package com.autcion.auction_back.marketpage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.autcion.auction_back.marketpage.DTO.MarketImageDTO;
import com.autcion.auction_back.marketpage.DTO.MarketItemDTO;

@Service
public class MarketItemService {

    public List<MarketItemDTO> getAvailableItems() {
        // TODO: 구현
        return null;
    }

    public MarketItemDTO getMarketItemDetail(int itemId) {
        // TODO: 구현
        return null;
    }

    public MarketItemDTO insertMarketItem(MarketItemDTO itemDTO) {
        // TODO: 구현
        return null;
    }

    public MarketItemDTO updateMarketItem(MarketItemDTO itemDTO) {
        // TODO: 구현
        return null;
    }

    public void deleteMarketItem(int itemId) {
        // TODO: 구현
    }

    public void purchaseMarketItem(int itemId) {
        // TODO: 구현
    }

    public void insertMarketImage(MarketImageDTO imageDTO) {
        // TODO: 구현
    }

    public List<MarketImageDTO> getMarketImagesByItemId(int itemId) {
        // TODO: 구현
        return null;
    }

    public void updateMarketImage(MarketImageDTO imageDTO) {
        // TODO: 구현
    }

    public void deleteMarketImage(long imageId) {
        // TODO: 구현
    }
}
