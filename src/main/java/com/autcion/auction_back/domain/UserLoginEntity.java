package com.autcion.auction_back.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Getter
public class UserLoginEntity {

    @Id
    @Column(name = "login_id")
    private String loginId;

    @Column(name = "password")
    private String password;
    
}
