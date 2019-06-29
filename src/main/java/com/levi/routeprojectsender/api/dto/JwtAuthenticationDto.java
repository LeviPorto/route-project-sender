package com.levi.routeprojectsender.api.dto;

import lombok.Data;

@Data
public class JwtAuthenticationDto {

    private String username;
    private String password;

    public JwtAuthenticationDto() {

    }

}
