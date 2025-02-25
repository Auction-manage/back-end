package com.oauth.oauthdemo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oauth.oauthdemo.domain.UserLoginEntity;


public interface UserLoginRepository extends JpaRepository<UserLoginEntity, String> {

    Optional<UserLoginEntity> findByUsername(String username);
    
}
