package com.levi.routeprojectsender.service;

import com.levi.routeprojectsender.api.RouteProjectProcessorApi;
import com.levi.routeprojectsender.api.dto.JwtAuthenticationDto;
import com.levi.routeprojectsender.api.dto.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final RouteProjectProcessorApi routeProjectProcessorApi;

    @Autowired
    public AuthenticationService(final RouteProjectProcessorApi routeProjectProcessorApi){
        this.routeProjectProcessorApi = routeProjectProcessorApi;
    }

    public TokenDto authenticate(JwtAuthenticationDto authenticationDto) {
        return routeProjectProcessorApi.auth(authenticationDto);
    }

}
