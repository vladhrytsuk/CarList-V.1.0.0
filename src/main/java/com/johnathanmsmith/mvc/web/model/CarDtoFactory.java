package com.johnathanmsmith.mvc.web.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.apache.log4j.spi.Configurator.NULL;

public class CarDtoFactory {
/*

    @Autowired
    CarList ct;
*/

    public CarDtoFactory() {

    }

    public Car SerializerCar (CarDto carDto, CarList ct) {
        Car car = new Car();
        car.setId(UUID.randomUUID());
        car.setMark(carDto.getMark());
        car.setColor(carDto.getColor());
        car.setVin(carDto.getVin());
        car.setMiles(carDto.getMiles());
        ct.addCar(car);
        return car;
    }

    public Car Error () {
        Car car = new Car();
        return car;
    }

}
