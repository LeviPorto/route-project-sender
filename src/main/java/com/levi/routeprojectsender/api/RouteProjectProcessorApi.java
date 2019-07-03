package com.levi.routeprojectsender.api;

import com.levi.routeprojectsender.api.dto.CoordinateDto;
import com.levi.routeprojectsender.api.dto.JwtAuthenticationDto;
import com.levi.routeprojectsender.api.dto.TokenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${feign.api.route-project}")
public interface RouteProjectProcessorApi {

    @RequestMapping(method = RequestMethod.POST, value = "/routeProcessor/coordinate")
    CoordinateDto sendCoordinate(@RequestHeader("Authorization") String token, CoordinateDto coordinateDto);

    @PostMapping(value = "/auth")
    TokenDto auth(JwtAuthenticationDto authenticationDto);

}
