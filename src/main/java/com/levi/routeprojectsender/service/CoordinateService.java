package com.levi.routeprojectsender.service;

import com.levi.routeprojectsender.api.RouteProjectProcessorApi;
import com.levi.routeprojectsender.api.dto.CoordinateDto;
import com.levi.routeprojectsender.entity.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@Service
public class CoordinateService {

    private final RouteProjectProcessorApi routeProjectProcessorApi;
    private final KafkaTemplate<String, Coordinate> kafkaTemplate;

    @Value("${spring.kafka.topic.coordinate}")
    public String topicCoordinate;

    @Autowired
    public CoordinateService(final RouteProjectProcessorApi routeProjectProcessorApi, final KafkaTemplate<String, Coordinate> kafkaTemplate){
        this.routeProjectProcessorApi = routeProjectProcessorApi;
        this.kafkaTemplate = kafkaTemplate;
    }

    public CoordinateDto sendUsingFeign(CoordinateDto coordinateDto, HttpServletRequest request) {
        return routeProjectProcessorApi.sendCoordinate(request.getHeader(HttpHeaders.AUTHORIZATION), coordinateDto);
    }

    public CoordinateDto sendUsingKafka(CoordinateDto coordinateDto) throws ParseException {
        Message<Coordinate> message = MessageBuilder
                .withPayload(Coordinate.fromDto(coordinateDto))
                .setHeader(KafkaHeaders.TOPIC, topicCoordinate)
                .build();
        kafkaTemplate.send(message);
        return coordinateDto;
    }

}
