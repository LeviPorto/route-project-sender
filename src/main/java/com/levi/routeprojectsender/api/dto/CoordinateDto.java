package com.levi.routeprojectsender.api.dto;

import lombok.Data;

@Data
public class CoordinateDto {

    private String lat;
    private String lng;
    private String instant;
    private String vehicleId;

    public CoordinateDto(){

    }

}
