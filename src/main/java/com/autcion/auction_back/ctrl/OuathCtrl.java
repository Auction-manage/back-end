package com.autcion.auction_back.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autcion.auction_back.dao.ProfileDao;
import com.autcion.auction_back.domain.AuctionDataDto;
import com.autcion.auction_back.domain.LoginDto;
import com.autcion.auction_back.domain.RegisterDto;
import com.autcion.auction_back.service.LoginService;
import com.autcion.auction_back.service.ProfileService;
import com.autcion.auction_back.service.RegisterService;
import com.autcion.auction_back.service.SaleHistoryService;

@RestController
public class OuathCtrl {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private SaleHistoryService saleHistoryService;

    @GetMapping("/")
    public String confirm() {
        return "confirm";
    }
    
    @PostMapping("/register")
    public String register(@RequestBody RegisterDto registerDto) {
        System.out.println("debug >>>> registerDto " + registerDto);

        String result = registerService.register(registerDto);

        System.out.println("debug >>>> result " + result);

        return result;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        System.out.println("debug >>>> loginDto " + loginDto);

        String result = loginService.login(loginDto);
        System.out.println("debug >>>> result " + result);

        if(result.equals("success")) {
            return "success";
        } else {
            return "fail";
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
    public ProfileDao updateProfile(@RequestBody RegisterDto registerDto) {

        RegisterDto result = profileService.updateProfile(registerDto);

        System.out.println("debug >>>> result " + result);

        ProfileDao updateResult = profileService.profile(result.getNickname());

        return updateResult;
        
    }

    @GetMapping("/sale/history")
    public List<AuctionDataDto> salehistories(@RequestParam String user_id) {
        System.out.println("debug >>>> salehistory");

        List<AuctionDataDto> auctionData = saleHistoryService.getAuctionData(user_id);

        // MarketDataDto marketData = saleHistoryService.getMarketData(nickname);

        return auctionData;
    }


}
