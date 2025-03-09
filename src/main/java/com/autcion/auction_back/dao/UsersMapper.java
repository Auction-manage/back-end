package com.autcion.auction_back.dao;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.domain.LoginDto;
import com.autcion.auction_back.domain.RegisterDto;

@Mapper
public interface UsersMapper {

    public Integer loginRow(LoginDto loginDto);

    public Integer registerRow(RegisterDto registerDto);
    
    public ProfileDao profileRow(String username);

    public int updateProfileRow(RegisterDto registerDto);

    public String recoverIdRow(RegisterDto param);

    public Integer recoverPasswordRow(RegisterDto param);

    public int updatePasswordRow(RegisterDto param);
}
