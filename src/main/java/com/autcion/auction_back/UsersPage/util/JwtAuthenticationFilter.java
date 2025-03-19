package com.autcion.auction_back.UsersPage.util;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.FilterChain;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;

    // JwtUtil 주입
    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // 모든 요청에 대해 필터 적용
    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        System.out.println("jwt 필터 적용");
        // 요청 헤더에서 토큰 추출
        String token = resolveToken(request);
        System.out.println("토큰 추출" + token);

        // 토큰이 존재하고 유효한 경우
        if (token != null && jwtUtil.validateToken(token)) {
            System.out.println("유효한 토큰");
            // 토큰에서 사용자 ID 추출
            String loginId = jwtUtil.getLoginIdFromToken(token);
            // 인증 객체 생성
            Authentication authentication = new UsernamePasswordAuthenticationToken(loginId, null, new ArrayList<>());
            // SecurityContext에 인증 정보 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // 다음 필터로 요청 전달
        filterChain.doFilter(request, response);
    }

    // Authorization 헤더에서 토큰 추출
    private String resolveToken(HttpServletRequest request) {
        System.out.println("토큰 추출 시작");
        String bearerToken = request.getHeader("Authorization");
        System.out.println("토큰 추출 완료" + bearerToken);
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // "Bearer " 제거
        }
        return null;
    }
}