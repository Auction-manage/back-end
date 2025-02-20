package com.autcion.auction_back.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OuathCtrl {

//    @GetMapping("/login")
//    public String form() {
//	    String redirectUrl = "http://35.216.107.206/confirm";
//        //String redirectUrl = "http://localhost/confirm";
//        System.out.println("debug >>>> redirectUrl " + redirectUrl);
//
//        return "redirect:" + redirectUrl;
//    }

    @GetMapping("/")
    public String confirm() {
        return "confirm";
    }

}
