package com.autcion.auction_back.ctrl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.autcion.auction_back.domain.LoginDto;
import com.autcion.auction_back.domain.RegisterDto;
import com.autcion.auction_back.domain.UserLoginEntity;
import com.autcion.auction_back.service.LoginService;
import com.autcion.auction_back.service.RegisterService;
@RestController
public class OuathCtrl {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private LoginService loginService;

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

        Optional<UserLoginEntity> result = loginService.login(loginDto);
        System.out.println("debug >>>> result " + result);

        if(result.isPresent()) {
            System.out.println("debug >>>> result is present");
            return "success";
        }else {
            System.out.println("debug >>>> result is not present");
            return "fail";
        }
    }

    @GetMapping("/test")
    public void test() {
        System.out.println("debug >>>> test");
    }

}
