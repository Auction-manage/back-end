package com.autcion.auction_back.UsersPage.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

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

    public Object getInquiries(String user_id, String status, boolean grouped) {
        System.out.println("debug >>>> getInquiries - status: " + status + ", grouped: " + grouped);
        
        // 1. 문의 데이터 가져오기 (상태 필터링 적용)
        List<InquiryDto> inquiries;
        if (status != null && !status.isEmpty()) {
            // 특정 상태의 문의만 조회
            inquiries = usersMapper.inquiriesByStatusRow(user_id, status);
        } else {
            // 모든 문의 조회
            inquiries = usersMapper.inquiriesRow(user_id);
        }
        
        // 2. 그룹화 여부에 따라 결과 반환
        if (grouped) {
            // 상태별로 그룹화
            Map<String, List<InquiryDto>> groupedInquiries = new HashMap<>();
            
            // 가능한 모든 상태에 대해 빈 리스트 초기화
            groupedInquiries.put("pending", new ArrayList<>());
            groupedInquiries.put("in_progress", new ArrayList<>());
            groupedInquiries.put("completed", new ArrayList<>());
            groupedInquiries.put("cancelled", new ArrayList<>());
            
            // 문의를 상태별로 분류
            for (InquiryDto inquiry : inquiries) {
                String inquiryStatus = inquiry.getResponseStatus();
                if (inquiryStatus != null) {
                    // 해당 상태의 리스트가 없으면 생성
                    if (!groupedInquiries.containsKey(inquiryStatus)) {
                        groupedInquiries.put(inquiryStatus, new ArrayList<>());
                    }
                    // 해당 상태 리스트에 문의 추가
                    groupedInquiries.get(inquiryStatus).add(inquiry);
                }
            }
            
            return groupedInquiries;
        } else {
            // 그룹화 없이 문의 목록 그대로 반환
            return inquiries;
        }
    }
    
    // 기존 메서드 유지 (하위 호환성)
    public List<InquiryDto> myInquiries(String user_id) {
        System.out.println("debug >>>> myInquiriesService");
        return (List<InquiryDto>) getInquiries(user_id, null, false);
    }

    public List<InquiryDto> myInquiriesByStatus(String user_id, String status) {
        System.out.println("debug >>>> myInquiriesByStatusService");
        return (List<InquiryDto>) getInquiries(user_id, status, false);
    }

}
