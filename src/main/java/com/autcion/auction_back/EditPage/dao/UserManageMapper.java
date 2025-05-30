package com.autcion.auction_back.EditPage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.EditPage.domain.BuyerRankDTO;
import com.autcion.auction_back.EditPage.domain.SellerRankDTO;
import com.autcion.auction_back.EditPage.domain.UserDTO;
import com.autcion.auction_back.MainPage.domain.MileageDTO;

@Mapper
public interface UserManageMapper {
    
    public List<UserDTO> getUserList();

    public void updateUserList(UserDTO param);

    public List<BuyerRankDTO> getRankList1();

    public List<SellerRankDTO> getRankList2();

    public void updateRankList1(BuyerRankDTO param);

    public void updateRankList2(SellerRankDTO param);

    public List<MileageDTO> getAllPoints();

    public void insertMileage(MileageDTO param);
}