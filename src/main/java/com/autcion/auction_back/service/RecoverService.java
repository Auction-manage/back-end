package com.autcion.auction_back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.dao.UsersMapper;
import com.autcion.auction_back.domain.RegisterDto;

@Service
public class RecoverService {

    @Autowired
    private UsersMapper usersMapper;
    
    public String recoverId(RegisterDto param) {
        System.out.println("debug >>>> recoverId");

        String result = usersMapper.recoverIdRow(param);

        return result;
    }

    public String recoverPassword(RegisterDto param) {

        System.out.println("debug >>>> recoverPassword");

        int result = usersMapper.recoverPasswordRow(param);

        if(result > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    public String updatePassword(RegisterDto param) {
        System.out.println("debug >>>> updatePassword");

        Integer result = usersMapper.updatePasswordRow(param);

        if(result > 0) {
            return "success";
        } else {
            return "fail";
        }
    }
}
