package com.oauth.oauthdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oauth.oauthdemo.dao.UserLoginRepository;
import com.oauth.oauthdemo.domain.UserLoginEntity;
import com.oauth.oauthdemo.domain.LoginDto;


@Service
public class LoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    public Optional<UserLoginEntity> login(LoginDto loginDto) {
        System.out.println("debug >>>> loginService ");

        Optional<UserLoginEntity> user = userLoginRepository.findByUsername(loginDto.getUsername());
        if(user.isPresent()) {
            if(user.get().getPassword().equals(loginDto.getPassword())) {
                return user;
            }
        }
        return Optional.empty();
    }

}