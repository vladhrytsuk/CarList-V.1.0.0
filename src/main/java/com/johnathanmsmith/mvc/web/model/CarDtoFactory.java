package com.johnathanmsmith.mvc.web.model;

import java.util.UUID;

public class CarDtoFactory {

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
