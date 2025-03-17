package com.autcion.auction_back.UsersPage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.UsersPage.dao.UsersMapper;
import com.autcion.auction_back.UsersPage.domain.UserDataDto;

@Service
public class RecoverService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public String recoverId(UserDataDto param) {
        System.out.println("debug >>>> recoverId");

        String result = usersMapper.recoverIdRow(param);

        return result;
    }

    public String recoverPassword(UserDataDto param) {

        System.out.println("debug >>>> recoverPassword");

        int result = usersMapper.recoverPasswordRow(param);

        if(result > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    public String updatePassword(UserDataDto param) {
        System.out.println("debug >>>> updatePassword");

        String encodedPassword = passwordEncoder.encode(param.getPassword());
        param.setPassword(encodedPassword);

        Integer result = usersMapper.updatePasswordRow(param);

        if(result > 0) {
            return "success";
        } else {
            return "fail";
        }
    }
}
