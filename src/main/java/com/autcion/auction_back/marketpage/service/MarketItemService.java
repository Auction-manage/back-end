package com.autcion.auction_back.marketpage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.marketpage.DAO.MarketItemMapper;
import com.autcion.auction_back.marketpage.DTO.MarketImageDTO;
import com.autcion.auction_back.marketpage.DTO.MarketItemDTO;

@Service
public class MarketItemService {

    @Autowired
    private MarketItemMapper marketItemMapper;

    public List<MarketItemDTO> marketItemList(int marketId) {

        System.out.println("debug >>> marketItemService marketItemList marketId: " + marketId);

        List<MarketItemDTO> items = marketItemMapper.marketItemList(marketId);

        System.out.println("debug >>> marketItemService marketItemList items: " + items);
        // TODO: 구현
        return items;
    }

    public MarketItemDTO getMarketItemDetail(int itemId) {

        System.out.println("debug >>> marketItemService getMarketItemDetail " + itemId);

        MarketItemDTO item = marketItemMapper.getMarketItemDetail(itemId);

        System.out.println("debug >>> marketItemService getMarketItemDetail item: " + item);

        // TODO: 구현
        return item;
    }

    public MarketItemDTO createMarketItem(MarketItemDTO itemDTO) {

        System.out.println("debug >>> marketItemService createMarketItem itemDTO: " + itemDTO);

        int result = marketItemMapper.createMarketItem(itemDTO);

        System.out.println("debug >>> marketItemService createMarketItem result: " + result);

        // TODO: 구현

        if (result > 0) {
            return itemDTO;
        } else {
            return null;
        }
    }

    public MarketItemDTO updateMarketItem(MarketItemDTO itemDTO) {
        // TODO: 구현
        return null;
    }

    public String deleteMarketItem(int itemId) {

        System.out.println("debug >>> marketItemService deleteMarketItem itemId: " + itemId);

        int result = marketItemMapper.deleteMarketItem(itemId);

        System.out.println("debug >>> marketItemService deleteMarketItem result: " + result);

        if (result > 0) {
            return "success";
        } else {
            return "fail";
        }
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
