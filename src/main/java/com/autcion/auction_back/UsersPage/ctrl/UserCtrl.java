package com.autcion.auction_back.UsersPage.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autcion.auction_back.UsersPage.dao.ProfileDao;
import com.autcion.auction_back.UsersPage.domain.AuctionBidsDto;
import com.autcion.auction_back.UsersPage.domain.AuctionDataDto;
import com.autcion.auction_back.UsersPage.domain.AuctionWishListDto;
import com.autcion.auction_back.UsersPage.domain.LoginDto;
import com.autcion.auction_back.UsersPage.domain.MarketDataDto;
import com.autcion.auction_back.UsersPage.domain.MarketWishListDto;
import com.autcion.auction_back.UsersPage.domain.MileageDto;
import com.autcion.auction_back.UsersPage.domain.UserDataDto;
import com.autcion.auction_back.UsersPage.service.LoginService;
import com.autcion.auction_back.UsersPage.service.ProfileService;
import com.autcion.auction_back.UsersPage.service.RecoverService;
import com.autcion.auction_back.UsersPage.service.RegisterService;
import com.autcion.auction_back.UsersPage.service.SaleHistoryService;
import com.autcion.auction_back.UsersPage.util.JwtUtil;

@RestController
public class UserCtrl {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private SaleHistoryService saleHistoryService;

    @Autowired
    private RecoverService recoverService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register") // 화원가입 해결
    public String register(@RequestBody UserDataDto registerDto) {
        System.out.println("debug >>>> registerDto " + registerDto);

        String result = registerService.register(registerDto);

        System.out.println("debug >>>> result " + result);

        return result;
    }

    @GetMapping("/login") // 로그인 해결결
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {

        System.out.println("debug >>>> loginDto " + loginDto);

        Map<String, String> result = loginService.login(loginDto);

        System.out.println("debug >>>> result " + result);

        if (result.get("status").equals("success")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
        }
    }

    
    @GetMapping("/profile") // 프로필 조회 해결결
    public ResponseEntity<ProfileDao> profile() {

        System.out.println("debug >>>> profile");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();

        System.out.println("debug >>>> user_info " + userInfo);

        Integer user_id = (Integer) userInfo.get("userId");

        ProfileDao result = profileService.profile(user_id);

        System.out.println("debug >>>> result " + result);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/profile/update") // 프로필 수정 해결결
    public String updateProfile(@RequestBody UserDataDto registerDto) {

        String result = profileService.updateProfile(registerDto);

        System.out.println("debug >>>> result " + result);

        return result;

    }

    @PutMapping("/profile/delete") // 회원 탈퇴 보류류
    public String deleteAccount(@RequestParam String user_id) {
        System.out.println("debug >>>> deleteAccount");

        String result = profileService.deleteAccount(user_id);

        System.out.println("debug >>>> result " + result);

        return result;
    }

    @GetMapping("/profile/wishlist") // 찜목록 조회 해결결
    public Map<String, Object> checkwhishlist() {
        System.out.println("debug >>>> wishlist");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();

        Integer user_id = (Integer) userInfo.get("userId");

        System.out.println("debug >>>> user_id " + user_id + " " + userInfo.get("userId"));

        List<AuctionWishListDto> auctionWishListData = profileService.checkWishList(user_id);
        System.out.println("debug >>>> auctionWishListData " + auctionWishListData);

        List<MarketWishListDto> marketWishListData = profileService.checkMarketWishList(user_id);
        System.out.println("debug >>>> marketWishListData " + marketWishListData);

        Map<String, Object> response = new HashMap<>();
        response.put("auctionWishListData", auctionWishListData);
        response.put("marketWishListData", marketWishListData);

        return response;
    }

    @PutMapping("/profile/wishlist/delete") // 찜목록 삭제 해결결
    public String deleteWishlist(@RequestParam String auction_id, @RequestParam String type) {
        
        System.out.println("debug >>>> deleteWishlist");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();

        Integer user_id = (Integer) userInfo.get("userId");

        String result = profileService.deleteWishlist(user_id, auction_id, type);

        return result;
    }

    @GetMapping("/profile/bids") // 내가 입찰 중인 상품품
    public Map<String, Object> checkBids(@RequestParam String user_id) {
        System.out.println("debug >>>> checkBids");

        List<AuctionBidsDto> myBids = profileService.myBids(user_id);

        System.out.println("debug >>>> myBids " + myBids);

        Map<String, Object> response = new HashMap<>();
        response.put("myBids", myBids);

        return response;
    }

    @GetMapping("/profile/mileage") // 마일리지 조회 해결결
    public List<MileageDto> checkMileage() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();

        Integer user_id = (Integer) userInfo.get("userId");

        System.out.println("debug >>>> getMileage");

        List<MileageDto> result = profileService.checkMileage(user_id);

        System.out.println("debug >>>> result " + result);

        return result;
    }
    
    @GetMapping("/profile/inquiries") // 문의 조회 해결결
    public ResponseEntity<?> getInquiries(
            @RequestParam(required = false) String status,
            @RequestParam(required = false, defaultValue = "false") boolean grouped) {
        
        System.out.println("debug >>>> getInquiries - status: " + status + ", grouped: " + grouped);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();

        Integer user_id = (Integer) userInfo.get("userId");
        
        // 통합된 서비스 메서드 호출
        Object result = profileService.getInquiries(user_id, status, grouped);
        return ResponseEntity.ok(result);
    }
    
    // // 기존 메서드 유지 (하위 호환성)
    // @GetMapping("/profile/inquires")
    // public List<InquiryDto> getMethodName() {

    //     Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    //     Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();

    //     Integer user_id = (Integer) userInfo.get("userId");
        
    //     System.out.println("debug >>>> getMethodName");
    //     List<InquiryDto> result = profileService.myInquiries(user_id);
    //     return result;
    // }
    
    @GetMapping("/recover/id") //아이디 찾기기
    public String recoverId(@RequestParam String name, String phone) {
        System.out.println("debug >>>> recoverId");
        
        UserDataDto param = UserDataDto.builder()
                .name(name)
                .phone(phone)
                .build();

                String result = recoverService.recoverId(param);
                
                return result;
            }
    
    @GetMapping("/recover/password") // 비밀번호 찾기
    public String recoverPassword(@RequestParam String user_id, String name, String phone) {
        System.out.println("debug >>>> recoverPassword");

        UserDataDto param = UserDataDto.builder()
                .loginId(user_id)
                .name(name)
                .phone(phone)
                .build();
                
                String result = recoverService.recoverPassword(param);
                
        System.out.println("debug >>>> result " + result);

        return result;
    }
    
    @PutMapping("/recover/password/update") // 비밀번호 수정
    public String updatePassword(@RequestParam String password, String user_id) {
        System.out.println("debug >>>> updatePassword");

        UserDataDto param = UserDataDto.builder()
        .loginId(user_id)
        .password(password)
        .build();
        
        String result = recoverService.updatePassword(param);
        
        System.out.println("debug >>>> result " + result);
        
        return result;
    }

    @GetMapping("/sale/history") // 내 판매내역 조회 해결결
    public Map<String, Object> salehistories() {
        System.out.println("debug >>>> salehistory");
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();

        Integer user_id = (Integer) userInfo.get("userId");

    
        List<AuctionDataDto> auctionData = saleHistoryService.getAuctionData(user_id);
        List<MarketDataDto> marketData = saleHistoryService.getMarketData(user_id);
    
        Map<String, Object> response = new HashMap<>();
        response.put("auctionData", auctionData);
        response.put("marketData", marketData);
    
        return response;
    }


}