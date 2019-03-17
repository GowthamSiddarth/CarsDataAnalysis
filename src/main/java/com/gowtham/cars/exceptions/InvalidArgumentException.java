package com.gowtham.cars.exceptions;

public class InvalidArgumentException extends Exception {
    public InvalidArgumentException(String message, Throwable err) {
        super(message, err);
    }
}
