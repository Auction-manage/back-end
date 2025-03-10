package com.autcion.auction_back.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.dao.UsersMapper;
import com.autcion.auction_back.domain.LoginDto;
import com.autcion.auction_back.util.JwtUtil;

@Service
public class LoginService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private JwtUtil jwtUtil;

    public Map<String, String> login(LoginDto loginDto) {
        System.out.println("Login service start" + loginDto);
        
        Map<String, String> response = new HashMap<>();
        Integer result = usersMapper.loginRow(loginDto);
        
        if (result > 0) {
            String token = jwtUtil.createToken(loginDto.getLoginId());
            response.put("status", "success");
            response.put("token", token);
            System.out.println("Login success" + token);
            System.out.println("Login success" + response);
        } else {
            response.put("status", "fail");
        }
        
        return response;
    }

}