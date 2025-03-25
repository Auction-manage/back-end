package com.autcion.auction_back.EditPage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.EditPage.domain.FaqDTO;
import com.autcion.auction_back.EditPage.domain.InquiriesDTO;
import com.autcion.auction_back.EditPage.domain.NoticeDTO;

@Mapper
public interface SupportManageMapper {
    
    public List<Object> getInquries();

    public void updateInquries(InquiriesDTO param);

    public void insertNotice(NoticeDTO param);

    public void updateNotice(NoticeDTO param);

    public void deleteNotice(NoticeDTO param);

    public void insertFaq(FaqDTO param);

    public void updateFaq(FaqDTO param);

    public void deleteFaq(FaqDTO param);
}
