package com.gowtham.cars;

import com.gowtham.cars.exceptions.InvalidArgumentException;
import com.gowtham.cars.helper.ArgumentsParser;
import com.gowtham.cars.helper.ProcessData;
import com.gowtham.cars.models.Car;
import com.gowtham.cars.models.SortedCars;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        try {
            ArgumentsParser argumentsParser = new ArgumentsParser();
            argumentsParser.parseArgs(args);

            File dataset = argumentsParser.getFile();
            String origin = argumentsParser.getOrigin();
            int numOfCars = argumentsParser.getNumOfCars();

            ProcessData processData = new ProcessData(dataset, true);
            HashMap<String, SortedCars> sortedCarsByOrigin = processData.getSortedCarsByOrigin();

            SortedCars sortedCarsInOrigin = sortedCarsByOrigin.getOrDefault(origin, new SortedCars());
            Iterator<Car> sortedCarsItr = sortedCarsInOrigin.getCars().iterator();

            int count = 0;
            while (count < numOfCars && sortedCarsItr.hasNext()) {
                Car car = sortedCarsItr.next();
                if (car.getHorsePower() > sortedCarsInOrigin.getAverageHorsePower()) {
                    System.out.println(car);
                }
                count++;
            }

        } catch (InvalidArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
