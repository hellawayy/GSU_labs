package com.example.exceptions;

public class InvalidPriceException extends Exception {
    public InvalidPriceException(String message) {
        super(message);
    }
}