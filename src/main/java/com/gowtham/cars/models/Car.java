package com.gowtham.cars.models;

public class Car {
    private int index;
    private String name;
    private double horsePower;
    private String origin;

    public Car(int index, String name, double horsePower, String origin) {
        this.index = index;
        this.name = name;
        this.horsePower = horsePower;
        this.origin = origin;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return name + "," + horsePower + "," + origin;
    }
}
