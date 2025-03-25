package com.autcion.auction_back.EditPage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.EditPage.dao.SupportManageMapper;
import com.autcion.auction_back.EditPage.domain.FaqDTO;
import com.autcion.auction_back.EditPage.domain.InquiriesDTO;
import com.autcion.auction_back.EditPage.domain.NoticeDTO;

@Service
public class SupportManageService {

    @Autowired
    private AdminAuthenticationService adminAuthenticationService;

    @Autowired
    private SupportManageMapper supportManageMapper;

    // 문의사항 조회 (권한 체크 포함)
    public List<Object> getInquries(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return supportManageMapper.getInquries();
    }

    // 문의사항 정보 수정 (권한 체크 포함)
    public void updateInquries(int userId, InquiriesDTO param) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        supportManageMapper.updateInquries(param);
    }

    // 공지사항 추가 (권한 체크 포함)
    public void insertNotice(int userId, NoticeDTO params) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        supportManageMapper.insertNotice(params);
    }

    // 공지사항 정보 수정 (권한 체크 포함)
    public void updateNotice(int userId, NoticeDTO param) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        supportManageMapper.updateNotice(param);
    }

    // 공지사항 삭제 (권한 체크 포함)
    public void deleteNotice(int userId, NoticeDTO param) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        supportManageMapper.deleteNotice(param);
    }

    // FAQ 추가 (권한 체크 포함)
    public void insertFaq(int userId, FaqDTO params) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        supportManageMapper.insertFaq(params);
    }

    // FAQ 정보 수정 (권한 체크 포함)
    public void updateFaq(int userId, FaqDTO param) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        supportManageMapper.updateFaq(param);
    }

    // FAQ 삭제 (권한 체크 포함)
    public void deleteFaq(int userId, FaqDTO param) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        supportManageMapper.deleteFaq(param);
    }

}