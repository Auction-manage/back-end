package com.autcion.auction_back.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "oauth_entity_tbl")
@Getter
public class OauthUserEntity {

    @Id
    @Column(name = "email", columnDefinition = "VARCHAR(100)", nullable = true)
    private String email;

    @Column(name = "oauth_type", columnDefinition = "VARCHAR(50)")
    private String oauthType;
}
