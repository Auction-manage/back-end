package com.autcion.auction_back.UsersPage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.UsersPage.domain.LoginDto;
import com.autcion.auction_back.UsersPage.domain.UserDataDto;

@Mapper
public interface UsersMapper {

    public Integer loginRow(LoginDto loginDto);

    public Integer registerRow(UserDataDto registerDto);
    
    public ProfileDao profileRow(String loginId);

    public int updateProfileRow(UserDataDto registerDto);

    public String recoverIdRow(UserDataDto param);

    public Integer recoverPasswordRow(UserDataDto param);

    public int updatePasswordRow(UserDataDto param);
}
