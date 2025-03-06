package com.autcion.auction_back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.dao.UsersMapper;
import com.autcion.auction_back.domain.LoginDto;

@Service
public class LoginService {

    @Autowired
    private UsersMapper usersMapper;

    public String login(LoginDto loginDto) {
        System.out.println("Login1 service start" + loginDto);

        Integer result = usersMapper.loginRow(loginDto);

        System.out.println("Mapper result : " + result);
        
        System.out.println("debug >>>> loginService login1 result : " + result);
        
        return result > 0 ? "success" : "fail";
    }

}