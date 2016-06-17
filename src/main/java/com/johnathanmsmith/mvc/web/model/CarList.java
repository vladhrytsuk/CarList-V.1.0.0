package com.johnathanmsmith.mvc.web.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarList {
    private List<Car> carListTable = new ArrayList<Car>();

    @Override
    public String toString() {
        return "CarList{" +
                "carListTable=" + carListTable +
                '}';
    }

    public List<Car> getCarListTable()
    {
        return carListTable;
    }

    public void setCarListTable(List<Car> carListTable)
    {
        this.carListTable = carListTable;
    }

    public boolean deleteCar (UUID Id)
    {
        for(int i = 0; i < getCarListTable().size(); i++)
        {
            if(getCarListTable().get(i).getId().equals(Id))
            {
                getCarListTable().remove(i);
                return true;
            }
        }
        System.out.println("CONSOLE - DELETE Car : " + carListTable.toString());
        return false;
    }

    public void addCar (Car car)
    {
        this.carListTable.add(car);
        System.out.println("CONSOLE - ADD Car : ");
    }

    public Car editCar (Car car)
    {
        for(int i = 0; i < getCarListTable().size(); i++)
        {
            if (getCarListTable().get(i).getId().equals(car.getId()))
            {
                System.out.print("CONSOLE - EDIT Car : " + "по индексу " + i + " с записью " + carListTable.get(i));
                this.carListTable.set(i, car);
                System.out.println("  на : " + carListTable.get(i));
            }
        }
        return car;
    }

}