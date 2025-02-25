package com.autcion.auction_back.MainPage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.MainPage.domain.MarketWishListsDTO;
import com.autcion.auction_back.MainPage.domain.MileageDTO;
import com.autcion.auction_back.MainPage.domain.WishListsDTO;

@Mapper
public interface MainMapper {
    
    // 관심물품(경매) 저장
    public void insertWishList(WishListsDTO wishListDTO);

    // 관심물품(정찰) 저장
    public void insertMarketWishList(MarketWishListsDTO marketWishListDTO);

    // 관심물품(경매) 삭제
    public void deleteWishList(int wishlist_id);

    // 관심물품(정찰) 삭제
    public void deleteMarketWishList(int wishlist_id);

    // 관심물품(경매) 조회
    public List<WishListsDTO> selectWishList(int user_id); 

    // 관심물품(정찰) 조회
    public List<MarketWishListsDTO> selectMarketWishList(int user_id);

    // 마일리지 적립
    public void insertMileage(MileageDTO mileageDTO);

    // 마일리지 조회
    public int selectMileage(int user_id);

    // 마일리지 사용
    public void useMileage(MileageDTO mileageDTO);      

    // 마일리지 사용 내역 조회
    public List<MileageDTO> selectMileageHistory(int user_id);
    
    
}
