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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autcion.auction_back.EditPage.domain.FaqDTO;
import com.autcion.auction_back.EditPage.domain.InquiriesDTO;
import com.autcion.auction_back.EditPage.domain.NoticeDTO;
import com.autcion.auction_back.EditPage.service.SupportManageService;

@RestController
@RequestMapping("/manage/home")
public class SupportManageController {

    @Autowired
    private SupportManageService supportManageService;

    // 문의사항 조회
    @GetMapping("/inquries")
    public ResponseEntity<Map<String, Object>> getInquries() {
        System.err.println("client endpoint : /manage/getinquries");

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
            List<Object> inquiries = supportManageService.getInquries(user_id);
            response.put("status", "success");
            response.put("data", inquiries);
            response.put("totalCount", inquiries.size()); // 메타데이터 추가
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to retrieve inquiries: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 문의사항 정보 수정
    @PatchMapping("/inquries/update")
    public ResponseEntity<Map<String, Object>> updateInquries(@RequestBody InquiriesDTO param) {
        System.out.println("client endpoint : /manage/inquries/update");
        System.out.println("debug >>> updateinquries + " + param);

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
            supportManageService.updateInquries(user_id, param);
            response.put("status", "success");
            response.put("message", "Inquiries updated successfully");
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to update inquiries: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 공지사항 추가
    @PostMapping("/notice")
    public ResponseEntity<Map<String, Object>> insertNotice(@RequestBody NoticeDTO params) {
        System.out.println("client endpoint : /manage/notice");
        System.out.println("debug >>> insertnotice + " + params);

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
            supportManageService.insertNotice(user_id, params);
            response.put("status", "success");
            response.put("message", "Notice inserted successfully");
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to insert notice: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 공지사항 정보 수정
    @PatchMapping("/notice/update")
    public ResponseEntity<Map<String, Object>> updateNotice(@RequestBody NoticeDTO param) {
        System.out.println("client endpoint : /manage/notice/update");
        System.out.println("debug >>> updatenotice + " + param);

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
            supportManageService.updateNotice(user_id, param);
            response.put("status", "success");
            response.put("message", "Notice updated successfully");
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to update notice: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 공지사항 삭제
    @DeleteMapping("/notice/delete")
    public ResponseEntity<Map<String, Object>> deleteNotice(@RequestBody NoticeDTO param) {
        System.out.println("client endpoint : /manage/notice/delete");
        System.out.println("debug >>> deletenotice + " + param);

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
            supportManageService.deleteNotice(user_id, param);
            response.put("status", "success");
            response.put("message", "Notice deleted successfully");
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to delete notice: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // FAQ 추가
    @PostMapping("/faq")
    public ResponseEntity<Map<String, Object>> insertFaq(@RequestBody FaqDTO params) {
        System.out.println("client endpoint : /manage/faq");
        System.out.println("debug >>> insertfaq + " + params);

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
            supportManageService.insertFaq(user_id, params);
            response.put("status", "success");
            response.put("message", "FAQ inserted successfully");
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to insert FAQ: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // FAQ 정보 수정
    @PatchMapping("/faq/update")
    public ResponseEntity<Map<String, Object>> updateFaq(@RequestBody FaqDTO param) {
        System.out.println("client endpoint : /manage/faq/update");
        System.out.println("debug >>> updatefaq + " + param);

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
            supportManageService.updateFaq(user_id, param);
            response.put("status", "success");
            response.put("message", "FAQ updated successfully");
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to update FAQ: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // FAQ 삭제
    @DeleteMapping("/faq/delete")
    public ResponseEntity<Map<String, Object>> deleteFaq(@RequestBody FaqDTO param) {
        System.out.println("client endpoint : /manage/faq/delete");
        System.out.println("debug >>> deletefaq + " + param);

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
            supportManageService.deleteFaq(user_id, param);
            response.put("status", "success");
            response.put("message", "FAQ deleted successfully");
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to delete FAQ: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}