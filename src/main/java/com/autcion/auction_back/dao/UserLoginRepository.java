package com.autcion.auction_back.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autcion.auction_back.domain.UserLoginEntity;


public interface UserLoginRepository extends JpaRepository<UserLoginEntity, String> {

    Optional<UserLoginEntity> findByLoginId(String loginId);
    
}
