package com.autcion.auction_back.EditPage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.EditPage.domain.BannerDTO;
import com.autcion.auction_back.EditPage.domain.ThemeDTO;

@Mapper
public interface DesignManageMapper {
    
    public void updateTheme(ThemeDTO param);

    public void updateBanner(BannerDTO param);
}
