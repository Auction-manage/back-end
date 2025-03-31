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

import com.autcion.auction_back.EditPage.service.ItemManageService;


@RestController
@RequestMapping("/manage/item")
public class ItemManageController {

    @Autowired
    private ItemManageService itemManageService;

    // 전체 거래 리스트 조회
    @GetMapping("/AllTrade")
    public ResponseEntity<Map<String, Object>> getAllTrade() {
        System.err.println("client endpoint : /manage/getAllTrade");

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
            List<Object> allTrades = itemManageService.getAllTrade(user_id);
            response.put("status", "success");
            response.put("data", allTrades);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve all trades: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 입금대기 거래 리스트 조회
    @GetMapping("/waitTrade")
    public ResponseEntity<Map<String, Object>> getwaitTrade() {
        System.err.println("client endpoint : /manage/getwaitTrade");

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
            List<Object> waitTrades = itemManageService.getwaitTrade(user_id);
            response.put("status", "success");
            response.put("data", waitTrades);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve wait trades: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 입금완료 거래 리스트 조회
    @GetMapping("/DepositTrade")
    public ResponseEntity<Map<String, Object>> getDepositTrade() {
        System.err.println("client endpoint : /manage/getDepositTrade");

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
            List<Object> depositTrades = itemManageService.getDepositTrade(user_id);
            response.put("status", "success");
            response.put("data", depositTrades);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve deposit trades: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 배송준비 거래 리스트 조회
    @GetMapping("/DeliveryWaitTrade")
    public ResponseEntity<Map<String, Object>> getDeliveryWaitTrade() {
        System.err.println("client endpoint : /manage/getDeliveryWaitTrade");

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
            List<Object> deliveryWaitTrades = itemManageService.getDeliveryWaitTrade(user_id);
            response.put("status", "success");
            response.put("data", deliveryWaitTrades);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve delivery wait trades: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 배송 중 거래 리스트 조회
    @GetMapping("/DeliveringTrade")
    public ResponseEntity<Map<String, Object>> getDeliveringTrade() {
        System.err.println("client endpoint : /manage/getDeliveringTrade");

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
            List<Object> deliveringTrades = itemManageService.getDeliveringTrade(user_id);
            response.put("status", "success");
            response.put("data", deliveringTrades);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve delivering trades: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 배송 완료 거래 리스트 조회
    @GetMapping("/DeliveryEndTrade")
    public ResponseEntity<Map<String, Object>> getDeliveryEndTrade() {
        System.err.println("client endpoint : /manage/getDeliveryEndTrade");

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
            List<Object> deliveryEndTrades = itemManageService.getDeliveryEndTrade(user_id);
            response.put("status", "success");
            response.put("data", deliveryEndTrades);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve delivery end trades: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 취소 거래 리스트 조회
    @GetMapping("/cancelTrade")
    public ResponseEntity<Map<String, Object>> getcancelTrade() {
        System.err.println("client endpoint : /manage/getcancelTrade");

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
            List<Object> cancelTrades = itemManageService.getcancelTrade(user_id);
            response.put("status", "success");
            response.put("data", cancelTrades);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve cancel trades: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 환불 거래 리스트 조회
    @GetMapping("/refundTrade")
    public ResponseEntity<Map<String, Object>> getrefundTrade() {
        System.err.println("client endpoint : /manage/getrefundTrade");

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
            List<Object> refundTrades = itemManageService.getrefundTrade(user_id);
            response.put("status", "success");
            response.put("data", refundTrades);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve refund trades: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 반품 거래 리스트 조회
    @GetMapping("/returnTrade")
    public ResponseEntity<Map<String, Object>> getreturnTrade() {
        System.err.println("client endpoint : /manage/getreturnTrade");

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
            List<Object> returnTrades = itemManageService.getreturnTrade(user_id);
            response.put("status", "success");
            response.put("data", returnTrades);
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve return trades: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}