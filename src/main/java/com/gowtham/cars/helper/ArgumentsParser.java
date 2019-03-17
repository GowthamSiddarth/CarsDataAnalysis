package com.gowtham.cars.helper;


import org.apache.commons.cli.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class ArgumentsParser {
    private File file;
    private int numOfCars;
    private String origin;

    private List<Option> getOptionsList() {
        List<Option> options = new LinkedList<Option>();

        Option filePathOption = new Option("f", "file", true, "Path to the dataset file");
        filePathOption.setRequired(true);

        Option numOfCarsOption = new Option("n", "numOfCars", true, "Number of Cars queried");
        numOfCarsOption.setRequired(true);

        Option originOption = new Option("o", "origin", true, "Origin of cars");
        originOption.setRequired(true);

        options.add(filePathOption);
        options.add(numOfCarsOption);
        options.add(originOption);

        return options;
    }

    public File getFilePath() {
        return file;
    }

    public int getNumOfCars() {
        return numOfCars;
    }

    public String getOrigin() {
        return origin;
    }
}
