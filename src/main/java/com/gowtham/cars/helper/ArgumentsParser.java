package com.gowtham.cars.helper;


import java.io.File;

public class ArgumentsParser {
    private File file;
    private int numOfCars;
    private String origin;

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
