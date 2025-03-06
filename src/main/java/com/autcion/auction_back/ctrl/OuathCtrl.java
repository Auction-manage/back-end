package com.autcion.auction_back.ctrl;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;import java.util.List;
import com.autcion.auction_back.dao.ProfileDao;
import com.autcion.auction_back.domain.LoginDto;
import com.autcion.auction_back.domain.RegisterDto;
import com.autcion.auction_back.service.LoginService;
import com.autcion.auction_back.service.ProfileService;
import com.autcion.auction_back.service.RegisterService;
import com.autcion.auction_back.domain.AuctionDataDto;
import com.autcion.auction_back.domain.MarketDataDto;
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

    @GetMapping("/sale/history")
    public List<AuctionDataDto> salehistories(@RequestParam String nickname) {
        System.out.println("debug >>>> salehistory");

        List<AuctionDataDto> auctionData = saleHistoryService.getAuctionData(nickname);

        // MarketDataDto marketData = saleHistoryService.getMarketData(nickname);

        return auctionData;
    }

}
