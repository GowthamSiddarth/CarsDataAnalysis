package com.gowtham.cars.helper;


import com.gowtham.cars.models.Car;
import com.gowtham.cars.models.SortedCars;

import java.io.*;
import java.util.HashMap;

public class ProcessData {
    private File dataset;
    private boolean header;

    public ProcessData(File dataset, boolean header) {
        this.dataset = dataset;
        this.header = header;
    }

    public HashMap<String, SortedCars> getSortedCarsByOrigin() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(dataset));
            if (header) {
                bufferedReader.readLine();
            }

            HashMap<String, SortedCars> sortedCarsByOrigin = new HashMap<>();
            RecordParser recordParser = new RecordParser();

            int index = 0;
            String line;
            while (null != (line = bufferedReader.readLine())) {
                recordParser.parseRecord(line);

                String carName = recordParser.getCarName();
                double horsePower = recordParser.getHorsePower();
                String origin = recordParser.getOrigin();

                Car car = new Car(index,carName, horsePower, origin);
                SortedCars sortedCars = sortedCarsByOrigin.getOrDefault(origin, new SortedCars());
                if (sortedCars.addCar(car))
                    sortedCarsByOrigin.put(origin, sortedCars);

                index++;
            }

            return sortedCarsByOrigin;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        return null;
    }
}
