package com.autcion.auction_back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.dao.ProfileDao;
import com.autcion.auction_back.dao.SaleHistoryMapper;
import com.autcion.auction_back.dao.UsersMapper;
import com.autcion.auction_back.domain.AuctionWishListDto;
import com.autcion.auction_back.domain.MarketWishListDto;
import com.autcion.auction_back.domain.RegisterDto;

@Service
public class ProfileService {

        @Autowired
        private UsersMapper usersMapper;

        @Autowired
        private SaleHistoryMapper saleHistoryMapper;
    
    public ProfileDao profile(String username) {
        System.out.println("debug >>>> profileService");

        ProfileDao result = usersMapper.profileRow(username);

        return result;
    }

    public RegisterDto updateProfile(RegisterDto registerDto) {
        System.out.println("debug >>>> updateProfileService");
        
        int result = usersMapper.updateProfileRow(registerDto);
        
        // 업데이트 성공시 수정된 정보 반환
        if (result > 0) {
            return registerDto;
        }
        return null;  // 업데이트 실패시 null 반환
    }

    public List<AuctionWishListDto> checkWishList(String user_id) {
        System.out.println("debug >>>> checkWishListService");

        List<AuctionWishListDto> result = saleHistoryMapper.checkWishListRow(user_id);

        return result;
    }

    public List<MarketWishListDto> checkMarketWishList(String user_id) {
        System.out.println("debug >>>> checkMarketWishListService");

        List<MarketWishListDto> result = saleHistoryMapper.checkMarketWishListRow(user_id);

        return result;
    }
}
