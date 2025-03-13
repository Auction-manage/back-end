package com.autcion.auction_back.UsersPage.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autcion.auction_back.UsersPage.dao.ProfileDao;
import com.autcion.auction_back.UsersPage.domain.AuctionDataDto;
import com.autcion.auction_back.UsersPage.domain.AuctionWishListDto;
import com.autcion.auction_back.UsersPage.domain.LoginDto;
import com.autcion.auction_back.UsersPage.domain.MarketDataDto;
import com.autcion.auction_back.UsersPage.domain.MarketWishListDto;
import com.autcion.auction_back.UsersPage.domain.UserDataDto;
import com.autcion.auction_back.UsersPage.service.LoginService;
import com.autcion.auction_back.UsersPage.service.ProfileService;
import com.autcion.auction_back.UsersPage.service.RecoverService;
import com.autcion.auction_back.UsersPage.service.RegisterService;
import com.autcion.auction_back.UsersPage.service.SaleHistoryService;

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

    @GetMapping("/")
    public String confirm() {
        return "confirm";
    }

    @PostMapping("/register")
    public String register(@RequestBody UserDataDto registerDto) {
        System.out.println("debug >>>> registerDto " + registerDto);

        String result = registerService.register(registerDto);

        System.out.println("debug >>>> result " + result);

        return result;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        System.out.println("debug >>>> loginDto " + loginDto);

        Map<String, String> result = loginService.login(loginDto);

        if (result.get("status").equals("success")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<ProfileDao> profile(@RequestParam String username) {
        System.out.println("debug >>>> profile");

        ProfileDao result = profileService.profile(username);

        System.out.println("debug >>>> result " + result);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/profile/update")
    public ProfileDao updateProfile(@RequestBody UserDataDto registerDto) {

        UserDataDto result = profileService.updateProfile(registerDto);

        System.out.println("debug >>>> result " + result);

        ProfileDao updateResult = profileService.profile(result.getNickname());

        return updateResult;

    }

    @GetMapping("/profile/wishlist")
    public Map<String, Object> checkwhishlist(@RequestParam String user_id) {
        System.out.println("debug >>>> wishlist");

        List<AuctionWishListDto> auctionData = profileService.checkWishList(user_id);

        List<MarketWishListDto> marketData = profileService.checkMarketWishList(user_id);

        Map<String, Object> response = new HashMap<>();
        response.put("auctionData", auctionData);
        response.put("marketData", marketData);

        return response;
    }

    @GetMapping("/sale/history")
    public Map<String, Object> salehistories(@RequestParam String user_id) {
        System.out.println("debug >>>> salehistory");

        List<AuctionDataDto> auctionData = saleHistoryService.getAuctionData(user_id);
        List<MarketDataDto> marketData = saleHistoryService.getMarketData(user_id);

        Map<String, Object> response = new HashMap<>();
        response.put("auctionData", auctionData);
        response.put("marketData", marketData);

        return response;
    }

    @GetMapping("/recover/id")
    public String recoverId(@RequestParam String name, String phone) {
        System.out.println("debug >>>> recoverId");

        UserDataDto param = UserDataDto.builder()
                .name(name)
                .phone(phone)
                .build();

        String result = recoverService.recoverId(param);

        return result;
    }

    @GetMapping("/recover/password")
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

    @PutMapping("/recover/password/update")
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
}