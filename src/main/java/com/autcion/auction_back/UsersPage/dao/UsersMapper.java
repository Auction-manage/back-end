package com.autcion.auction_back.UsersPage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.UsersPage.domain.LoginDto;
import com.autcion.auction_back.UsersPage.domain.MileageDto;
import com.autcion.auction_back.UsersPage.domain.UserDataDto;
import com.autcion.auction_back.UsersPage.domain.AuctionBidsDto;
import com.autcion.auction_back.UsersPage.domain.InquiryDto;

@Mapper
public interface UsersMapper {

    public Integer loginRow(String loginId);

    public Integer registerRow(UserDataDto registerDto);
    
    public ProfileDao profileRow(Integer userId);

    public Integer updateProfileRow(UserDataDto registerDto);

    public String recoverIdRow(UserDataDto param);

    public Integer recoverPasswordRow(UserDataDto param);

    public int updatePasswordRow(UserDataDto param);

    public int deleteAccountRow(String user_id);

    public List<MileageDto> checkMileageRow(Integer user_id);

    public List<AuctionBidsDto> myBidsRow(String user_id);

    public List<InquiryDto> inquiriesByStatusRow(Integer user_id, String status);

    public List<InquiryDto> inquiriesRow(Integer user_id);

    public UserDataDto compareLoginInfoRow(Integer user_id);
}
