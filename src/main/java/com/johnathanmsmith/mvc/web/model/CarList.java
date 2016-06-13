package com.johnathanmsmith.mvc.web.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> carListTable =new ArrayList<Car>();

    public List<Car> getCarListTable() {
        return carListTable;
    }

    public void setCarListTable(List<Car> carListTable) {
        this.carListTable = carListTable;
    }

    public void deleteCar (int index){
        carListTable.remove(index);
        System.out.println("CONSOLE - DELETE Car : " + index);
    }

    public void addCar (Car car){
        this.carListTable.add(car);
        System.out.println("CONSOLE - ADD Car : ");
    }

    public void editCar (int index, Car car) {
        System.out.print("CONSOLE - EDIT Car : " + "по индексу " + index + " с записью " + carListTable.get(index));
        this.carListTable.set(index, car);
        System.out.println("на : " + carListTable.get(index));
    }
}