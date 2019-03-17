package com.gowtham.cars.helper;


import com.gowtham.cars.models.Car;
import com.gowtham.cars.models.CarsFromOrigin;

import java.io.*;
import java.util.*;

public class ProcessData {
    private File dataset;
    private boolean header;

    public ProcessData(File dataset, boolean header) {
        this.dataset = dataset;
        this.header = header;
    }

    public HashMap<String, CarsFromOrigin> getCarsByOrigin() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(dataset));
            if (header) {
                bufferedReader.readLine();
            }

            HashMap<String, CarsFromOrigin> sortedCarsByOrigin = new HashMap<>();
            RecordParser recordParser = new RecordParser();

            String line;
            while (null != (line = bufferedReader.readLine())) {
                recordParser.parseRecord(line);

                String carName = recordParser.getCarName();
                double horsePower = recordParser.getHorsePower();
                String origin = recordParser.getOrigin();

                Car car = new Car(carName, horsePower, origin);
                CarsFromOrigin carsFromOrigin = sortedCarsByOrigin.getOrDefault(origin, new CarsFromOrigin());
                if (carsFromOrigin.addCar(car))
                    sortedCarsByOrigin.put(origin, carsFromOrigin);
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

    public List<Car> filterCarsWithHpMoreThanAvgHpWithLimit(CarsFromOrigin carsFromOrigin, int numOfCars) {
        Iterator<Car> sortedCarsItr = carsFromOrigin.getCars().iterator();
        List<Car> filteredCars = new ArrayList<>();

        int count = 0;
        while (count < numOfCars && sortedCarsItr.hasNext()) {
            Car car = sortedCarsItr.next();
            if (car.getHorsePower() > carsFromOrigin.getAverageHorsePower()) {
                filteredCars.add(car);
                count++;
            }
        }

        return filteredCars;
    }
}
