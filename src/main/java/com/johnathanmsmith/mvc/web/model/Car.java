package com.johnathanmsmith.mvc.web.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public class Car {

    private UUID id;
    @NotNull
    @Size(min=2, max=30)
    private String mark;

    @NotNull
    private String color;

    @Min(1)
    @Size(min=1, max=30)
    private int vin;

    @Min(1)
    @Size(min=1, max=9999999)
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