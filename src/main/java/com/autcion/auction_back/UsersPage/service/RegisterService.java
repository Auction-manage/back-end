package com.autcion.auction_back.UsersPage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.UsersPage.dao.UsersMapper;
import com.autcion.auction_back.UsersPage.domain.UserDataDto;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class RegisterService {


    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public String register(UserDataDto registerDto) {
        System.out.println("debug >>>> registerService register" + registerDto);

        try {

            String encodedPassword = passwordEncoder.encode(registerDto.getPassword());
            registerDto.setPassword(encodedPassword);

            System.out.println("debug >>>> registerService register" + registerDto);

            Integer result = usersMapper.registerRow(registerDto);
            System.out.println("Mapper result : " + result);
            return result > 0 ? "success" : "fail";
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
