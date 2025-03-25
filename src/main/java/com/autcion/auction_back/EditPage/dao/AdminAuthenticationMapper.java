package com.autcion.auction_back.EditPage.dao;

public interface AdminAuthenticationMapper {
    
    // 관리자권한 체크
    public String checkAdmin(int user_id);
}
