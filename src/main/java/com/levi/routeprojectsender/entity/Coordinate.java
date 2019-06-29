package com.levi.routeprojectsender.entity;

import com.levi.routeprojectsender.api.dto.CoordinateDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Coordinate {

    private Long id;
    private double lat;
    private double lng;
    private Date instant;
    private Long vehicleId;

    public Coordinate() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Date getInstant() {
        return instant;
    }

    public void setInstant(Date instant) {
        this.instant = instant;
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
