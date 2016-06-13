package com.johnathanmsmith.mvc.web;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Greed on 13.06.2016.
 */
public class CarDto {

   // @JsonProperty("mark")
     private String mark;
  //@JsonProperty("color")
     private String color;
  //  @JsonProperty("vin")
     private int vin;
  // @JsonProperty("miles")
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

    @Override
    public String toString() {
        return "CarDto{" +
                "mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                ", vin=" + vin +
                ", miles=" + miles +
                '}';
    }
}

