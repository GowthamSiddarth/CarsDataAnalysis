package com.gowtham.cars.helper;

public class RecordParser {
    private String carName;
    private double horsePower;
    private String origin;

    public void parseRecord(String record) {
        String attributes[] = record.split(",");
        carName = attributes[0];
        origin = attributes[1];
        horsePower = Double.parseDouble(attributes[2]);
    }

    public String getCarName() {
        return carName;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public String getOrigin() {
        return origin;
    }
}
