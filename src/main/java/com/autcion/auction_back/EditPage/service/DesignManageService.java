package com.autcion.auction_back.EditPage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.EditPage.dao.DesignManageMapper;
import com.autcion.auction_back.EditPage.domain.BannerDTO;
import com.autcion.auction_back.EditPage.domain.ThemeDTO;

@Service
public class DesignManageService {

    @Autowired
    private DesignManageMapper designManageMapper;

    @Autowired
    private AdminAuthenticationService adminAuthenticationService;

    public void updateTheme(int userId, ThemeDTO param) {
        //권한 체크
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }

        designManageMapper.updateTheme(param);
    }

    public void updateBanner(int userId, BannerDTO param) {
        //권한 체크
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }

        designManageMapper.updateBanner(param);
    }
    
}
