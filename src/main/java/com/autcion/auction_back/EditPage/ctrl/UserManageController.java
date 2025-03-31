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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autcion.auction_back.EditPage.domain.BuyerRankDTO;
import com.autcion.auction_back.EditPage.domain.EmailDTO;
import com.autcion.auction_back.EditPage.domain.SellerRankDTO;
import com.autcion.auction_back.EditPage.domain.UserDTO;
import com.autcion.auction_back.EditPage.service.UserManageService;
import com.autcion.auction_back.MainPage.domain.MileageDTO;

@RestController
@RequestMapping("/manage/user")
public class UserManageController {

    @Autowired
    private UserManageService userManageService;

    // 전체 회원 정보 조회
    @GetMapping("/userList")
    public ResponseEntity<Map<String, Object>> getUserList() {
        System.err.println("client endpoint : /manage/userList");

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
            List<UserDTO> userList = userManageService.getUserList(user_id);
            response.put("status", "success");
            response.put("data", userList);
            response.put("totalCount", userList.size()); // 메타데이터 추가
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve user list: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 회원 정보 수정
    @PatchMapping("/userList/update")
    public ResponseEntity<Map<String, Object>> updateUserList(@RequestBody UserDTO param) {
        System.out.println("client endpoint : /manage/userList/update");
        System.out.println("debug >>> updateUserList + " + param);

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
            userManageService.updateUserList(user_id, param);
            response.put("status", "success");
            response.put("message", "User list updated successfully");
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to update user list: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 구매자 등급 목록 조회
    @GetMapping("/rankList1")
    public ResponseEntity<Map<String, Object>> getRankList1() {
        System.err.println("client endpoint : /manage/rankList1");

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
            List<Object> rankList = userManageService.getRankList1(user_id);
            response.put("status", "success");
            response.put("data", rankList);
            response.put("totalCount", rankList.size()); // 메타데이터 추가
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve buyer rank list: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 판매자 등급 목록 조회
    @GetMapping("/rankList2")
    public ResponseEntity<Map<String, Object>> getRankList2() {
        System.err.println("client endpoint : /manage/rankList2");

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
            List<Object> rankList = userManageService.getRankList2(user_id);
            response.put("status", "success");
            response.put("data", rankList);
            response.put("totalCount", rankList.size()); // 메타데이터 추가
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve seller rank list: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 구매자 등급 정보 수정
    @PatchMapping("/rankList1/update")
    public ResponseEntity<Map<String, Object>> updateRankList1(@RequestBody BuyerRankDTO param) {
        System.out.println("client endpoint : /manage/rankList1/update");
        System.out.println("debug >>> updateRankList1 + " + param);

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
            userManageService.updateRankList1(user_id, param);
            response.put("status", "success");
            response.put("message", "Buyer rank list updated successfully");
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to update buyer rank list: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 판매자 등급 정보 수정
    @PatchMapping("/rankList2/update")
    public ResponseEntity<Map<String, Object>> updateRankList2(@RequestBody SellerRankDTO param) {
        System.out.println("client endpoint : /manage/rankList2/update");
        System.out.println("debug >>> updateRankList2 + " + param);

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
            userManageService.updateRankList2(user_id, param);
            response.put("status", "success");
            response.put("message", "Seller rank list updated successfully");
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to update seller rank list: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 이메일 전송
    @PostMapping("/send-emails")
    public ResponseEntity<Map<String, Object>> sendEmails(@RequestBody EmailDTO params) {
        System.out.println("client endpoint : /manage/send-emails");
        System.out.println("debug >>> sendEmails + " + params);

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
            userManageService.sendEmails(user_id, params);
            response.put("status", "success");
            response.put("message", "Emails sent successfully");
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to send emails: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 포인트 내역 전체 조회
    @GetMapping("/Allpoints")
    public ResponseEntity<Map<String, Object>> getAllPoints() {
        System.err.println("client endpoint : /manage/getAllpoints");

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
            List<Object> allPoints = userManageService.getAllPoints(user_id);
            response.put("status", "success");
            response.put("data", allPoints);
            response.put("totalCount", allPoints.size()); // 메타데이터 추가
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve all points: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 포인트 추가
    @PostMapping("/insertMileage")
    public ResponseEntity<Map<String, Object>> insertMileage(@RequestBody MileageDTO params) {
        System.out.println("client endpoint : /manage/insertMileage");
        System.out.println("debug >>> insertMileage + " + params);

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
            userManageService.insertMileage(user_id, params);
            response.put("status", "success");
            response.put("message", "Mileage inserted successfully");
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to insert mileage: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /*
    // 월별 통계 조회 추가
    @PostMapping("/Monthstatistics")
    public ResponseEntity<Map<String, Object>> insertMonthStatistics(@RequestBody MonthStatisticsDTO params) {
        System.out.println("client endpoint : /manage/Monthstatistics");
        System.out.println("debug >>> insertMonthstatistics + " + params);

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
            userManageService.insertMonthStatistics(user_id, params);
            response.put("status", "success");
            response.put("message", "Monthly statistics inserted successfully");
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to insert monthly statistics: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 일별 통계 조회 추가
    @PostMapping("/Daystatistics")
    public ResponseEntity<Map<String, Object>> insertDayStatistics(@RequestBody DayStatisticsDTO params) {
        System.out.println("client endpoint : /manage/Daystatistics");
        System.out.println("debug >>> insertDaystatistics + " + params);

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
            userManageService.insertDayStatistics(user_id, params);
            response.put("status", "success");
            response.put("message", "Daily statistics inserted successfully");
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to insert daily statistics: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
        */
}