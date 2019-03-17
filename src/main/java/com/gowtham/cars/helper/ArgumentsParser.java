package com.gowtham.cars.helper;


import com.gowtham.cars.exceptions.InvalidArgumentException;
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

    public void parseArgs(String[] args) throws InvalidArgumentException {
        CommandLine commandLine = null;
        try {
            List<Option> optionList = getOptionsList();
            Options options = new Options();

            for (Option option : optionList) {
                options.addOption(option);
            }

            CommandLineParser parser = new DefaultParser();
            commandLine = parser.parse(options, args);

            origin = commandLine.getOptionValue("o");

            numOfCars = Integer.parseInt(commandLine.getOptionValue("n"));
            if (numOfCars < 0) {
                throw new NumberFormatException();
            }

            String filePath = commandLine.getOptionValue("f");
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException("Given file: " + filePath + " not found");
            }

            this.file = file;
        } catch (ParseException e) {
            throw new InvalidArgumentException(e.getMessage(), e);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException("Invalid Input for number of cars: " + commandLine.getOptionValue("n"), e);
        } catch (FileNotFoundException e) {
            throw new InvalidArgumentException(e.getMessage(), e);
        }
    }

    public File getFile() {
        return file;
    }

    public int getNumOfCars() {
        return numOfCars;
    }

    public String getOrigin() {
        return origin;
    }
}
