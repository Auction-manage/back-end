package com.autcion.auction_back.EditPage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.EditPage.dao.ItemManageMapper;

@Service
public class ItemManageService {

    @Autowired
    private AdminAuthenticationService adminAuthenticationService;

    @Autowired ItemManageMapper itemManageMapper;

    // 전체 거래 리스트 조회 (권한 체크 포함)
    public List<Object> getAllTrade(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return itemManageMapper.getAllTrade();
    }

    // 입금대기 거래 리스트 조회 (권한 체크 포함)
    public List<Object> getwaitTrade(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return itemManageMapper.getwaitTrade();
    }

    // 입금완료 거래 리스트 조회 (권한 체크 포함)
    public List<Object> getDepositTrade(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return itemManageMapper.getDepositTrade();
    }

    // 배송준비 거래 리스트 조회 (권한 체크 포함)
    public List<Object> getDeliveryWaitTrade(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return itemManageMapper.getDeliveryWaitTrade();
    }

    // 배송 중 거래 리스트 조회 (권한 체크 포함)
    public List<Object> getDeliveringTrade(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return itemManageMapper.getDeliveringTrade();
    }

    // 배송 완료 거래 리스트 조회 (권한 체크 포함)
    public List<Object> getDeliveryEndTrade(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return itemManageMapper.getDeliveryEndTrade();
    }

    // 취소 거래 리스트 조회 (권한 체크 포함)
    public List<Object> getcancelTrade(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return itemManageMapper.getcancelTrade();
    }

    // 환불 거래 리스트 조회 (권한 체크 포함)
    public List<Object> getrefundTrade(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return itemManageMapper.getrefundTrade();
    }

    // 반품 거래 리스트 조회 (권한 체크 포함)
    public List<Object> getreturnTrade(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return itemManageMapper.getreturnTrade();
    }

}