package com.oauth.oauthdemo.config.handler;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.oauth.oauthdemo.domain.OauthUserEntity;
import com.oauth.oauthdemo.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class SuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

    @Autowired
    private UserService userService ;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        System.out.println("debug >>>> SuccessHandler onAuthenticationSuccess ");
        
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        System.out.println("debug >>>> SuccessHandler OAuth2AuthenticationToken " + token);

        String email = null;
        String oauthType = token.getAuthorizedClientRegistrationId();
        System.out.println("debug >>>> SuccessHandler oauthType " + oauthType);

        if("kakao".equalsIgnoreCase(oauthType.toLowerCase())) {
            email = ((Map<String, Object>)token.getPrincipal().getAttribute("kakao_account")).get("email").toString();
            System.out.println("debug >>> UserService email, oauthType " + email + "\t" + oauthType);

        } else if("naver".equalsIgnoreCase(oauthType.toLowerCase())) {
            Map<String, Object> result = (Map<String, Object>)token.getPrincipal().getAttribute("response");
            email = result.get("email").toString();
            System.out.println("debug >>> UserService email, oauthType " + email + "\t" + oauthType);

        } else if("google".equalsIgnoreCase(oauthType.toLowerCase())){
            email = token.getPrincipal().getAttribute("email");
            System.out.println("debug >>> UserService email, oauthType " + email + "\t" + oauthType);
        }

        OauthUserEntity user = userService.getUserByEmailAndType(email, oauthType);
        System.out.println("debug >>>> SuccessHandler Save Session");

        HttpSession session = request.getSession();
        session.setAttribute("userSession", user);
        
        System.out.println("debug >>>> SuccessHandler Save Session " + user);

	String redirectUrl = "http://35.216.107.206/confirm";
        //String redirectUrl = "http://localhost/confirm";
        System.out.println("debug >>>> redirectUrl " + redirectUrl);
        response.sendRedirect(redirectUrl);

    }
    
}
