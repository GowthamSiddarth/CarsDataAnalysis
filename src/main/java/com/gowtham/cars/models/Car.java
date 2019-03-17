package com.gowtham.cars.models;

public class Car {
    private String name;
    private double horsePower;
    private String origin;

    public Car(String name, double horsePower, String origin) {
        this.name = name;
        this.horsePower = horsePower;
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return name + "," + horsePower + "," + origin;
    }
}
