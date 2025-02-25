package com.oauth.oauthdemo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.oauth.oauthdemo.dao.OauthRepository;
import com.oauth.oauthdemo.domain.OauthUserEntity;

@Service
public class UserService extends DefaultOAuth2UserService {

    @Autowired
    private OauthRepository oauthRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("debug >>>> UserService loadUser userRequest " +userRequest);

        // email, ouathType 호출
	System.out.println("debug >>>> UserService ");
        Map<String, Object> attribute = super.loadUser(userRequest).getAttributes();
        System.out.println("debug >>>> UserService attribute" + attribute.toString());

        String email = null;
        String oauthType = userRequest.getClientRegistration().getRegistrationId();
        System.out.println("debug >>>> UserService oauthType" + oauthType);

        OAuth2User user = super.loadUser(userRequest);

        if("kakao".equalsIgnoreCase(oauthType.toLowerCase())) {
            email = ((Map<String, Object>)attribute.get("kakao_account")).get("email").toString();
            System.out.println("debug >>>> UserService kakao email" + email);

        } else if("naver".equalsIgnoreCase(oauthType.toLowerCase())) {
            Map<String, Object> response = (Map<String, Object>) attribute.get("response");
            email = response.get("email").toString();
            System.out.println("debug >>> UserService email, oauthType " + email + "\t" + oauthType);
            
        } else if ("google".equalsIgnoreCase(oauthType.toLowerCase())) {
            email = attribute.get("email").toString();
            System.out.println("debug >>>> UserService google email" + email);
        }

        // User 존재 여부 확인 및 없으면 생성
        if(getUserByEmailAndType(email, oauthType) == null) {
            System.out.println("debug >>>> User Not Register ");
            OauthUserEntity entity = OauthUserEntity.builder()
                                        .email(email)
                                        .oauthType(oauthType)
                                        .build();
            oauthRepository.save(entity);
        } 
        return super.loadUser(userRequest);
    }

    public OauthUserEntity getUserByEmailAndType(String email, String oauthType) {
        System.out.println("debug >>>> UserService getUserByEmailAndType");
        return oauthRepository.findByEmailAndOauthType(email, oauthType).orElse(null);
    }
}
