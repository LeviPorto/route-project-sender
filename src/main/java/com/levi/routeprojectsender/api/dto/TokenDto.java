package com.levi.routeprojectsender.api.dto;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("TokenDto")
public class TokenDto implements Serializable {

    private Long id;
    private String token;

    public TokenDto() {
    }

    public TokenDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
