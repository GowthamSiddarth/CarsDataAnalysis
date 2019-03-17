package com.gowtham.cars.models;

import java.util.Set;

public class SortedCars {
    private double averageHorsePower;
    private Set<Car> cars;

    public SortedCars() {
        averageHorsePower = 0.0;
    }

    public boolean addCar(Car car) {
        return cars.add(car);
    }
}
