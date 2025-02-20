package com.autcion.auction_back.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.autcion.auction_back.config.handler.FailureHandler;
import com.autcion.auction_back.config.handler.SuccessHandler;
import com.autcion.auction_back.service.UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final SuccessHandler successHandler;
    private final FailureHandler failureHandler;
    private final UserService userService; 

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        System.out.println("Debug >>> SecurityConfig");
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/", "/login/**", "/WEB-INF/**").permitAll()
                    .anyRequest().authenticated())
                .oauth2Login(oauth -> oauth
                                        .loginPage("/login")
                                        .successHandler(successHandler)
                                        .failureHandler(failureHandler)
                                        .userInfoEndpoint(user -> user.userService(userService)))
                .build();
    }
}