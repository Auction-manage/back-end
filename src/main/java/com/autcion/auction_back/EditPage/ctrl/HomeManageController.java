package com.autcion.auction_back.EditPage.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autcion.auction_back.EditPage.service.HomeManageService;


@RestController
@RequestMapping("/manage/home")
public class HomeManageController {

    @Autowired
    private HomeManageService homeManageService;

    // 전체 거래 수 조회
    @GetMapping("/tradecount")
    public ResponseEntity<Map<String, Object>> getTradeCount() {
        System.out.println("client endpoint : /manage/tradecount");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Unauthorized");
            response.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();
        int user_id = (int) userInfo.get("userId");

        Map<String, Object> response = new HashMap<>();
        try {
            int tradeCount = homeManageService.getTradeCount(user_id);
            response.put("status", "success");
            response.put("data", tradeCount);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve trade count: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 입금대기 거래 수 조회
    @GetMapping("/DepositWaitcount")
    public ResponseEntity<Map<String, Object>> getDepositWaitCount() {
        System.out.println("client endpoint : /manage/DepositWaitcount");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Unauthorized");
            response.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();
        int user_id = (int) userInfo.get("userId");

        Map<String, Object> response = new HashMap<>();
        try {
            int depositWaitCount = homeManageService.getDepositWaitCount(user_id);
            response.put("status", "success");
            response.put("data", depositWaitCount);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve deposit wait count: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 입금완료 거래 수 조회
    @GetMapping("/Depositcount")
    public ResponseEntity<Map<String, Object>> getDepositCount() {
        System.out.println("client endpoint : /manage/Depositcount");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Unauthorized");
            response.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();
        int user_id = (int) userInfo.get("userId");

        Map<String, Object> response = new HashMap<>();
        try {
            int depositCount = homeManageService.getDepositCount(user_id);
            response.put("status", "success");
            response.put("data", depositCount);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve deposit count: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 배송 준비 거래 수 조회
    @GetMapping("/DeliverytWaitcount")
    public ResponseEntity<Map<String, Object>> getDeliveryWaitCount() {
        System.out.println("client endpoint : /manage/DeliverytWaitcount");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Unauthorized");
            response.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();
        int user_id = (int) userInfo.get("userId");

        Map<String, Object> response = new HashMap<>();
        try {
            int deliveryWaitCount = homeManageService.getDeliveryWaitCount(user_id);
            response.put("status", "success");
            response.put("data", deliveryWaitCount);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve delivery wait count: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 배송 중 거래 수 조회
    @GetMapping("/Deliveringcount")
    public ResponseEntity<Map<String, Object>> getDeliveringCount() {
        System.out.println("client endpoint : /manage/Deliveringcount");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Unauthorized");
            response.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();
        int user_id = (int) userInfo.get("userId");

        Map<String, Object> response = new HashMap<>();
        try {
            int deliveringCount = homeManageService.getDeliveringCount(user_id);
            response.put("status", "success");
            response.put("data", deliveringCount);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve delivering count: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 배송 완료 거래 수 조회
    @GetMapping("/DeliveryEndcount")
    public ResponseEntity<Map<String, Object>> getDeliveryEndCount() {
        System.out.println("client endpoint : /manage/DeliveryEndcount");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Unauthorized");
            response.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();
        int user_id = (int) userInfo.get("userId");

        Map<String, Object> response = new HashMap<>();
        try {
            int deliveryEndCount = homeManageService.getDeliveryEndCount(user_id);
            response.put("status", "success");
            response.put("data", deliveryEndCount);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve delivery end count: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 취소 거래 수 조회
    @GetMapping("/Cancelcount")
    public ResponseEntity<Map<String, Object>> getCancelCount() {
        System.out.println("client endpoint : /manage/Cancelcount");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Unauthorized");
            response.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();
        int user_id = (int) userInfo.get("userId");

        Map<String, Object> response = new HashMap<>();
        try {
            int cancelCount = homeManageService.getCancelCount(user_id);
            response.put("status", "success");
            response.put("data", cancelCount);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve cancel count: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 환불 거래 수 조회
    @GetMapping("/Refundcount")
    public ResponseEntity<Map<String, Object>> getRefundCount() {
        System.out.println("client endpoint : /manage/Refundcount");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Unauthorized");
            response.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();
        int user_id = (int) userInfo.get("userId");

        Map<String, Object> response = new HashMap<>();
        try {
            int refundCount = homeManageService.getRefundCount(user_id);
            response.put("status", "success");
            response.put("data", refundCount);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve refund count: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 반품 거래 수 조회
    @GetMapping("/Returncount")
    public ResponseEntity<Map<String, Object>> getReturnCount() {
        System.out.println("client endpoint : /manage/Returncount");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Unauthorized");
            response.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();
        int user_id = (int) userInfo.get("userId");

        Map<String, Object> response = new HashMap<>();
        try {
            int returnCount = homeManageService.getReturnCount(user_id);
            response.put("status", "success");
            response.put("data", returnCount);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve return count: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 현재 거래내역 5개 조회
    @GetMapping("/recentTrade")
    public ResponseEntity<Map<String, Object>> getRecentTrade() {
        System.err.println("client endpoint : /manage/recentTrade");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Unauthorized");
            response.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();
        int user_id = (int) userInfo.get("userId");

        Map<String, Object> response = new HashMap<>();
        try {
            List<Object> recentTrades = homeManageService.getRecentTrade(user_id);
            response.put("status", "success");
            response.put("data", recentTrades);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve recent trades: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}