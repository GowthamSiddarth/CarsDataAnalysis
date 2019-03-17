package com.gowtham.cars.models;

import java.util.LinkedList;
import java.util.List;

public class CarsFromOrigin {
    private double averageHorsePower;
    private List<Car> cars;

    public CarsFromOrigin() {
        averageHorsePower = 0.0;
        cars = new LinkedList<>();
    }

    public boolean addCar(Car car) {
        updateAverageHorsePower(car.getHorsePower());
        return cars.add(car);
    }

    private void updateAverageHorsePower(double newCarHorsePower) {
        averageHorsePower = (averageHorsePower * cars.size() + newCarHorsePower) / (cars.size() + 1);
    }

    public double getAverageHorsePower() {
        return averageHorsePower;
    }

    public List<Car> getCars() {
        return cars;
    }
}
