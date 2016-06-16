package com.johnathanmsmith.mvc.web.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarList {
    private List<Car> carListTable = new ArrayList<Car>();

    public List<Car> getCarListTable() {
        return carListTable;
    }

    public void setCarListTable(List<Car> carListTable) {
        this.carListTable = carListTable;
    }

    public Boolean deleteCar (UUID Id){
        List<Car> list = new ArrayList();
        for(Car item: getCarListTable()) {
          if(!item.getId().equals(Id))
              list.add(item);
        }
        carListTable = list;
        System.out.println("CONSOLE - DELETE Car : ");
        return true;
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