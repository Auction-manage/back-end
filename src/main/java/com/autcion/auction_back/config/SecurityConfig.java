package com.autcion.auction_back.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.autcion.auction_back.UsersPage.service.UserService;
import com.autcion.auction_back.UsersPage.util.JwtAuthenticationFilter;
import com.autcion.auction_back.config.handler.FailureHandler;
import com.autcion.auction_back.config.handler.SuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final FailureHandler failureHandler;
    private final SuccessHandler successHandler;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserService userService;

    @Autowired  // 생성자 주입 추가
    public SecurityConfig(
            FailureHandler failureHandler,
            SuccessHandler successHandler,
            JwtAuthenticationFilter jwtAuthenticationFilter,
            UserService userService) {
        this.failureHandler = failureHandler;
        this.successHandler = successHandler;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(cors -> cors  // 수정된 CORS 설정
                    .configurationSource(corsConfigurationSource())
                )
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                    // 인증없이 접근 가능한 경로 설정
                    .requestMatchers("/*", "/login/**", "loginProc", "/register", "/recover/**", "/auction/**", "/virtualmarket/**").permitAll()
                    // 그 외 모든 요청은 인증 필요
                    .anyRequest().authenticated())
                .formLogin(form -> form
                    .loginPage("/login")
                    // .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/profile")
                    // .failureUrl("/login")
                    .permitAll()
                )
                // JWT 인증 필터 추가
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                // OAuth2 로그인 설정
                .oauth2Login(oauth -> oauth
                    .successHandler(successHandler)
                    .failureHandler(failureHandler)
                    .userInfoEndpoint(user -> user
                        .userService(userService)
                    )
                    .disable())
                .build();
    }

    // CORS 설정
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // 허용할 오리진(도메인) 설정
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        // 허용할 HTTP 메서드 설정
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        // 허용할 헤더 설정
        configuration.setAllowedHeaders(Arrays.asList("*"));
        // 인증 정보 포함 허용
        configuration.setAllowCredentials(true);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}