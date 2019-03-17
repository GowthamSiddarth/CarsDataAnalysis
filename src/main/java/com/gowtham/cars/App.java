package com.gowtham.cars;

import com.gowtham.cars.exceptions.InvalidArgumentException;
import com.gowtham.cars.helper.ArgumentsParser;
import com.gowtham.cars.helper.ProcessData;
import com.gowtham.cars.models.SortedCars;

import java.io.File;
import java.util.HashMap;

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

            SortedCars sortedCarsInOrigin = sortedCarsByOrigin.get(origin);


        } catch (InvalidArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
