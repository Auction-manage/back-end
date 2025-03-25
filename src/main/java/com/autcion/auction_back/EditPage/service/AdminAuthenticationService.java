package com.autcion.auction_back.EditPage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.EditPage.dao.AdminAuthenticationMapper;

@Service
public class AdminAuthenticationService {
    
    @Autowired
    private AdminAuthenticationMapper adminAuthenticationMapper;

    public Boolean checkAdmin(int user_id) {
        System.out.println("debug >>> Service : checkAdmin + " + adminAuthenticationMapper);
        System.out.println("debug >>> Service : checkAdmin + " + user_id);

        String result = adminAuthenticationMapper.checkAdmin(user_id);

        if (result.equals("O")) {
            return true;
        } else {
            return false;
        }
    }
}
