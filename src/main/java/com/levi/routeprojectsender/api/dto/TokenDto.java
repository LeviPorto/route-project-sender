package com.levi.routeprojectsender.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenDto implements Serializable {

    private Long id;
    private String token;

    public TokenDto() {

    }

}
