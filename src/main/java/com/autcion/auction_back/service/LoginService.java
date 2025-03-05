package com.autcion.auction_back.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.dao.UserLoginRepository;
import com.autcion.auction_back.domain.LoginDto;
import com.autcion.auction_back.domain.UserLoginEntity;


@Service
public class LoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    public Optional<UserLoginEntity> login(LoginDto loginDto) {
        System.out.println("debug >>>> loginService ");

        Optional<UserLoginEntity> user = userLoginRepository.findByLoginId(loginDto.getLoginId());
        if(user.isPresent()) {
            if(user.get().getPassword().equals(loginDto.getPassword())) {
                return user;
            }
        }
        return Optional.empty();
    }

}