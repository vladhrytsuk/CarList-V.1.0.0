package com.johnathanmsmith.mvc.web.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CarDto {

    @NotEmpty
    @Size(min = 2, max = 30, message = "Название автомобиля, должно иметь минимум 2 символа, и максимум 30 символов.")
    private String mark;

    @NotEmpty
    private String color;

    @Min(value = 1, message = "Vin номер автомобиля, должно начинаться минимум с 1.")
    private int vin;

    @Range(min = 1, max = 9999, message = "Указанный диапозон миль может находиться в пределах от 1 до 9999.")
    private int miles;

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
}

