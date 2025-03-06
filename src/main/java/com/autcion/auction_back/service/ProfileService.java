package com.autcion.auction_back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.dao.ProfileDao;
import com.autcion.auction_back.dao.UsersMapper;

@Service
public class ProfileService {

    @Autowired
    private UsersMapper usersMapper;
    
    public ProfileDao profile(String username) {
        System.out.println("debug >>>> profileService");

        ProfileDao result = usersMapper.profileRow(username);

        return result;
    }
}
