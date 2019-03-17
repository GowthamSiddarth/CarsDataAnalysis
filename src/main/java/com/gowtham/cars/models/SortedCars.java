package com.gowtham.cars.models;

import java.util.Set;

public class SortedCars {
    private double averageHorsePower;
    private Set<Car> cars;

    public SortedCars() {
        averageHorsePower = 0.0;
    }

    public boolean addCar(Car car) {
        updateAverageHorsePower(car.getHorsePower());
        return cars.add(car);
    }

    private void updateAverageHorsePower(double newCarHorsePower) {
        averageHorsePower = (averageHorsePower * cars.size() + newCarHorsePower) / (cars.size() + 1);
    }
}
