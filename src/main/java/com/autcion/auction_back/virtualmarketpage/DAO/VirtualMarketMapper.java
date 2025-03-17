package com.autcion.auction_back.virtualmarketpage.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.virtualmarketpage.DTO.VirtualMarketDTO;

import java.util.List;

@Mapper
public interface VirtualMarketMapper {
    // 가상 마켓 전체 조회
    List<VirtualMarketDTO> getAllVirtualMarkets();

    // 가상 마켓 상세 조회 (market_id로)
    VirtualMarketDTO getVirtualMarketById(int market_id);

    // 가상 마켓 생성 (등록)
    int insertVirtualMarket(VirtualMarketDTO virtualMarket);

    // 가상 마켓 수정
    int updateVirtualMarket(VirtualMarketDTO virtualMarket);

    // 가상 마켓 삭제
    int deleteVirtualMarket(int market_id);
}