package com.autcion.auction_back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.dao.UserResisterRepository;
import com.autcion.auction_back.domain.RegisterDto;
import com.autcion.auction_back.domain.UserRegisterEntity;

@Service
public class RegisterService {

    @Autowired
    private UserResisterRepository userResisterRepository;

    public String register(RegisterDto registerDto) {
        System.out.println("debug >>>> registerService ");

        UserRegisterEntity userRegisterEntity = UserRegisterEntity.builder()
            .loginId(registerDto.getLoginId())
            .password(registerDto.getPassword())
            .name(registerDto.getName())
            .nickname(registerDto.getNickname())
            .phone(registerDto.getPhone())
            .email(registerDto.getEmail())
            .address(registerDto.getAddress())
            .build();
        
        try {
            userResisterRepository.save(userRegisterEntity);
            System.out.println("debug >>>> registerService register success ");
            return "success";
        } catch (DataIntegrityViolationException dive) {
            System.out.println("debug >>>> registerService duplicate data error: " + dive.getMessage());
            return "duplicate_data_error";
        } catch (DataAccessException dae) {
            System.out.println("debug >>>> registerService database error: " + dae.getMessage());
            return "database_error";
        } catch (IllegalArgumentException iae) {
            System.out.println("debug >>>> registerService invalid argument: " + iae.getMessage());
            return "invalid_argument";
        } catch (Exception e) {
            System.out.println("debug >>>> registerService unknown error: " + e.getMessage());
            return "unknown_error";
        }
    }
}
