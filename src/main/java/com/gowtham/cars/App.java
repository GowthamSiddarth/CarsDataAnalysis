package com.gowtham.cars;

import com.gowtham.cars.exceptions.InvalidArgumentException;
import com.gowtham.cars.helper.ArgumentsParser;
import com.gowtham.cars.helper.ProcessData;
import com.gowtham.cars.models.Car;
import com.gowtham.cars.models.CarsFromOrigin;

import java.io.File;
import java.util.*;

public class App {
    public static void main(String[] args) {
        try {
            ArgumentsParser argumentsParser = new ArgumentsParser();
            argumentsParser.parseArgs(args);

            File dataset = argumentsParser.getFile();
            String origin = argumentsParser.getOrigin();
            int numOfCars = argumentsParser.getNumOfCars();
            boolean header = argumentsParser.isHeaderPresent();

            ProcessData processData = new ProcessData(dataset, header);
            HashMap<String, CarsFromOrigin> carsByOrigin = processData.getCarsByOrigin();

            CarsFromOrigin carsFromOrigin = carsByOrigin.getOrDefault(origin, new CarsFromOrigin());
            List<Car> filteredCars = processData.filterCarsWithHpMoreThanAvgHpWithLimit(carsFromOrigin, numOfCars);

            filteredCars.forEach(System.out::println);
        } catch (InvalidArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
