package com.levi.routeprojectsender.controller;
import com.levi.routeprojectsender.api.dto.TokenDto;
import com.levi.routeprojectsender.service.AuthenticationService;
import com.levi.routeprojectsender.api.dto.JwtAuthenticationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(final AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public TokenDto auth(@Valid @RequestBody JwtAuthenticationDto authenticationDto) {
        return authenticationService.authenticate(authenticationDto);
    }

}
