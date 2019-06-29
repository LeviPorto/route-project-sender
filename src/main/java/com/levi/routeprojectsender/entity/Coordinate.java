package com.levi.routeprojectsender.entity;

import com.levi.routeprojectsender.api.dto.CoordinateDto;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Coordinate {

    private Long id;
    private double lat;
    private double lng;
    private Date instant;
    private Long vehicleId;

    public Coordinate() {

    }

    public static Coordinate fromDto(CoordinateDto coordinateDto) throws ParseException {
        Coordinate coordinate = new Coordinate();

        coordinate.setInstant(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(coordinateDto.getInstant()));
        coordinate.setLat(Double.valueOf(coordinateDto.getLat()));
        coordinate.setLng(Double.valueOf(coordinateDto.getLng()));
        coordinate.setVehicleId(Long.valueOf(coordinateDto.getVehicleId()));

        return coordinate;
    }

}
