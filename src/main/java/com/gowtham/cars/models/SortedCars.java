package com.gowtham.cars.models;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SortedCars {
    private double averageHorsePower;
    private Set<Car> cars;

    public SortedCars() {
        averageHorsePower = 0.0;
        cars = new TreeSet<Car>(new Comparator<Car>() {
            public int compare(Car car1, Car car2) {
                return Double.compare(car1.getHorsePower() - car2.getHorsePower(), 0.0);
            }
        });
    }

    public boolean addCar(Car car) {
        updateAverageHorsePower(car.getHorsePower());
        return cars.add(car);
    }

    private void updateAverageHorsePower(double newCarHorsePower) {
        averageHorsePower = (averageHorsePower * cars.size() + newCarHorsePower) / (cars.size() + 1);
    }
}
