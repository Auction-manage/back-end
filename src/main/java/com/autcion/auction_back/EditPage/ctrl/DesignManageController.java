package com.autcion.auction_back.EditPage.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autcion.auction_back.EditPage.domain.BannerDTO;
import com.autcion.auction_back.EditPage.domain.ThemeDTO;
import com.autcion.auction_back.EditPage.service.DesignManageService;

@RestController
@RequestMapping("/manage/design")
public class DesignManageController {

    @Autowired
    private DesignManageService designManageService;

    // 테마 수정
    @PatchMapping("/theme")
    public ResponseEntity<Map<String, Object>> updateTheme(@RequestBody ThemeDTO param) {
        System.out.println("client endpoint : /manage/theme/update");
        System.out.println("debug >>> updatetheme + " + param);

        // auth를 통하여 정보가 있는지 확인
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Unauthorized");
            response.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        //auth 에서 회원정보(로그인아이디, 유저아이디, 닉네임) 추출
        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();
        System.out.println("debug >>> userInfo + " + userInfo);

        //userId에 해당하는 정보 추출
        int user_id = (int) userInfo.get("userId");

        Map<String, Object> response = new HashMap<>();
        try {
            // 서비스에서 권한 체크 및 테마 업데이트 수행
            designManageService.updateTheme(user_id, param);
            response.put("status", "success");
            response.put("message", "Theme updated successfully");
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to update theme: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 배너 정보 수정
    @PatchMapping("/banner")
    public ResponseEntity<Map<String, Object>> updateBanner(@RequestBody BannerDTO param) {
        System.out.println("client endpoint : /manage/banner/update");
        System.out.println("debug >>> updatebanner + " + param);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Unauthorized");
            response.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();
        System.out.println("debug >>> userInfo + " + userInfo);

        int user_id = (int) userInfo.get("userId");

        Map<String, Object> response = new HashMap<>();
        try {
            // 서비스에서 권한 체크 및 배너 업데이트 수행
            designManageService.updateBanner(user_id, param);
            response.put("status", "success");
            response.put("message", "Banner updated successfully");
            return ResponseEntity.ok(response);
        } catch (AccessDeniedException e) {
            response.put("error", "Forbidden");
            response.put("message", "Admin access required");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            response.put("message", "Failed to update banner: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}