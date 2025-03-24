package com.autcion.auction_back.UsersPage.util;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    // application.properties에서 설정한 jwt.secret 값을 주입
    @Value("${jwt.secret}")
    private String secretKey;
    
    // 토큰 유효 시간 설정 (1시간) 테스트로 24시간
    private final long tokenValidityInMilliseconds = 86400 * 1000;

    // JWT 토큰 생성 메서드
    public String createToken(String loginId, int userId, String nickname) {

        System.out.println("jwt token 생성");
        // 토큰에 포함될 클레임(데이터) 설정
        Claims claims = Jwts.claims().setSubject(loginId);
        claims.put("userId", userId);
        claims.put("nickname", nickname);
        Date now = new Date();
        
        // 토큰 만료 시간 설정
        Date validity = new Date(now.getTime() + tokenValidityInMilliseconds);

        System.out.println("만료 시간" + validity);
        System.out.println("jwt token 생성 완료");
        // JWT 토큰 생성
        return Jwts.builder()
                .setClaims(claims)          // 클레임 정보 설정
                .setIssuedAt(now)           // 토큰 발행 시간
                .setExpiration(validity)     // 토큰 만료 시간
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256) // 비밀키로 서명
                .compact();

        
    }

    // 토큰에서 모든 클레임 추출 메서드
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 토큰에서 사용자 정보 추출 메서드
    public Map<String, Object> getInfoFromToken(String token) {
        System.out.println("jwt token 추출");
        Claims claims = extractAllClaims(token);
        Map<String, Object> info = new HashMap<>();
        info.put("loginId", claims.getSubject());
        info.put("userId", claims.get("userId"));
        info.put("nickname", claims.get("nickname"));
        return info;
    }

    // 토큰 유효성 검증 메서드
    public boolean validateToken(String token) {
        System.out.println("jwt token 유효성 검증");
        try {
            // 토큰 파싱 시도 - 성공하면 유효한 토큰
            Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("유효 하지 않은 토큰");
            // 파싱 실패시 유효하지 않은 토큰
            return false;
        }
    }
}