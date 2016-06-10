package com.johnathanmsmith.mvc.web.model;

import java.util.ArrayList;

public class Car {
    private ArrayList<String> ListTable = new ArrayList<String>();

    public ArrayList<String> getListTable() {
        return ListTable;
    }

    public void addNewCar (String car) {
        this.ListTable.add(car);
        String buf = "";
        for (int i = 0; i < ListTable.size(); i++) {
            buf = buf + ListTable.get(i) + " ";
        }
        System.out.println("CONSOLE - ADD Car : " + buf);
    }

    public void removeCar (int index) {
        this.ListTable.remove(index);
        System.out.println("CONSOLE - DELETE Car : " + index);
    }

    public void editCar (int index, String car) {
        System.out.print("CONSOLE - EDIT Car : " + "по индексу " + index + " с записью " + ListTable.get(index));
        this.ListTable.set(index, car);
        System.out.println("на : " + ListTable.get(index));
    }
}