package com.autcion.auction_back.virtualmarketpage.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.virtualmarketpage.DTO.VirtualMarketDTO;

import java.util.List;

@Mapper
public interface VirtualMarketMapper {
    // 가상 마켓 전체 조회
    public List<VirtualMarketDTO> getVirtualMarketlist();

    // 가상 마켓 상세 조회 (market_id로)
    public VirtualMarketDTO getVirtualMarket(int market_id);

    // 가상 마켓 생성 (등록)
    public int createVirtualMarket(VirtualMarketDTO virtualMarket);

    // 가상 마켓 수정
    public int updateVirtualMarket(VirtualMarketDTO virtualMarket);

    // 가상 마켓 삭제
    public int deleteVirtualMarket(int market_id);
}