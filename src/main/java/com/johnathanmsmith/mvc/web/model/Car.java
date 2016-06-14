package com.johnathanmsmith.mvc.web.model;

import java.util.UUID;

public class Car {

    private UUID id;
    private String mark;
    private String color;
    private int vin;
    private int miles;

    public Car() {
    }

    public Car(UUID id, String mark, String color, int vin, int miles) {
        this.id = id;
        this.mark = mark;
        this.color = color;
        this.vin = vin;
        this.miles = miles;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                ", vin=" + vin +
                ", miles=" + miles +
                '}';
    }

}