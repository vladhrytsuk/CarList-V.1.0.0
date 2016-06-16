package com.johnathanmsmith.mvc.web.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class CarDtoFactory {

    @Autowired
    CarList ct;

    public CarDtoFactory() {

    }

    public Car SerializerCar (CarDto carDto) {
        Car car = new Car();
        car.setId(UUID.randomUUID());
        car.setMark(carDto.getMark());
        car.setColor(carDto.getColor());
        car.setVin(carDto.getVin());
        car.setMiles(carDto.getMiles());
        return car;
    }

}
