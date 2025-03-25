package com.autcion.auction_back.EditPage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.EditPage.dao.HomeManageMapper;

@Service
public class HomeManageService {

    @Autowired
    private AdminAuthenticationService adminAuthenticationService;

    @Autowired
    private HomeManageMapper homeManageMapper;

    // 전체 거래 수 조회 (권한 체크 포함)
    public int getTradeCount(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return homeManageMapper.getTradeCount();
    }

    // 입금대기 거래 수 조회 (권한 체크 포함)
    public int getDepositWaitCount(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return homeManageMapper.getDepositWaitCount();
    }

    // 입금완료 거래 수 조회 (권한 체크 포함)
    public int getDepositCount(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return homeManageMapper.getDepositCount();
    }

    // 배송 준비 거래 수 조회 (권한 체크 포함)
    public int getDeliveryWaitCount(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return homeManageMapper.getDeliveryWaitCount();
    }

    // 배송 중 거래 수 조회 (권한 체크 포함)
    public int getDeliveringCount(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return homeManageMapper.getDeliveringCount();
    }

    // 배송 완료 거래 수 조회 (권한 체크 포함)
    public int getDeliveryEndCount(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return homeManageMapper.getDeliveryEndCount();
    }

    // 취소 거래 수 조회 (권한 체크 포함)
    public int getCancelCount(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return homeManageMapper.getCancelCount();
    }

    // 환불 거래 수 조회 (권한 체크 포함)
    public int getRefundCount(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return homeManageMapper.getRefundCount();
    }

    // 반품 거래 수 조회 (권한 체크 포함)
    public int getReturnCount(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return homeManageMapper.getReturnCount();
    }

    // 현재 거래내역 5개 조회 (권한 체크 포함)
    public List<Object> getRecentTrade(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return homeManageMapper.getRecentTrade();
    }

}