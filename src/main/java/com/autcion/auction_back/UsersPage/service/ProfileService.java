package com.autcion.auction_back.UsersPage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.UsersPage.dao.ProfileDao;
import com.autcion.auction_back.UsersPage.dao.SaleHistoryMapper;
import com.autcion.auction_back.UsersPage.dao.UsersMapper;
import com.autcion.auction_back.UsersPage.domain.AuctionBidsDto;
import com.autcion.auction_back.UsersPage.domain.AuctionWishListDto;
import com.autcion.auction_back.UsersPage.domain.InquiryDto;
import com.autcion.auction_back.UsersPage.domain.MarketWishListDto;
import com.autcion.auction_back.UsersPage.domain.MileageDto;
import com.autcion.auction_back.UsersPage.domain.UserDataDto;

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

    public UserDataDto updateProfile(UserDataDto registerDto) {
        System.out.println("debug >>>> updateProfileService");
        
        int result = usersMapper.updateProfileRow(registerDto);
        
        // 업데이트 성공시 수정된 정보 반환
        if (result > 0) {
            return registerDto;
        }
        return null;  // 업데이트 실패시 null 반환
    }

    public String deleteAccount(String user_id) {
        System.out.println("debug >>>> deleteAccountService");
        
        Integer result = usersMapper.deleteAccountRow(user_id);

        if(result > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    public List<MileageDto> checkMileage(String user_id) {
        System.out.println("debug >>>> checkMileageService");

        List<MileageDto> result = usersMapper.checkMileageRow(user_id);

        return result;
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

    public String deleteWishlist(String user_id, String auction_id, String type) {
        System.out.println("debug >>>> deleteWishlistService " + user_id + " " + auction_id + " " + type);
        
        try {
            int result = 0;
            
            if (type.equals("auction")) {
                System.out.println("debug >>>> auction wishlist delete progress ...... ");
                result = saleHistoryMapper.deleteAuctionWishlistRow(user_id, auction_id);
            } else if (type.equals("market")) {
                System.out.println("debug >>>> market wishlist delete progress ...... ");
                result = saleHistoryMapper.deleteMarketWishlistRow(user_id, auction_id);
            } else {
                return "invalid_type";
            }
            
            return result > 0 ? "success" : "not_found";
        } catch (Exception e) {
            System.err.println("Error deleting wishlist: " + e.getMessage());
            e.printStackTrace();
            return "fail";
        }
    }

    public List<AuctionBidsDto> myBids(String user_id) {
        System.out.println("debug >>>> myBidsService");

        List<AuctionBidsDto> result = usersMapper.myBidsRow(user_id);

        System.out.println("debug >>>> result " + result);

        return result;
    }

    public List<InquiryDto> myInquiries(String user_id) {
        System.out.println("debug >>>> myInquiriesService");

        List<InquiryDto> result = usersMapper.inquiriesRow(user_id);

        System.out.println("debug >>>> result " + result);

        return result;
    }

}
