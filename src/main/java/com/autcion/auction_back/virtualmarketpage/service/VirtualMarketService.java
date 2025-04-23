package com.autcion.auction_back.virtualmarketpage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.virtualmarketpage.DAO.VirtualMarketMapper;
import com.autcion.auction_back.virtualmarketpage.DTO.VirtualMarketDTO;

@Service
public class VirtualMarketService {

    @Autowired
    private VirtualMarketMapper virtualMarketMapper;

    public List<VirtualMarketDTO> getVirtualMarketlist() {

        System.out.println("debug >>> getVirtualMarketlist");

        List<VirtualMarketDTO> marketList = virtualMarketMapper.getVirtualMarketlist();

        System.out.println("debug >>> getVirtualMarketlist" + marketList);

        // TODO: 구현
        return marketList;
    }

    public VirtualMarketDTO getVirtualMarket(int marketId) {

        System.out.println("debug >>> getVirtualMarket");

        VirtualMarketDTO market = virtualMarketMapper.getVirtualMarket(marketId);

        System.out.println("debug >>> getVirtualMarket" + market);

        // TODO: 구현
        return market;
    }

    public VirtualMarketDTO createVirtualMarket(VirtualMarketDTO marketDTO) {

        System.out.println("debug >>> createVirtualMarket");

        int response = virtualMarketMapper.createVirtualMarket(marketDTO);

        System.out.println("debug >>> createVirtualMarket" + response);

        if (response > 0) {
            return marketDTO;
        } else {
            return null;
        }
    }

    public VirtualMarketDTO updateVirtualMarket(VirtualMarketDTO marketDTO) {
        // TODO: 구현
        return null;
    }

    public String deleteVirtualMarket(int marketId) {
        System.out.println("debug >>> virtualMarketService deleteVirtualMarket");

        int response = virtualMarketMapper.deleteVirtualMarket(marketId);

        System.out.println("debug >>> virtualMarketService deleteVirtualMarket" + response);

        return "success";
    }
}
