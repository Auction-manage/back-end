package com.autcion.auction_back.dao;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autcion.auction_back.domain.UserRegisterEntity;

@Repository
public interface UserResisterRepository extends JpaRepository<UserRegisterEntity, Integer> {
    public Optional<UserRegisterEntity> findByUserId(int userId);
    public Optional<UserRegisterEntity> findByLoginId(String loginId);
    public Optional<UserRegisterEntity> findByPassword(String password);
    public Optional<UserRegisterEntity> findByName(String name);
    public Optional<UserRegisterEntity> findByNickname(String nickname);
    public Optional<UserRegisterEntity> findByEmail(String email);
    public Optional<UserRegisterEntity> findByPhone(String phone);
    public Optional<UserRegisterEntity> findByAddress(String address);
    public Optional<UserRegisterEntity> findByCreatedAt(LocalDateTime createdAt);
    public Optional<UserRegisterEntity> findByUpdatedAt(LocalDateTime updatedAt);
}
