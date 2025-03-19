package com.autcion.auction_back.UsersPage.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.UsersPage.dao.ProfileDao;
import com.autcion.auction_back.UsersPage.dao.UsersMapper;
import com.autcion.auction_back.UsersPage.domain.LoginDto;
import com.autcion.auction_back.UsersPage.util.JwtUtil;

@Service
public class LoginService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Map<String, String> login(LoginDto loginDto) {
        System.out.println("Login service start - " + loginDto);
        
        Map<String, String> response = new HashMap<>();
        
        try {
            // 1. 입력값 검증
            if (loginDto.getLoginId() == null || loginDto.getPassword() == null) {
                response.put("status", "fail ");
                response.put("message", "Invalid input ");
                return response;
            }
            System.out.println("debug >>>> login_id " + loginDto.getLoginId());
            System.out.println("debug >>>> password " + loginDto.getPassword());
            // 2. 사용자 정보 조회
            ProfileDao user = usersMapper.profileRow(loginDto.getLoginId());
            System.out.println("debug >>>> loginService login - " + user);

            
            if (user != null && passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
                // 4. 인증 성공 시에만 토큰 생성
                String token = jwtUtil.createToken(
                    user.getLoginId(),
                    user.getUserId(),
                    user.getNickname()
                    );
                response.put("status", "success");
                response.put("token", token);
                
                System.out.println("Login success for user: " + loginDto.getLoginId());
            } else {
                response.put("status", "fail");
                response.put("message", "Invalid credentials");
                
                System.out.println("Login failed attempt for user: " + loginDto.getLoginId());
            }
            
        } catch (Exception e) {
            // 예외 처리
            response.put("status", "error");
            response.put("message", "Internal server error");
            System.err.println("Login error: " + e.getMessage());
        }
        
        return response;
    }

}