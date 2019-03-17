package com.gowtham.cars.helper;


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
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(dataset));
            if (header) {
                bufferedReader.readLine();
            }

            String line = null;
            HashMap<String, SortedCars> sortedCarsByOrigin = new HashMap<String, SortedCars>();
            do {
                line = bufferedReader.readLine();
            } while (null != line);

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
