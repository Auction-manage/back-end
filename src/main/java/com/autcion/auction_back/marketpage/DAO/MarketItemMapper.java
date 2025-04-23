package com.autcion.auction_back.marketpage.DAO;


import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.marketpage.DTO.MarketImageDTO;
import com.autcion.auction_back.marketpage.DTO.MarketItemDTO;

import java.util.List;

@Mapper
public interface MarketItemMapper {

    // 1) 물품(정찰) 구매 가능 리스트 조회
    public List<MarketItemDTO> marketItemList(int marketId);

    // 2) 물품(정찰) 상세 정보 조회
    public MarketItemDTO getMarketItemDetail(int itemId);

    // 3) 물품(정찰) 등록
    public int createMarketItem(MarketItemDTO item);

    // 4) 물품(정찰) 상세 정보 수정
    public int updateMarketItem(MarketItemDTO item);

    // 5) 물품(정찰) 삭제
    public int deleteMarketItem(int itemId);

    // 6) 물품(정찰) 구매 (update status to 'sold_out')
    public int purchaseMarketItem(int itemId);

    // ========== Market Image CRUD ==========
    // 16) 물품(정찰) 이미지 저장
    public int insertMarketImage(MarketImageDTO image);

    // 18) 물품(정찰) 이미지 조회
    public List<MarketImageDTO> getMarketImagesByItemId(int itemId);

    // 20) 물품(정찰) 이미지 수정
    public int updateMarketImage(MarketImageDTO image);

    // 22) 물품(정찰) 이미지 삭제
    public int deleteMarketImage(long imageId);
}

