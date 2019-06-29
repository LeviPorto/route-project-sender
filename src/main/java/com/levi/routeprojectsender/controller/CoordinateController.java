package com.levi.routeprojectsender.controller;

import com.levi.routeprojectsender.api.dto.CoordinateDto;
import com.levi.routeprojectsender.service.CoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;

@RestController
@RequestMapping("/routeProjectSender/coordinate/send")
@CrossOrigin(origins = "*")
public class CoordinateController {

    private final CoordinateService coordinateService;

    @Autowired
    public CoordinateController(final CoordinateService coordinateService){
        this.coordinateService = coordinateService;
    }

    @PostMapping("/feign")
    public CoordinateDto sendUsingFeign(@Valid @RequestBody CoordinateDto coordinateDto, HttpServletRequest request) {
        return coordinateService.sendUsingFeign(coordinateDto, request);
    }

    @PostMapping("/kafka")
    public CoordinateDto sendUsingKafka(@Valid @RequestBody CoordinateDto coordinateDto) throws ParseException {
        return coordinateService.sendUsingKafka(coordinateDto);
    }

}
