package com.autcion.auction_back.EditPage.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminAuthenticationMapper {
    
    // 관리자권한 체크
    public String checkAdmin(int user_id);
}
