package com.gowtham.cars;

import com.gowtham.cars.exceptions.InvalidArgumentException;
import com.gowtham.cars.helper.ArgumentsParser;

import java.io.File;

public class App {
    public static void main(String[] args) {
        try {
            ArgumentsParser argumentsParser = new ArgumentsParser();
            argumentsParser.parseArgs(args);

            File dataset = argumentsParser.getFile();
            String origin = argumentsParser.getOrigin();
            int numOfCars = argumentsParser.getNumOfCars();

        } catch (InvalidArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
